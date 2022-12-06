package com.workfusion.ecommerce;

public class PurchaseDetails implements Tax{
	private String purchaseId;
	private String paymentType;
	private double taxPercentage;
	
	public PurchaseDetails() {
		super();
	}
	public PurchaseDetails(String purchaseId, String paymentType) {
		super();
		this.purchaseId = purchaseId;
		this.paymentType = paymentType;
	}
	public String getPurchaseId() {
		return purchaseId;
	}
	public void setPurchaseId(String purchaseId) {
		this.purchaseId = purchaseId;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public double getTaxPercentage() {
		return taxPercentage;
	}
	public void setTaxPercentage(double taxPercentage) {
		this.taxPercentage = taxPercentage;
	}
	public double calculateTax(double price) {
			
		if(getPaymentType().equals("Debit Card")) {
			return (2*price)/100;
		}
		else if(getPaymentType().equals("Credit Card")) {
			return (3*price)/100;
		}
		else
			return (4*price)/100;
		
		
	}

}
