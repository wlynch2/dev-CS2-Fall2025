package edu.westga.cs1302.lab2.model.test.model.bill_item;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.lab2.model.*;

class TestConstructor {

	@Test
	void testWhenNameIsNull() {
		
		assertThrows(IllegalArgumentException.class, () ->{
			 new BillItem(null, 5);
		});
	}
	
	@Test
	void testWhenItemIs0() {
		assertThrows(IllegalArgumentException.class, () ->{
			new BillItem("hello", 0);
		});
	}
	
	@Test
	void testAtOneBelowBoundary() {
		assertThrows(IllegalArgumentException.class, () ->{
			new BillItem("HELLO", -1);
		});
	}
	
	@Test
	void TestAtOneAboveBoundary() {
		BillItem bill = new BillItem("Hello" , 1);
		
		assertEquals(1, bill.getAmount(), "test to assure that one above boundary runs");
	}
	
	@Test
	void testWhenNameIsntNull() {
		BillItem bill = new BillItem("hello", 1);
		assertEquals("hello", bill.getName(),"assuring that it returns the name when the program is ran");
	}

}
