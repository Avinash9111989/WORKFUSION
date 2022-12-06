package com.workfusion.order;

public class Order {
	private int orderId;
	private String orderedFoods;
	private double totalPrice;
	private String status;
	public Order(int orderId, String orderedFoods,String status) {
		super();
		this.orderId = orderId;
		this.orderedFoods = orderedFoods;
	
		this.status = status;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getOrderedFoods() {
		return orderedFoods;
	}
	public void setOrderedFoods(String orderedFoods) {
		this.orderedFoods = orderedFoods;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totapPrice) {
		this.totalPrice = totapPrice;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void calculateTotalPrice(int unitPrice) {
		totalPrice=unitPrice+(unitPrice*5)/100;
		
	}
	

}
