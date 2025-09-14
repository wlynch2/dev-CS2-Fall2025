package edu.westga.cs1302.bill.model;


/*
 * 
 */
public class BillCalculations {
	
	
	public static double billCalculations(BillItem[] items) {
		double subtotal = 0.0;
		double tax = Bill.TAX_RATE;
		double tip = Bill.TIP_RATE;
		double taxAmount;
		double tipAmount;
		
		for(BillItem currItem : items) {
			subtotal += currItem.getAmount();
			taxAmount = subtotal * tax;
			tipAmount = subtotal * tip;
			
			subtotal += taxAmount + tipAmount;
			
		}
		return subtotal  ;
		
	}
	
	
	
	

}
