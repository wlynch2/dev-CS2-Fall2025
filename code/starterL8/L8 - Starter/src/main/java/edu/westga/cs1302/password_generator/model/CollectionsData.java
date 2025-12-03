package edu.westga.cs1302.password_generator.model;

/**
 * Generates a random password based on the characteristics required.
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class CollectionsData {
	
	private String name;
	
	/** constructor for CollectionsDataClass that assigns the field to a paramater
	 * 
	 * @param name the item being stored
	 */
	public CollectionsData(String name) {
		if (name == null) {
			throw new IllegalArgumentException("Name cannnot be null");
		}
		
		this.name = name;
	}

	/** getter method for CollectionsDataClass
	 *  
	 * @return a string value of the collection
	 */
	public String getName() {
		return this.name;
	}
	
	@Override
	public String toString() {
		return this.name;
	}

}
