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
		
		BillItem billItem = new BillItem("Hello", 3);
		bill.addItem(billItem);
		
		assertEquals(1, bill.getItems().size(), "test the length of the list");
	};
	
	@Test
	void testWhenMulitiplesItemsAreAdded() {
		Bill bill = new Bill();
		BillItem billItem = new BillItem("HEY", 2);
		BillItem billItem2 = new BillItem("PROFESSOR", 3);
		bill.addItem(billItem);
		bill.addItem(billItem2);
		
		assertEquals(2, bill.getItems().size(), "Test if it runs with multiple items in list");
	}
	
	

}
