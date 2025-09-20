package edu.westga.cs1302.javafx_sample_starter.model;

import java.util.ArrayList;

import edu.westga.cs1302.javafx_sample_starter.model.DataClass;

public class DataClassList {
	private ArrayList<DataClass> items;
	
	public DataClassList () {
		this.items = new ArrayList<DataClass>();
	}
	
	/** Adds the item to the dataClass
	 * 
	 * @precondition item != null
	 * @postcondition item is added to the list of items in the bill
	 * 
	 * @param item the item to be added to the bill
	 */
	public void addItem(DataClass item) {
		if (item == null) {
			throw new IllegalArgumentException("item must not be null.");
		}
		this.items.add(item);
	}

	/** Returns the list of items in the bill
	 * 
	 * @precondition none
	 * @postconition none
	 * 
	 * @return the list of items in the bill
	 */
	public ArrayList<DataClass> getItems() {
		return this.items;
	}

}

