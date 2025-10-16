package edu.westga.cs1302.task_tracker.model;

import java.util.Comparator;

import edu.westga.cs1302.task_tracker.model.Task.TaskPriority;

/** used to check if taskOne is equal lower or higher than taskTwo and assign it a value respectively
 * purpose is to assign the items in a descending order to be used in MainWindow to order
 * the ListView objects in a descending order
 * 
 * 
 * @author wlynch2
 * @version cs1302 fall25
 */
public class Descending implements Comparator<Task> {
	
	/** compare the task to see if taskOne is higher, equal to or lower than taskB than assign it in a descending order
	 * if task ones eNum is assigned a higher value than task b than it will be assigned a negative number 
	 * if its lower it will be assigned positive and if equal it will be assigned 0
	 * this method will be used to take task objects in main window and if the user selects descending display the
	 * information in the listView in a descending order according to the priority
	 * 
	 * @param taskOne the first task you want compared
	 * @param taskTwo the second task you want compared
	 * 
	 * @precondition parameters cannot be null
	 * @postcondition none
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
			tempNum = 1;
		} else if (taskOne.getPriority() == TaskPriority.HIGH) {
			tempNum = -1;
		} else if (taskOne.getPriority() == TaskPriority.MEDIUM && taskTwo.getPriority() == TaskPriority.LOW) {
			tempNum = -1;
		} else if (taskOne.getPriority() == TaskPriority.MEDIUM && taskTwo.getPriority() == TaskPriority.HIGH) {
			tempNum = 1;
		}
		
		return tempNum;
		
	}
	
	/**
	 * overrides the java built in toString method to return Ascending instead
	 */
	@Override
	public String toString() {
		return "Descending";
	}
}
