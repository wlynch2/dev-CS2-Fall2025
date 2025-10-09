package edu.westga.cs1302.task_tracker.model;

import edu.westga.cs1302.task_tracker.model.Task.TaskPriority;

import java.util.Comparator;

/** checks if the list is acending
 * 
 * @author wlynch2
 * @version cs1302
 */
public class Acending implements Comparator<Task> {
	
	/** compare the task to see if taskA is a lower or equal to priority than taskB
	 * 
	 * @param taskA first task
	 * @param taskB second task
	 * @return if the task priority of a is higher or equal to b
	 */
	@Override
	public int compare(Task taskA, Task taskB) {
		int tempNum = 0;
		if (taskA.getPriority() == TaskPriority.MEDIUM && taskB.getPriority() == TaskPriority.LOW) {
			tempNum = 1;
		}  else if (taskA.getPriority() == TaskPriority.HIGH && taskB.getPriority() == TaskPriority.LOW) {
			tempNum = 1;
		} else if (taskA.getPriority() == (taskB.getPriority())) {
			tempNum = 0;
		} else if (taskA.getPriority() == TaskPriority.HIGH && taskB.getPriority() == TaskPriority.MEDIUM) {
			tempNum = 1;
		}
		return tempNum;
		
	}
}
