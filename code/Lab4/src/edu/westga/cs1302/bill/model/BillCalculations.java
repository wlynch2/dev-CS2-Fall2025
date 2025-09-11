package edu.westga.cs1302.bill.model;


/*
 * 
 */
public class BillCalculations {
	
	
	public static double getTax(double subtotal) {
		
		BillItem item = new BillItem("hello", subtotal);
		
		double tax = Bill.TAX_RATE;
		
		double finalAfterTax = item.getAmount() * tax;
		
		return finalAfterTax;
		
	}
	
//	public static double getTip(double subtotal) {
//		BillItem item = new BillItem("hello", subtotal);
//		Double tip = Bill.TIP_RATE;
//		double finalAfterTip = item.getAmount() * tip;
//		return finalAfterTip;
//	}
//	
//	public static double getTotal(double subtotal) {
//		BillItem item = new BillItem("hello", subtotal);
//		double tax = BillCalculations.getTax(subtotal);
//		double tip = BillCalculations.getTip(subtotal);
//		double total = item.getAmount() + tax + tip;
//		return total;
//	}

}
