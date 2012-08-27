package com.racker.todo.resources;

import java.util.ArrayList;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;

import com.racker.todo.beans.Task;
import com.racker.todo.beans.TasksList;
import com.racker.todo.task.storage.TaskStore;
import com.racker.todo.util.ParamUtil;
import com.sun.jersey.api.NotFoundException;

/**
 * To create a To-Do task in the xml using @POST annotation.To retrieve a task using @GET
 * To change the state of a any task or to update it using @PUT
 * To remove or delete a task using @DELETE
 * 
 * @author
 *
 */
public class TaskResource {
	@Context
	UriInfo uriInfo;
	@Context
	Request request;
	String task;
	
	public TaskResource(UriInfo uriInfo, Request request, String contact) {
		this.uriInfo = uriInfo;
		this.request = request;
		this.task = contact;
	}
	
	/*
	 * Method to get the task
	 */
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Task getContact() {
		Task taskObject = TaskStore.getStore().get(task);
		if(taskObject==null)
			throw new NotFoundException("No such Contact.");
		return taskObject;
	}
	
	/*
	 * Method to create and fectch the task
	 */
	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	public Response putContact(JAXBElement<Task> jaxbContact) {
		Task c = jaxbContact.getValue();
		return putAndGetResponse(c);
	}
	
	/*
	 * Method to create the task
	 */
	@PUT
	public Response putk(@Context HttpHeaders herders, byte[] in) {
		Map<String,String> params = ParamUtil.parse(new String(in));
		TasksList c = new TasksList(params.get("id"), params.get("name"), 
				new ArrayList<Task>());
		return putAndGetResponse(c.getTasksList().get(0));
	}
	
	private Response putAndGetResponse(Task c) {
		Response res;
		if(TaskStore.getStore().containsKey(c.getId())) {
			res = Response.noContent().build();
		} else {
			res = Response.created(uriInfo.getAbsolutePath()).build();
		}
		TaskStore.getStore().put(String.valueOf(c.getId()), c);
		return res;
	}
	
	/*
	 * Method to delete the task
	 */
	@DELETE
	public void deleteContact() {
		Task c = TaskStore.getStore().remove(task);
		if(c==null)
			throw new NotFoundException("No such Task.");
	}
}
