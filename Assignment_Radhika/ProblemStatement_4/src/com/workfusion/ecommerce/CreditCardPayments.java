package com.workfusion.ecommerce;

public class CreditCardPayments extends Payment{
	private static int counter;
   static {
	   counter=0;
   }
	public CreditCardPayments(int customerId) {
		super(customerId);
		counter++;
		setPaymentId("C1000"+counter);
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}
	public double payBill(double amount) {
		if(amount<=500) {
			setServiceTaxPercentage(3);
			
		}
		else if(amount>500 && amount<=1000) {
				setServiceTaxPercentage(5);
				
		}
		
		else {
			setServiceTaxPercentage(6);
			
		}
		
				
		return amount+amount*(getServiceTaxPercentage())/100;
		
	}

}
