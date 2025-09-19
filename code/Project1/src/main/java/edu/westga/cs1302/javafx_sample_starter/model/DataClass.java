package edu.westga.cs1302.javafx_sample_starter.model;

public class DataClass {
	
	public final String name;
	public String description;
	public final String  priority;
	
	public DataClass(String name, String description, String priority) {
		this.name = name;
		this.description = description;
		this.priority = priority;
	}
	
	public String getName() {
		return name.toString();
	}
	
	public String getDescription() {
		return description.toString();
	}
	
	public String getPriority() {
		return priority.toString();
	}
}

