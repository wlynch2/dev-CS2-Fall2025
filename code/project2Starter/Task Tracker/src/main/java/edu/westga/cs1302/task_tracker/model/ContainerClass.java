package edu.westga.cs1302.task_tracker.model;

import java.util.ArrayList;
import java.util.List;

/**class meant to take a task object and add subtask to it and store said subtask in a
 * seperate list, but still connected to said task object
 * 
 * @author wlynch2
 * @version CS1302
 */
public class ContainerClass extends Task {
	
	private ArrayList<Task> subTask;
	
	public ContainerClass(String name, String description, TaskPriority priority) {
	
		super(name, description, priority);
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
	 * @return a String
	 */
	@Override
	public String toString() {
		return name;
	}
}
