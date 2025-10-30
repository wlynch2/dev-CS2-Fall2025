package edu.westga.cs1302.task_tracker.model.containerClass;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.task_tracker.model.ContainerClass;
import edu.westga.cs1302.task_tracker.model.Task;
import edu.westga.cs1302.task_tracker.model.Task.TaskPriority;

public class TestContainerClassConstructor {
	@Test
	void testWhenNameIsNull() {
		assertThrows(IllegalArgumentException.class,() ->{
			ContainerClass container = new ContainerClass(null, "", TaskPriority.HIGH);
		});
	}
	
	@Test
	void testWhenDescriptionIsNull() {
		assertThrows(IllegalArgumentException.class,() ->{
			ContainerClass container = new ContainerClass(":", null, TaskPriority.HIGH);
		});
	}
	
	@Test
	void testWhenPriorityIsNull() {
		assertThrows(IllegalArgumentException.class,() ->{
			ContainerClass container = new ContainerClass("HE", "e", null);
		});
	}
	
	@Test
	void testValidArgument() {
		ContainerClass result = new ContainerClass("1", "2", TaskPriority.HIGH);
		assertEquals("1", result.getName());
		assertEquals("2", result.getDescription());
		assertEquals(TaskPriority.HIGH, result.getPriority());
	}
	
	
}
