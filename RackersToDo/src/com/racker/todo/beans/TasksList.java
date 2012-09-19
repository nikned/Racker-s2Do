package com.racker.todo.beans;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Entity providers supply mapping services between representations and their associated Java types. 
 * 
 * @author
 */
@XmlRootElement
public class TasksList {
	private String id;
	private String name;
	private List<Task> tasksList;

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    private String temp;
	
	public TasksList() {}
	
	public TasksList(String id, String name, List<Task> tasks) {
		this.id = id;
		this.name = name;
		this.tasksList = tasks;
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
	 * Get the value of name
	 *
	 * @return the value of name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the value of name
	 *
	 * @param category new value of name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get the value of tasksList
	 *
	 * @return the value of tasksList
	 */
	@XmlElement(name="tasksList")
	public List<Task> getTasksList() {
		return tasksList;
	}

	/**
	 * Set the value of tasksList
	 *
	 * @param category new value of tasksList
	 */
	public void setTasksList(List<Task> tasksList) {
		this.tasksList = tasksList;
	}
	
}
