package com.shoppe;

public class Customer {
	
	private int customerId;
	private String customerName;
	private String address;
	private long phoneNumber;
	private String customerUserName;
	private String customerPassword;
	
	public String getCustomerUserName() {
		return customerUserName;
	}
	public void setCustomerUserName(String customerUserName) {
		this.customerUserName = customerUserName;
	}
	public String getCustomerPassword() {
		return customerPassword;
	}
	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long l) {
		this.phoneNumber = l;
	}
	public String getCustomerName() {
		// TODO Auto-generated method stub
		return customerName;
	}
	
	
	


}
