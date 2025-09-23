package edu.westga.cs1302.javafx_sample_starter.model;

import java.util.ArrayList;

public class UtilityClass {

	public static int getHighPriority(String priority, ArrayList<DataClass> list) {
    	int high = 0;  
    	
    	for (DataClass currList : list) {
    		if (currList.getPriority().equals("High")) {
    			high++;
    		}
    	}
		return high;
	}
	
	public static int getMedPriority(String priority, ArrayList<DataClass> list) {
    	int med = 0;  
    	
    	for (DataClass currList : list) {
    		if (currList.getPriority().equals("High")) {
    			med++;
    		}
    	}
    	return med;
	}
	
	public static int getlowPriority(String priority, ArrayList<DataClass> list) {
    	int low = 0;  
    	
    	for (DataClass currList : list) {
    		if (currList.getPriority().equals("High")) {
    			low++;
    		}
    	}
    	return low;
	}
	
	
}
