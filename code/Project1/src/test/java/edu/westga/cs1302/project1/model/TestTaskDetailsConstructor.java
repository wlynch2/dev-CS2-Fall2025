package edu.westga.cs1302.project1.model;

import static org.junit.jupiter.api.Assertions.*;



import org.junit.jupiter.api.Test;

import edu.westga.cs1302.javafx_sample_starter.model.TaskDetails;


public class TestTaskDetailsConstructor {
	@Test
	void testWhenTaskIsNull() {
		assertThrows(IllegalArgumentException.class, ()->{
			TaskDetails task = new TaskDetails(null, "", "");
		});
	}
	
	@Test
	void testWhenDescriptionIsNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			TaskDetails task = new TaskDetails("", null, "");
		});
	}
	
	@Test
	void testWhenPriorityIsNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			TaskDetails task = new TaskDetails("", "", null);
		});
	}
	
	@Test
	void testValidGetTask() {
		TaskDetails task = new TaskDetails("1", "2", "3");
		assertEquals(task.getTask(), "1");
	}
	
	@Test
	void testValidGetDescription() {
		TaskDetails task = new TaskDetails("1", "2", "3");
		assertEquals(task.getDescription(), "2");
	}
	
	@Test
	void testValidGetPriority() {
		TaskDetails task = new TaskDetails("1", "2", "3");
		assertEquals(task.getPriority(), "3");
	}
	
	@Test
	void TestSetDescription() {
		TaskDetails task = new TaskDetails("1", "2", "3");
		task.setDescription("HELLO");
		assertEquals("HELLO", task.getDescription());
	}
	

}
