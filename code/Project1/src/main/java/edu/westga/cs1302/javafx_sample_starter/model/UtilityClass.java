package edu.westga.cs1302.javafx_sample_starter.model;

import java.util.ArrayList;

public class UtilityClass {

	public static int getHighPriority(String priority, ArrayList<TaskDetails> list) {
    	int high = 0;  
    	
    	for (TaskDetails currList : list) {
    		if (currList.getPriority().equals("priority")) {
    			high++;
    		}
    	}
		return high;
	}
	

	
	
}
