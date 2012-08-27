package com.racker.todo.task.storage;

import java.util.HashMap;
import java.util.Map;

import com.racker.todo.beans.Task;
/**
 * Returns the added tasks
 * 
 * @author
 *
 */
public class TaskStore {
	private static Map<String,Task> store;
	private static TaskStore instance = null;
	
	private TaskStore() {
		store = new HashMap<String,Task>();
	}
	
	/*
	 *Method returns List of Tasks 
	 */
	public static Map<String,Task> getStore() {
		if(instance==null) {
			instance = new TaskStore();
		}
		return store;
	}
	
}
