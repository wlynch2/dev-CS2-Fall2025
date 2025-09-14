package edu.westga.cs1302.bill.test.model.Bill_Calculations;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.bill.model.Bill;
import edu.westga.cs1302.bill.model.BillItem;
import edu.westga.cs1302.bill.model.BillCalculations;
public class TestBillCalculationsConstructor {
	
	@Test
	void testIfNoBillItem() {
		assertThrows(IllegalArgumentException.class, ()->{BillCalculations.billCalculations(null);});
	}
	
	@Test
	void testCalculations() {
		BillItem item = new BillItem("hello", 5);
		BillItem[] list = new BillItem[1];
		list[0] = item;
		assertEquals(5.0, BillCalculations.billCalculations(list));
	}
}
