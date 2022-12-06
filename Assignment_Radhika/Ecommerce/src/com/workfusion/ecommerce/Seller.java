package com.workfusion.ecommerce;

public class Seller implements Tax{
	private String location;
	private double taxPercentage;
	
	public Seller(String location) {
		super();
		this.location = location;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public double getTaxPercentage() {
		return taxPercentage;
	}
	public void setTaxPercentage(double taxPercentage) {
		this.taxPercentage = taxPercentage;
	}
	public double calculateTax(double price) {
		
		if(location=="Middle east") {
			return (15*price)/100;
		}
		else if(location=="Europe") {
			return (25*price)/100;
		}
		else if(location=="Canada")
			return (22*price)/100;
		else if(location=="Japan")
			return (12*price)/100;
		else
		return 0;
		
	}
	
}
