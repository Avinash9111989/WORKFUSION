package com.shoppe;

import java.sql.Date;

import javax.print.attribute.DateTimeSyntax;

public class Order {
	
	int orderId;
	int customerId;
	int productId;
	double amount;
	DateTimeSyntax dateTime;
	
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public DateTimeSyntax getDateTime() {
		return dateTime;
	}
	public void setDateTime(DateTimeSyntax dateTime) {
		this.dateTime = dateTime;
	}
	
	
	
	

}
