package edu.westga.cs1302.task_tracker.model.ascending;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.task_tracker.model.Acending;
import edu.westga.cs1302.task_tracker.model.Task;
import edu.westga.cs1302.task_tracker.model.Task.TaskPriority;

class TestCompare {

	@Test
	void testWhenTaskOneIsNull() {
		Acending accend = new Acending();
		Task task = new Task("w", "w", TaskPriority.HIGH);

		assertThrows(IllegalArgumentException.class, () -> {
				accend.compare(null, task);
		});
		
	}
	
	@Test
	void testWhenTaskTwoIsNull() {
		Acending accend = new Acending();
		Task task = new Task("w", "w", TaskPriority.HIGH);

		assertThrows(IllegalArgumentException.class, () -> {
				accend.compare(task, null);
		});
		
	}
	@Test
	void testWhenTaskPriorityAreEqual() {
		Task task = new Task("w", "w", TaskPriority.HIGH);
		Task task2 = new Task("d","d", TaskPriority.HIGH);
		Acending accend = new Acending();
		int compareNum = accend.compare(task, task2);
		
		assertEquals(compareNum, 0);
	}
	
	@Test
	void testWhenTaskOneIsLower() {
		Task task = new Task("w", "w", TaskPriority.LOW);
		Task task2 = new Task("w", "w", TaskPriority.MEDIUM);
		Task task3 = new Task("w", "w", TaskPriority.HIGH);
		
		Acending accend = new Acending();
		int comapareNum = accend.compare(task, task2);
		int compareNumTwo = accend.compare(task2, task3);
		assertEquals(comapareNum, -1);
		assertEquals(compareNumTwo, -1);	
	}
	
	@Test
	void testWhenTaskOneIsHigher() {
		Task task = new Task("w", "w", TaskPriority.LOW);
		Task task2 = new Task("w", "w", TaskPriority.MEDIUM);
		Task task3 = new Task("w", "w", TaskPriority.HIGH);
		Acending accend = new Acending();
		int comapareNum = accend.compare(task2, task);
		int compareNum2 = accend.compare(task3, task2);
		assertEquals(comapareNum, 1);
		assertEquals(compareNum2, 1);
	}
	
	
}
