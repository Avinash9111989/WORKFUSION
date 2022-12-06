package com.workfusion.swiftfood;
public class Order {
	public int orderId;
	public String orderedFoods;
	public double totalPrice;
	public String status;
	public int unitPrice;
	public double calculateTotalPrice(int unitPrice) {
		totalPrice=(unitPrice)+((5*unitPrice)/100);
		return totalPrice;
	}

}
