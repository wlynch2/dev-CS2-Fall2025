package edu.westga.cs1302.password_generator.model;

import java.util.ArrayList;

/**
 * Generates a random password based on the characteristics required.
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class CollectionsData {
	
	private String name;
	
	private ArrayList<Comics> comicCollection;
	
	/** constructor for CollectionsDataClass that assigns the field to a parameter
	 * 
	 * @param name the item being stored
	 */
	public CollectionsData(String name) {
		if (name == null) {
			throw new IllegalArgumentException("Name cannnot be null");
		}
		
		this.name = name;
		this.comicCollection = new ArrayList<Comics>();
	}

	/** getter method for CollectionsDataClass
	 *  
	 * @return a string value of the collection
	 */
	public String getName() {
		return this.name;
	}
	
	/** getter method for comicCollection
	 * 
	 * @return an arrayList of comics
	 */
	public ArrayList<Comics> getComicCollection(){
		return this.comicCollection;
	}
	
	/** method meant to add a selected comic to the list of comics
	 * 
	 * @precondition comic != null
	 * @postcondition none
	 * 
	 * @param comic a comic with a title and a issue number
	 */
	public void addComic(Comics comic) {
		if (comic == null) {
			throw new IllegalArgumentException("comic cannot be null");
		}
		
		this.comicCollection.add(comic);
	}
	
	@Override
	public String toString() {
		return this.name;
	}

}
