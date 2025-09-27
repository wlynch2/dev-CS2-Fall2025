package edu.westga.cs1302.project1.model.Count_Priority;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.javafx_sample_starter.model.PriorityCount;
import edu.westga.cs1302.javafx_sample_starter.model.TaskDetails;

public class TestGetPriorityCount {
	

	@Test
	void testWhenPriorityIsNull() {
		ArrayList<TaskDetails> list = new ArrayList<>();
		assertThrows(IllegalArgumentException.class, ()->{
			PriorityCount.getPriortyCount(null, list);
		});
	}
	
	@Test
	void testWhenListIsNull() {
	
		assertThrows(IllegalArgumentException.class, ()->{
			PriorityCount.getPriortyCount("", null);
		});
	}
	@Test
	void testWithMultipleValues() {
		ArrayList<TaskDetails> list = new ArrayList<>();
		
		list.add(new TaskDetails("", "", "high"));
		list.add(new TaskDetails("", "", "high"));
		list.add(new TaskDetails("", "", "high"));
		
		assertEquals(PriorityCount.getPriortyCount("high", list), 3);
	}
	
	@Test
	void testWithOneValue() {
		ArrayList<TaskDetails> list = new ArrayList<>();
		
		list.add(new TaskDetails("", "", "high"));

		
		assertEquals(PriorityCount.getPriortyCount("high", list), 1);
	}
	
	@Test
	void testWithMultipleDiffrentValuesHigh() {
		ArrayList<TaskDetails> list = new ArrayList<>();
		
		list.add(new TaskDetails("", "", "high"));
		list.add(new TaskDetails("", "", "med"));
		list.add(new TaskDetails("", "", "high"));
		list.add(new TaskDetails("", "", "low"));
	
		assertEquals(PriorityCount.getPriortyCount("high", list), 2);
	}
	
	@Test
	void testWithNoItems() {
		ArrayList<TaskDetails> list = new ArrayList<>();
		assertEquals(PriorityCount.getPriortyCount("high", list), 0);
	}
	
	@Test
	void testWithNoEqualItems() {
		ArrayList<TaskDetails> list = new ArrayList<>();
		
		list.add(new TaskDetails("", "", "high"));
		list.add(new TaskDetails("", "", "med"));
		list.add(new TaskDetails("", "", "high"));
		list.add(new TaskDetails("", "", "med"));
	
		assertEquals(PriorityCount.getPriortyCount("low", list), 0);
	}
	
	@Test
	void testItsCountingAtOnceMulipleValues() {
		ArrayList<TaskDetails> list = new ArrayList<>();
		
		list.add(new TaskDetails("", "", "high"));
		list.add(new TaskDetails("", "", "med"));
		list.add(new TaskDetails("", "", "high"));
		list.add(new TaskDetails("", "", "med"));
		list.add(new TaskDetails("", "", "low"));
	
		assertEquals(PriorityCount.getPriortyCount("low", list), 1);
		assertEquals(PriorityCount.getPriortyCount("med", list), 2);
		assertEquals(PriorityCount.getPriortyCount("high", list), 2);
	}

	
}
