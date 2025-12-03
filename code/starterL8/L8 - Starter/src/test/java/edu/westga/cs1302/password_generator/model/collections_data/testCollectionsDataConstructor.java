package edu.westga.cs1302.password_generator.model.collections_data;

import static org.junit.jupiter.api.Assertions.*; 

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.password_generator.model.CollectionsData;

public class testCollectionsDataConstructor {
	
	@Test
	void testWhenNameIsNull() {
		
		assertThrows(IllegalArgumentException.class, () -> {
			CollectionsData data = new CollectionsData(null);
		});
	}
	
	@Test
	void testValIsAddedProperly() {
		CollectionsData data = new CollectionsData("hello");
		assertEquals("hello", data.getName());
	}
}
