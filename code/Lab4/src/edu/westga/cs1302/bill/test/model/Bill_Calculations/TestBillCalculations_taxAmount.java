package edu.westga.cs1302.bill.test.model.Bill_Calculations;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.bill.model.BillItem;
import edu.westga.cs1302.bill.model.BillCalculations;

public class TestBillCalculations_taxAmount {

	@Test
	void testWhenItemIsEmpty() {
		assertThrows(IllegalArgumentException.class, ()->{BillCalculations.taxAmount(null);});
	}
	
	@Test
	void testTipAmountMethod() {
		BillItem item = new BillItem("hello", 10);
		BillItem[] list = new BillItem[1];
		list[0] = item;
		assertEquals(1.0, BillCalculations.taxAmount(list));
	}
	
	@Test
	void testTipWithMultipleItems() {
		BillItem item = new BillItem("hello", 10);
		BillItem item2 = new BillItem("World", 10);
		
		BillItem[] list = new BillItem[2];
		list[0] = item;
		list[1] = item2;
		assertEquals(2.0, BillCalculations.taxAmount(list));
	}
}
