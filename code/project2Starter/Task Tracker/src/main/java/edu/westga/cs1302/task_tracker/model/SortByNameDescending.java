package edu.westga.cs1302.task_tracker.model;

import java.util.Comparator;

/** sorts the list items by name
 * 
 * @author wlynch2
 * @version CS1302
 */
public class SortByNameDescending implements Comparator<Task> {

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
	
	@Override
	public String toString() {
		return "A-Z";
	}

}
