package edu.westga.cs1302.task_tracker.model;

import edu.westga.cs1302.task_tracker.model.Task.TaskPriority;

import java.util.Comparator;

/** checks if the list is accending
 * 
 * @author wlynch2
 * @version cs1302
 */
public class Acending implements Comparator<Task> {
	
	/** compare the task to see if taskA is a lower or equal to priority than taskB
	 * 
	 * @Precondition parameters cannot be null
	 * 
	 * @param taskOne first task
	 * @param taskTwo second task
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
}
