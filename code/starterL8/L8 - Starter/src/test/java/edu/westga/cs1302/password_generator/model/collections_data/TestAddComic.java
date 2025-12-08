package edu.westga.cs1302.password_generator.model.collections_data;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.password_generator.model.CollectionsData;
import edu.westga.cs1302.password_generator.model.Comics;

public class TestAddComic {
	
	@Test
	void testWhenAddComicIsNull() {
		CollectionsData data = new CollectionsData("");
		
		
		assertThrows(IllegalArgumentException.class, () -> {data.addComic(null);});
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
	void testWhemMultipleItemsAreAddedToList() {
		CollectionsData data = new CollectionsData("hello");
		Comics comic = new Comics("book", 12);
		Comics comic2 = new Comics("book", 12);
		
		data.addComic(comic);
		data.addComic(comic2);
		
		assertEquals(2, data.getComicCollection().size());
		
	}
	
	@Test
	void testWhenNoItemsAreAddedToTheList(){
		CollectionsData data = new CollectionsData("hello");
		assertEquals(0, data.getComicCollection().size());
		
	}
}
