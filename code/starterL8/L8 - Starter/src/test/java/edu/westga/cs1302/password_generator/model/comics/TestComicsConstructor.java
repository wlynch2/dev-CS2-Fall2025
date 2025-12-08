package edu.westga.cs1302.password_generator.model.comics;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.password_generator.model.CollectionsData;
import edu.westga.cs1302.password_generator.model.Comics;

public class TestComicsConstructor {
	
	@Test
	void testWhenTitleIsNull() {
		assertThrows(IllegalArgumentException.class, () ->{
			Comics comic = new Comics(null, 12);
		});
	}
	
	@Test 
	void testWhenTitleIsEmpty() {
		assertThrows(IllegalArgumentException.class, () ->{
			Comics comic = new Comics("", 12);
		});
	}
	
	@Test
	void testInvalisIssueNum() {
		assertThrows(IllegalArgumentException.class, () ->{
			Comics comic = new Comics("hello", -12);
		});
	}
	
	@Test
	void testTitleIsBeingAssigned() {
		Comics comic = new Comics("h", 12);
		
		assertEquals("h", comic.getTitle());
	}
	
	@Test
	void testIssueNumIsBeingAssigned() {
		Comics comic = new Comics("h", 12);
		
		assertEquals(12, comic.getIssueNumber());
	}
	
}
