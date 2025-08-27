package edu.westga.cs1302.lab1.view;
import edu.westga.cs1302.lab1.model.BillItem;

import java.util.ArrayList;

public class billView {
	
	private ArrayList<BillItem> items;
	public static final double TAX = 0.1;
	public static final double TIP = 0.2;
	
	
	
	public billView() {
		items = new ArrayList<>();
	}
	
	
	/** Return a String containing the list of bill items and total for the bill.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return a String containing the list of bill items and total for the bill
	 */
	public String getText() {
		String text = "ITEMS" + System.lineSeparator();
		double subTotal = 0.0;
		for (BillItem item : this.items) {
			text += item.getName() + " - " + item.getAmount() + System.lineSeparator();
			subTotal += item.getAmount();
		}
		
		text += System.lineSeparator();
		text += "SUBTOTAL - $" + subTotal + System.lineSeparator();
		double tax = subTotal * TAX;
		double tip = subTotal * TIP;
		text += "TAX - $" + tax + System.lineSeparator();
		text += "TIP - $" + tip + System.lineSeparator();
		text += "TOTAL - $" + (subTotal + tip + tax);
		
		return text;
	}
}
