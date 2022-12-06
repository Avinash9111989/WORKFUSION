package com.workfusion.beans;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.workfusion.exception.InvalidNameException;
import com.workfusion.exception.InvalidPhoneNumberException;

public class Customer {

	private int customerId;
	private String customerName;
	private long customerPhone;
	private String customerUsername;
	private String customerPassword;
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) throws InvalidNameException {
		if(!customerName.equals("") && (customerName != null) && (customerName.matches("^[a-zA-Z]*$")) )
		this.customerName = customerName;
		else
			throw new InvalidNameException("Invalid name");
	}
	public long getCustomerPhone() {
		
		return customerPhone;
	}
	public void setCustomerPhone(long customerPhone) throws InvalidPhoneNumberException {
		String pnum=Long.toString((Long) customerPhone);
		Long pnum1=customerPhone;
	//	Pattern ptrn = Pattern.compile("(0/91)?[7-9][0-9]{9}"); 
	//	Matcher match = ptrn.matcher(pnum); 
		//returns a boolean value 
	//	if (match.find() && match.group().equals(pnum))
		if(pnum.length()<10 || pnum.length()>10 || ((pnum1%1000000000)%10)<6){
			throw new InvalidPhoneNumberException("Invalid Phone Number");
		}
		else
		this.customerPhone = customerPhone;
	//	else {
		//	throw new InvalidPhoneNumberException("Invalid Phone Number");
		//}
	}
	public String getCustomerUsername() {
		return customerUsername;
	}
	public void setCustomerUsername(String customerUsername) {
		this.customerUsername = customerUsername;
	}
	public String getCustomerPassword() {
		return customerPassword;
	}
	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}
	
	
	
}
