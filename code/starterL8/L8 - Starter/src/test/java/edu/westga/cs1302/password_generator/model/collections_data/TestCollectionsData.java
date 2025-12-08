package edu.westga.cs1302.password_generator.model.collections_data;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.password_generator.model.CollectionsData;
import edu.westga.cs1302.password_generator.model.Comics;

public class TestCollectionsData {
	
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
	
	@Test
	void testComicsAreBeingAddedToList() {
		CollectionsData data = new CollectionsData("hello");
		Comics comic = new Comics("book", 12);
		
		data.addComic(comic);
		int size = data.getComicCollection().size();
		assertEquals(1, size);
	}
	
	@Test
	void testWhenNoComicsAreAddedToList() {
		CollectionsData data = new CollectionsData("hello");
		assertEquals(0, data.getComicCollection().size());
	}
}
