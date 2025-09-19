package edu.westga.cs1302.javafx_sample_starter.model;

public class DataClass {
	
	public final String task;
	public String description;
	public final String  priority;
	
	public DataClass(String task, String description, String priority) {
		this.task = task;
		this.description = description;
		this.priority = priority;
	}
	
	public String getTask() {
		return task.toString();
	}
	
	public String getDescription() {
		return description.toString();
	}
	
	public String getPriority() {
		return priority.toString();
	}
}

