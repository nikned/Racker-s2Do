package com.racker.todo.beans;

import java.net.URI;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Entity providers supply mapping services between representations and their associated Java types
 * 
 * @author 
 *
 */
@XmlRootElement
public class Task {

	private String taskDescription;
	private String taskStatus;
	private String id;
	private String taskPriority;
	private String taskName;
	private URI taskUrl;
	private Date taskDueDate;
    private String taskCategory;
	
	public Task() {}
	
	public Task(String id, String taskDescription,Date date,String category,String priority,String status ){
		this.id=id;
		this.taskDueDate=date;
		this.taskPriority=priority;
		this.taskStatus=status;
		this.taskCategory=category;
		this.taskDescription=taskDescription;
	}
	
	/**
	 * Get the value of taskUrl
	 *
	 * @return the value of taskUrl
	 */
	public URI getTaskUrl() {
		return taskUrl;
	}
	
	/**
	 * Set the value of taskUrl
	 *
	 * @param category new value of taskUrl
	 */
	public void setTaskUrl(URI taskUrl) {
		this.taskUrl = taskUrl;
	}

    /**
	 * Get the value of taskDueDate
	 *
	 * @return the value of taskDueDate
	 */
	public Date getTaskDueDate() {
		return taskDueDate;
	}
	
	/**
	 * Set the value of taskDueDate
	 *
	 * @param category new value of taskDueDate
	 */
	public void setTaskDueDate(Date taskDueDate) {
		this.taskDueDate = taskDueDate;
	}

	/**
	 * Get the value of taskCategory
	 *
	 * @return the value of taskCategory
	 */
	public String getTaskCategory() {
		return taskCategory;
	}
	
	/**
	 * Set the value of taskCategory
	 *
	 * @param category new value of taskCategory
	 */
	public void setTaskCategory(String taskCategory) {
		this.taskCategory = taskCategory;
	}

	/**
	 * Get the value of taskName
	 *
	 * @return the value of taskName
	 */
	public String getTaskName() {
		return taskName;
	}
	
	/**
	 * Set the value of taskName
	 *
	 * @param category new value of taskName
	 */
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	
	/**
	 * Get the value of taskDescription
	 *
	 * @return the value of taskDescription
	 */
	public String getTaskDescription() {
		return taskDescription;
	}
	
	/**
	 * Set the value of taskDescription
	 *
	 * @param category new value of taskDescription
	 */
	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

	/**
	 * Get the value of taskStatus
	 *
	 * @return the value of taskStatus
	 */
	public String getTaskStatus() {
		return taskStatus;
	}

	/**
	 * Set the value of taskStatus
	 *
	 * @param category new value of taskStatus
	 */
	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}
	
	/**
	 * Get the value of id
	 *
	 * @return the value of id
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * Set the value of id
	 *
	 * @param category new value of id
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * Get the value of taskPriority
	 *
	 * @return the value of taskPriority
	 */
	public String getTaskPriority() {
		return taskPriority;
	}

	/**
	 * Set the value of taskPriority
	 *
	 * @param category new value of taskPriority
	 */
	public void setTaskPriority(String taskPriority) {
		this.taskPriority = taskPriority;
	}

	public Task(String id, String taskDescription) {
		this.id = id;
		this.taskDescription = taskDescription;
	}

	

}
