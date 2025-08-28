package edu.westga.cs1302.lab2.model.test.model.bill;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.lab2.model.*;

class TestAddItem {

	@Test
	void testIfItemIsNull() {
		Bill bill = new Bill();
		
		assertThrows(IllegalArgumentException.class, () ->{
			bill.addItem(null);
		});
	}
	
	@Test
	void testWhenOneItemIsAdded() {
		Bill bill = new Bill();
		
		BillItem billItem = new BillItem("Hello", 0);
		bill.addItem(billItem);
		
		assertEquals(1, bill.getItems().size(), "test the length of the list");
	}
	
	

}
