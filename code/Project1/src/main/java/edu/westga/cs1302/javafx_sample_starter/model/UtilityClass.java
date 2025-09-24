package edu.westga.cs1302.javafx_sample_starter.model;

import java.util.ArrayList;

public class UtilityClass {

	public static int getHighPriority(String priority, ArrayList<DataClass> list) {
    	int high = 0;  
    	
    	for (DataClass currList : list) {
    		if (currList.getPriority().equals("priority")) {
    			high++;
    		}
    	}
		return high;
	}
	

	
	
}
