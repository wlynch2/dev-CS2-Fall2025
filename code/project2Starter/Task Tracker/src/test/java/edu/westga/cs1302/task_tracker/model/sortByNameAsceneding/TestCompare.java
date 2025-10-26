package edu.westga.cs1302.task_tracker.model.sortByNameAsceneding;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.task_tracker.model.SortByNameAscending;
import edu.westga.cs1302.task_tracker.model.Task;
import edu.westga.cs1302.task_tracker.model.Task.TaskPriority;

public class TestCompare {
	
	@Test
	public void testWhenO1IsNull() {
		Task task = new Task("name", "descr", TaskPriority.HIGH);
		SortByNameAscending ascend = new SortByNameAscending();
		assertThrows(IllegalArgumentException.class, () ->{
			ascend.compare(null, task);
		});	
	}
	
	@Test
	public void testWhenO2IsNull() {
		Task task = new Task("name", "descr", TaskPriority.HIGH);
		SortByNameAscending ascend = new SortByNameAscending();
		assertThrows(IllegalArgumentException.class, () ->{
			ascend.compare(task, null);
		});	
	}
	
	@Test
	public void testWhenTaskOneIsEqualTaskTwo() {
		Task task = new Task("A", "descr", TaskPriority.HIGH);
		Task task2 = new Task("A", "descr", TaskPriority.LOW);
		
		SortByNameAscending ascend = new SortByNameAscending();
		
		assertEquals(0, ascend.compare(task, task2));
	}
	
	@Test
	public void testWhenTaskOneIsHigherThanTaskTwo() {
		Task task = new Task("A", "descr", TaskPriority.HIGH);
		Task task2 = new Task("B", "descr", TaskPriority.LOW);
		
		SortByNameAscending ascend = new SortByNameAscending();
		
		assertEquals(1, ascend.compare(task, task2));
	}
	
	@Test 
	public void testWhenTaskOneIsLowerThanTaskTwo() {
		Task task = new Task("A", "descr", TaskPriority.HIGH);
		Task task2 = new Task("B", "descr", TaskPriority.LOW);
		
		SortByNameAscending ascend = new SortByNameAscending();
		
		assertEquals(-1, ascend.compare(task2, task));
	}
	
	@Test
	public void TestWhenTaskOneIsUpperCase() {
		Task task = new Task("A", "descr", TaskPriority.HIGH);
		Task task2 = new Task("a", "descr", TaskPriority.LOW);
		
		SortByNameAscending ascend = new SortByNameAscending();
		
		assertEquals(1, ascend.compare(task, task2));
	}
	
	@Test
	public void TestWhenTaskOneLowerCase() {
		Task task = new Task("b", "descr", TaskPriority.HIGH);
		Task task2 = new Task("B", "descr", TaskPriority.LOW);
		
		SortByNameAscending ascend = new SortByNameAscending();
		
		assertEquals(-1, ascend.compare(task, task2));
	}
}
