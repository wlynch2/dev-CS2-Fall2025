package edu.westga.cs1302.javafx_sample_starter.model;

import java.util.ArrayList;

/**
 * utility class the handles the counting of each priority for main window
 * 
 * @author wlynch2
 * @version CS1302 Fall 2025
 */
public class PriorityCount {
	
	/**
	 * used to add 1 to each priority when it is in the list pretty much counts the selected priority items in the list
	 * 
	 * @param priority the priority that is selected - cannot be null
	 * @param list the items in the listView - cannot be null
	 * @return count - the amount of the selected priority

	 */
	public static int getPriortyCount(String priority, ArrayList<TaskDetails> list) {
		if (priority == null) {
			throw new IllegalArgumentException("priority cannot be null");
		}
		
		if (list == null) {
			throw new IllegalArgumentException("list cannot be null");
		}
    	int count = 0;  
    	
    	for (TaskDetails currList : list) {
    		if (currList.getPriority().equals(priority)) {
    			count++;
    		}
    	}
		return count;
	}
	
}
