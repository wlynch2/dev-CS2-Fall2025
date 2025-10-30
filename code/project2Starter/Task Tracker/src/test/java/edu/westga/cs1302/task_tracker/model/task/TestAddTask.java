package edu.westga.cs1302.task_tracker.model.task;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.task_tracker.model.ContainerClass;
import edu.westga.cs1302.task_tracker.model.Task;
import edu.westga.cs1302.task_tracker.model.Task.TaskPriority;

public class TestAddTask {
	
	@Test
	void testWhenASubTaskIsAdded() {
		Task mainTask = new Task("hi", "dr", TaskPriority.HIGH);
		Task subTask = new Task("Corley", "Please", TaskPriority.MEDIUM);
		
		ContainerClass result = mainTask.addTask(subTask);
		
		assertTrue(result.getSubTask().contains(subTask));
	}
	
	@Test
	void testWhenCurrTaskIsNull() {
		Task mainTask = new Task("give", "me", TaskPriority.HIGH);
		
		
		assertThrows(IllegalArgumentException.class, ()->{
			mainTask.addTask(null);
		});
	}
	
	@Test
	void testCurrTaskNameMatch() {
		Task mainTask = new Task("an", "A!!!", TaskPriority.HIGH) ;
		Task subTask = new Task("PLEASE", "ok", TaskPriority.LOW);
		
		ContainerClass result = mainTask.addTask(subTask);
		assertEquals(result.getName(), "an");
	}
	
	@Test
	void testCurrTaskDescriptionMatch() {
		Task mainTask = new Task("im", "done", TaskPriority.HIGH) ;
		Task subTask = new Task("lol", "HE HE HE HA", TaskPriority.LOW);
		
		ContainerClass result = mainTask.addTask(subTask);
		assertEquals(result.getDescription(), "done");
	}
	
	@Test
	void testCurrTaskPriorityMatch() {
		Task mainTask = new Task("im", "done", TaskPriority.HIGH) ;
		Task subTask = new Task("lol", "HE HE HE HA", TaskPriority.LOW);
		
		ContainerClass result = mainTask.addTask(subTask);
		assertEquals(result.getPriority(), TaskPriority.HIGH);
	}
	
	@Test
	void testWhenMultipleSubTaskAreAdded() {
		Task mainTask = new Task("an", "A!!!", TaskPriority.HIGH) ;
		Task subTask = new Task("PLEASE", "ok", TaskPriority.LOW);
		Task subTask2 = new Task("1", "2", TaskPriority.MEDIUM);
		Task subTask3 = new Task ("3", "4", TaskPriority.HIGH);
		
		ContainerClass result = mainTask.addTask(subTask);
		result.addTask(subTask2);
		result.addTask(subTask3);
		
		assertTrue(result.getSubTask().contains(subTask));
		assertTrue(result.getSubTask().contains(subTask2));
		assertTrue(result.getSubTask().contains(subTask3));
	}
	
	@Test
	void testWhenNoSubTaskAreAdded() {
		Task mainTask = new Task("an", "A!!!", TaskPriority.HIGH) ;
		assertThrows(IllegalArgumentException.class,() ->{
			ContainerClass result = mainTask.addTask(null);
		});
		
	}
	

}
