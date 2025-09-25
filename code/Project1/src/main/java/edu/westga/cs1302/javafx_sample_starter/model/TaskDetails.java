package edu.westga.cs1302.javafx_sample_starter.model;

/**
 * data class that stores the users input in a object
 * 
 * @author wlynch2
 * @version Fall2025
 */
public class TaskDetails {
	
	private final String task;
	private String description;
	private final String  priority;
	
	/**
	 * Constructor for DataClass stores assigns the instance variables to the params
	 * 
	 * @param task String is the task for the user cannot be null
	 * @param description String - description for the users task cannot be null
	 * @param priority String - stores the priority of the users task cannot be null
	 */
	public TaskDetails(String task, String description, String priority) {
		if (task == null) {
			throw new IllegalArgumentException("task cannot be null");
		}
		if (description == null) {
			throw new IllegalArgumentException("descriptino cannot be null");
		}
		if (priority == null) {
			throw new IllegalArgumentException("priority cannot be null");
		}
		
		this.task = task;
		this.description = description;
		this.priority = priority;
	}
	
	/**
	 * getter method to grab the users task
	 * @return String task the users task
	 */
	public String getTask() {
		return this.task;
	}
	
	/**
	 * getter method to get the users description
	 * @return String description - the users description
	 */
	public String getDescription() {
		return this.description;
	}
	
	/**
	 * getter method to get the users priority
	 * @return String priority - the users priority
	 */
	public String getPriority() {
		return this.priority;
	}
	
	/**
	 * setter method for the users description used to set the description
	 * @param description String used to set the description of whatever string is in the param
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * 
	 * method to overide the java built in toString method 
	 * return task returns the users task but as a string
	 * 
	 */
	public String toString() {
		return this.task;
	}
}

