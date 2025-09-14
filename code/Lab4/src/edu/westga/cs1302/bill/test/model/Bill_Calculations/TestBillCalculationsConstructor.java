package edu.westga.cs1302.bill.test.model.Bill_Calculations;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


import edu.westga.cs1302.bill.model.BillItem;
import edu.westga.cs1302.bill.model.BillCalculations;
public class TestBillCalculationsConstructor {
	
	@Test
	void testIfnull() {
		assertThrows(IllegalArgumentException.class, ()->{BillCalculations.billCalculations(null);});
	}
	
	@Test
	void testReturnValue() {
		BillItem item = new BillItem("hello", 5);
		BillItem[] list = new BillItem[1];
		list[0] = item;
		assertEquals(5.0, BillCalculations.billCalculations(list));
	}
	
	@Test
	void testWithMultipleValues() {
		BillItem item = new BillItem("Hello", 5);
		BillItem item2 = new BillItem("World", 6);
		BillItem[] list = new BillItem[2];
		list[0] = item;
		list[1] = item2;
		assertEquals(11.0, BillCalculations.billCalculations(list));
	}
	
	@Test
	void testWithEmptyList() {
		BillItem[] list = new BillItem[0];
		assertEquals(0.0, BillCalculations.billCalculations(list));
		
	}
	
}
