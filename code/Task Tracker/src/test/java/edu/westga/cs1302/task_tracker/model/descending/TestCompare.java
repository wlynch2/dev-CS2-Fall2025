package edu.westga.cs1302.task_tracker.model.descending;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.task_tracker.model.Descending;
import edu.westga.cs1302.task_tracker.model.Task;
import edu.westga.cs1302.task_tracker.model.Task.TaskPriority;;

class TestCompare {

	@Test
	void testWhenTaskOneIsNull() {
		Descending descend = new Descending();
		Task task = new Task("h","h", TaskPriority.HIGH);
		assertThrows(IllegalArgumentException.class, () ->{
			descend.compare(null, task);
		});
	}
	
	@Test
	void testWhenTaskTwoIsNull() {
		Descending descend = new Descending();
		Task task = new Task("h","h", TaskPriority.HIGH);
		assertThrows(IllegalArgumentException.class, () ->{
			descend.compare(task, null);
		});
	}
	
	@Test
	void testWhenTaskPrioritysAreEqual() {
		Descending descend = new Descending();
		Task task = new Task("h", "h", TaskPriority.HIGH);
		Task task2 = new Task("h", "h", TaskPriority.HIGH);
		
		assertEquals(descend.compare(task, task2), 0);
	}
	
	@Test
	void testWhenTaskOnePriorityIsHigher() {
		Descending descend = new Descending();
		Task task = new Task("h", "h", TaskPriority.HIGH);
		Task task2 = new Task("h", "h", TaskPriority.MEDIUM);
		Task task3 = new Task("h", "h", TaskPriority.LOW);
		
		assertEquals(descend.compare(task, task2), -1);
		assertEquals(descend.compare(task2, task3), -1);
	}
	
	@Test
	void testWhenTaskOnePriorityIsLower() {
		Descending descend = new Descending();
		Task task = new Task("h", "h", TaskPriority.HIGH);
		Task task2 = new Task("h", "h", TaskPriority.MEDIUM);
		Task task3 = new Task("h", "h", TaskPriority.LOW);
		
		assertEquals(descend.compare(task2, task), 1);
		assertEquals(descend.compare(task3, task2), 1);
	}

}
