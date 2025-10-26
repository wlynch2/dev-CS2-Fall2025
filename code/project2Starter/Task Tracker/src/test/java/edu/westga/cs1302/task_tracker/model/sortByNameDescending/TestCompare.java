package edu.westga.cs1302.task_tracker.model.sortByNameDescending;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.task_tracker.model.SortByNameDescending;
import edu.westga.cs1302.task_tracker.model.Task;
import edu.westga.cs1302.task_tracker.model.Task.TaskPriority;

public class TestCompare {
	
	@Test
	public void testWhenO1IsNull() {
		Task task = new Task("name", "descr", TaskPriority.HIGH);
		SortByNameDescending descend = new SortByNameDescending();
		assertThrows(IllegalArgumentException.class, () ->{
			descend.compare(null, task);
		});	
	}
	
	@Test
	public void testWhenO2IsNull() {
		Task task = new Task("name", "descr", TaskPriority.HIGH);
		SortByNameDescending descend = new SortByNameDescending();
		assertThrows(IllegalArgumentException.class, () ->{
			descend.compare(task, null);
		});	
	}
	
	@Test
	public void testWhenTaskOneIsEqualTaskTwo() {
		Task task = new Task("A", "descr", TaskPriority.HIGH);
		Task task2 = new Task("A", "descr", TaskPriority.LOW);
		
		SortByNameDescending descend = new SortByNameDescending();
		
		assertEquals(0, descend.compare(task, task2));
	}
	
	@Test
	public void testWhenTaskOneIsHigherThanTaskTwo() {
		Task task = new Task("A", "descr", TaskPriority.HIGH);
		Task task2 = new Task("B", "descr", TaskPriority.LOW);
		
		SortByNameDescending descend = new SortByNameDescending();
		
		assertEquals(-1, descend.compare(task, task2));
	}
	
	@Test 
	public void testWhenTaskOneIsLowerThanTaskTwo() {
		Task task = new Task("A", "descr", TaskPriority.HIGH);
		Task task2 = new Task("B", "descr", TaskPriority.LOW);
		
		SortByNameDescending descend = new SortByNameDescending();
		
		assertEquals(1, descend.compare(task2, task));
	}
	
	@Test
	public void TestWhenTaskOneIsUpperCase() {
		Task task = new Task("A", "descr", TaskPriority.HIGH);
		Task task2 = new Task("a", "descr", TaskPriority.LOW);
		
		SortByNameDescending descend = new SortByNameDescending();
		
		assertEquals(-1, descend.compare(task, task2));
	}
	
	@Test
	public void TestWhenTaskOneLowerCase() {
		Task task = new Task("b", "descr", TaskPriority.HIGH);
		Task task2 = new Task("B", "descr", TaskPriority.LOW);
		
		SortByNameDescending descend = new SortByNameDescending();
		
		assertEquals(1, descend.compare(task, task2));
	}
}
