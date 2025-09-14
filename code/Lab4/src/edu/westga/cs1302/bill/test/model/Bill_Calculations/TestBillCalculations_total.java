package edu.westga.cs1302.bill.test.model.Bill_Calculations;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.bill.model.BillItem;
import edu.westga.cs1302.bill.model.BillCalculations;

public class TestBillCalculations_total {
	@Test
	void testWhenItemIsEmpty() {
		assertThrows(IllegalArgumentException.class, ()->{BillCalculations.total(null);});
	}
	
	@Test
	void testTipAmountMethod() {
		BillItem item = new BillItem("hello", 10);
		BillItem[] list = new BillItem[1];
		list[0] = item;
		assertEquals(13, BillCalculations.total(list));
	}
	
	@Test
	void testTipWithMultipleItems() {
		BillItem item = new BillItem("hello", 10);
		BillItem item2 = new BillItem("World", 10);
		
		BillItem[] list = new BillItem[2];
		list[0] = item;
		list[1] = item2;
		assertEquals(26, BillCalculations.total(list));
	}
}
