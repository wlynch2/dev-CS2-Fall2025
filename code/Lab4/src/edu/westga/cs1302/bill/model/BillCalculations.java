package edu.westga.cs1302.bill.model;

/**
 * does the calculations for the billView class
 * @author wlynch2
 * @version Fall 2025
 */
public class BillCalculations {
	
	/**
	 * applies the tax and tip to the billItem returning the subtotal
	 * @param items the list in which your doing the calculations to
	 * @return double the subtotal of everything
	 */
	public static double billCalculations(BillItem[] items) {
		if (items == null) {
			throw new IllegalArgumentException("items cannot be null");
		}
		
		double subtotal = 0.0;
		double tax = Bill.TAX_RATE;
		double tip = Bill.TIP_RATE;
		double taxAmount;
		double tipAmount;
		for (BillItem currItem : items) {
			subtotal += currItem.getAmount();
			taxAmount = subtotal * tax;
			tipAmount = subtotal * tip;
			
			subtotal += taxAmount + tipAmount;
			
		}
		return subtotal;	
	}
	
}
