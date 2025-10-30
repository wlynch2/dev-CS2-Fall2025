package edu.westga.cs1302.task_tracker.model;

import java.util.Comparator;

/** Compare two Tasks to identify the correct Ascending ordering of the tasks based by name
 * 
 * @author wlynch2
 * @version CS1302
 */
public class SortByNameDescending implements Comparator<Task> {

	/** Returns a value indicating ordering of the two tasks based 
	 *  on Descending name values.
	 * 
	 * @precondition o1 && o2 != null
	 * @postcondition none
	 * 
	 * return 0 if o1 == 0 o2
	 *        -1 if o1 > o2
	 *        1 if o1 < o2
	 */
	@Override
	public int compare(Task o1, Task o2) {
		if (o1 == null) {
			throw new IllegalArgumentException("Task one cannot be null");
		}
		if (o2 == null) {
			throw new IllegalArgumentException("Task two cannot be null");
		}
		int result = 0;
		if (o1.getName().equals(o2.getName())) {
			result = 0;
		} else if (o1.getName().compareTo(o2.getName()) < 0) {
			result = -1;
		} else if (o1.getName().compareTo(o2.getName()) > 0) {
			result = 1;
		}
		
		return result;
	}
	
	/** Returns the name of the task to represent the task as a String
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the name of the task
	 */
	@Override
	public String toString() {
		return "A-Z";
	}

}
