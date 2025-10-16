package edu.westga.cs1302.task_tracker.model;

import edu.westga.cs1302.task_tracker.model.Task.TaskPriority;

import java.util.Comparator;

/** used to check if taskOne is equal lower or higher than taskTwo and assign it a value respectively
 * purpose is to assign the items in a Ascending order to be used in MainWindow to order
 * the ListView objects in a Ascending order
 * 
 * @author wlynch2
 * @version cs1302
 */
public class Ascending implements Comparator<Task> {
	
	/** compare the task to see if taskA is a higher, lower or equal to priority the priority of taskB
	 * if task ones eNum is assigned a higher value than task b than it will be assigned a positive number 
	 * if its lower it will be assigned negative and if equal it will be assigned 0
	 * this method will be used to take task objects in main window and if the user selects descending display the
	 * information in the listView in a descending order according to the priority
	 * 
	 * @precondition parameters cannot be null
	 * @postcondition none
	 * 
	 * @param taskOne first task you want compared
	 * @param taskTwo second task you want compared
	 * @return if the task priority of a is higher or equal to b
	 */
	@Override
	public int compare(Task taskOne, Task taskTwo) {
		if (taskOne == null) {
			throw new IllegalArgumentException("taskA cannot be null");
		}
		if (taskTwo == null) {
			throw new IllegalArgumentException("taskB cannot be null");
		}
		
		int tempNum = 0;
		
		if (taskOne.getPriority() == taskTwo.getPriority()) {
			tempNum = 0;
		}  else if (taskOne.getPriority() == TaskPriority.LOW) {
			tempNum = -1;
		} else if (taskOne.getPriority() == TaskPriority.HIGH) {
			tempNum = 1;
		} else if (taskOne.getPriority() == TaskPriority.MEDIUM && taskTwo.getPriority() == TaskPriority.LOW) {
			tempNum = 1;
		} else if (taskOne.getPriority() == TaskPriority.MEDIUM && taskTwo.getPriority() == TaskPriority.HIGH) {
			tempNum = -1;
		}
		
		return tempNum;
		
	}
	
	/**
	 * overrides the java built in toString method to return Ascending instead
	 */
	@Override
	public String toString() {
		return "Ascending";
	}
}
