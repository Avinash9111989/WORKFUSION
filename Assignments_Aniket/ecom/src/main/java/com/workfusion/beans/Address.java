package com.workfusion.beans;

public class Address 
{

	private String street;
	private String city;
	private long pinCode;
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public long getPinCode() {
		return pinCode;
	}
	public void setPinCode(long pinCode) 
	{
		this.pinCode = pinCode;
	}
}
