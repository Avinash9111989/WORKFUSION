package com.workfusion.ecommerce;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DebitCardPayment d=new DebitCardPayment(101);
		double totalAmount=d.payBill(500);
		System.out.println("Customer Id: "+d.getCustomerId());
		System.out.println("Payment Id: "+d.getPaymentId());
		System.out.println("Service tax percentage: "+d.getServiceTaxPercentage());
		System.out.println("Discount percentage: "+d.getDiscountPercentage());
		System.out.println("Total bill amount: "+totalAmount);

	}

}
