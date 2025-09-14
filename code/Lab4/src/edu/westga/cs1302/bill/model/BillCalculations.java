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
	
		for (BillItem currItem : items) {
			subtotal += currItem.getAmount();
		}
		return subtotal;	
	}
	
	/**
	 * multiplies the items amount by the tax rate to get the tax value
	 * @param items the list in which your doing the calculations to
	 * @return taxed amount of the item in the array
	 */
	public static double taxAmount(BillItem[] items) {
		if (items == null) {
			throw new IllegalArgumentException("items cannot be null");
		}
		double tax = billCalculations(items) * Bill.TAX_RATE;
		return tax;
	}
	
	/**
	 * multiplies the items amount by the tip rate to get the tip value
	 * @param items the list in which your doing the calculations to
	 * @return tipped amount of the item in the array
	 */
	public static double tipAmount(BillItem[] items) {
		if (items == null) {
			throw new IllegalArgumentException("items cannot be null");
		}
		double tip = billCalculations(items) * Bill.TIP_RATE;
		return tip;
	}
	
	/**
	 * adds the subtotal tip and tax ammount to get the total price
	 * @param items the list in which your doing the calculations to
	 * @return the total price of the item after tax and tip
	 */
	public static double total(BillItem[] items) {
		if (items == null) {
			throw new IllegalArgumentException("items cannot be null");
		}
		double total = billCalculations(items) + tipAmount(items) + taxAmount(items);
		return total;
	}
}
