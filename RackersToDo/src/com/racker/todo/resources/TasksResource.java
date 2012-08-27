package com.racker.todo.resources;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.racker.todo.beans.Task;
import com.racker.todo.task.storage.TaskStore;

/**
 * Root resource classes are POJOs that are annotated with @Path and 
 * have methods are  annotated with @Path or a request method designator,
 * such as @GET, @PUT, @POST, or @DELETE
 * 
 * @author
 *
 */
@Path("/tasks")
public class TasksResource {

	@Context
	UriInfo uriInfo;
	@Context
	Request request;

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Task> getContacts() {
		List<Task> contacts = new ArrayList<Task>();
		if (!TaskStore.getStore().isEmpty())
			contacts.addAll(TaskStore.getStore().values());
		return contacts;
	}

	@GET
	@Path("count")
	@Produces(MediaType.TEXT_PLAIN)
	public String getCount() {
		int count = TaskStore.getStore().size();
		return String.valueOf(count);
	}

	@POST
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void newContact(@FormParam("taskID") String id,
			@FormParam("q6_task2") String taskDescription,
			@FormParam("q4_when2[month]") int month,
			@FormParam("q4_when2[day]") int day,
			@FormParam("q4_when2[year]") int year,
			@FormParam("q4_when2[hour]") int hours,
			@FormParam("q4_when2[min]") int mins,
			@FormParam("q4_when2[ampm]") String meridian,
			@FormParam("q7_category") String category,
			@FormParam("q8_priority") String priority,
			@FormParam("q9_status") String status,
			@Context HttpServletResponse servletResponse

	) throws IOException {
		URI uri = uriInfo.getAbsolutePathBuilder().path(id).build();
		Response.created(uri).build();
		Date date = new GregorianCalendar(year, month, day, hours, mins)
				.getTime();
		Task c = new Task(id, taskDescription, date, category, priority, status);
		c.setTaskUrl(uri);
		TaskStore.getStore().put(id, c);
		
	}

	@Path("{task}")
	public TaskResource getContact(@PathParam("task") String contact) {
		return new TaskResource(uriInfo, request, contact);
	}

}
