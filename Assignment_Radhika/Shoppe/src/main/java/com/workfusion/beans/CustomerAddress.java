package com.workfusion.beans;

import com.workfusion.exception.InvalidAddressException;

public class CustomerAddress {
	private String street;
	private String city;
	private Long pincode;
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
	public Long getPincode() {
		return pincode;
	}
	public void setPincode(Long pincode) throws InvalidAddressException {
		String pin=Long.toString((Long) pincode);
	if(pin.length()==6)
		this.pincode = pincode;
	else
		throw new InvalidAddressException("Invalid Address");
	}
	

}
