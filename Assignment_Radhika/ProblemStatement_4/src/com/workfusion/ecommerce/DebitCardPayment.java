package com.workfusion.ecommerce;

public class DebitCardPayment extends Payment{
	private static int counter;
	private double discountPercentage;
	static {
		counter=0;
	}
	public DebitCardPayment(int customerId) {
		super(customerId);
		counter++;
		setPaymentId("D1000"+counter);
	}
	public int getCounter() {
		return counter;
	}
	public void setCounter(int counter) {
		this.counter = counter;
	}
	public double getDiscountPercentage() {
		return discountPercentage;
	}
	public void setDiscountPercentage(double discountPercentage) {
		this.discountPercentage = discountPercentage;
	}
	public double payBill(double amount) {
		if(amount<=500) {
			super.setServiceTaxPercentage(2.5);
			this.setDiscountPercentage(1);
		}
		else if(amount>500 && amount<=1000) {
				super.setServiceTaxPercentage(4);
				this.setDiscountPercentage(2);
		}
		
		else {
			super.setServiceTaxPercentage(5);
			this.setDiscountPercentage(3);
		}
		
				
		return amount+amount*(getServiceTaxPercentage())/100-(discountPercentage*amount)/100;
		
	}
	

}
