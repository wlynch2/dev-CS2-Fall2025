package edu.westga.cs1302.task_tracker.model;

import java.util.ArrayList;
import java.util.List;

/**class meant to take a task object and add subtask to it and store said subtask in a
 * separate list, but still connected to said task object
 * 
 * @author wlynch2
 * @version CS1302
 */
public class ContainerClass extends Task {
	
	private ArrayList<Task> subTask;
	
	/** Constructor for ContainerClass class, also has its parents Constructor
	 * 
	 * @precondition name && description && priority cannot be null
	 * @postcondition none
	 * 
	 * @param name the name of the replaced task
	 * @param description the description of the replaced task
	 * @param priority the priority of the replaced task
	 */
	public ContainerClass(String name, String description, TaskPriority priority) {
		super(name, description, priority);
		
		if (name == null) {
			throw new IllegalArgumentException("name cannot be null");
		}
		if (description == null) {
			throw new IllegalArgumentException("description cannot be null");
		}
		if (priority == null) {
			throw new IllegalArgumentException("priority cannot be null");
		}
		
		this.subTask = new ArrayList<Task>();
	}
	
	/** method meant to add a subTask to the current task
	 * 
	 * 
	 * @Precondition currTask cannot be null
	 * @postcondition none
	 * 
	 * @param currTask the task you want to add a subTask for
	 * @return a container object
	 */
	@Override
	public ContainerClass addTask(Task currTask) {
		if (currTask == null) {
			throw new IllegalArgumentException("currTask cannot be null");
		}
		this.subTask.add(currTask);
		return this;
		
	}
	
	/** gets the list of subTask
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return subTask field declared as an arrayList
	 */
	@Override
	public List<Task> getSubTask() {
		return this.subTask;
	}
	
	/** Overrides java built in toString method
	 * 
	 * @return the name of the task object
	 */
	@Override
	public String toString() {
		return name;
	}
}
