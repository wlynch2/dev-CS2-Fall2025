package edu.westga.cs1302.lab2.model.test.view.view_bill;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.lab2.view.*;
import edu.westga.cs1302.lab2.model.*;

class TestGetText {

	@Test
	void testWhenGetTextHasOneItem() {
		Bill bill = new Bill();
		BillView view = new BillView();
		BillItem item = new BillItem("fries", 10.0);
		
		bill.addItem(item);
		
		double tax = item.getAmount() * Bill.TAX_RATE;
		double tip = item.getAmount() * Bill.TIP_RATE;
		String viewWord = view.getText(bill);
		String expected = "ITEMS" + System.lineSeparator()
			+ item.getName() + " - " + item.getAmount()+ System.lineSeparator()
			+ System.lineSeparator()
			+"SUBTOTAL - $" + item.getAmount()  + System.lineSeparator()
			+"TAX - $" + tax + System.lineSeparator()
			+"TIP - $" + tip + System.lineSeparator()
			+"TOTAL - $" + (item.getAmount() + (item.getAmount() * Bill.TAX_RATE) + (item.getAmount() * Bill.TIP_RATE));
		
		assertEquals(expected, viewWord);
		
			
		
	}
	
	@Test
	void testWhenGetTextHasManyItems() {
		Bill bill = new Bill();
		
		BillItem item = new BillItem("fries", 10.0);
		BillItem item2 = new BillItem("Chocolate", 5.0);
		
		bill.addItem(item);
		bill.addItem(item2);
		
	
		BillView view = new BillView();
		String viewWord = view.getText(bill);
		
		double itemTotal = (item.getAmount() + item2.getAmount());
		
		double tax = itemTotal * Bill.TAX_RATE;
		double tip = itemTotal * Bill.TIP_RATE;
		
		String expected = "ITEMS" + System.lineSeparator()
			+ item.getName() + " - " + item.getAmount()+ System.lineSeparator()
			+ item2.getName() + " - " + item2.getAmount()+ System.lineSeparator()
			+ System.lineSeparator()
			+"SUBTOTAL - $" + itemTotal + System.lineSeparator()
			+"TAX - $" + tax + System.lineSeparator()
			+"TIP - $" + tip + System.lineSeparator()
			+"TOTAL - $" + (itemTotal + (itemTotal * Bill.TAX_RATE) + (itemTotal * Bill.TIP_RATE));
		
		assertEquals(expected, viewWord);
	}
	



}
