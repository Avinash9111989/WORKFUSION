package com.workfusion.order;

public class OrderDetails {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Order order=new Order(101,"Spinach Alfredo Pasta","Ordered");
		order.calculateTotalPrice(30);
		System.out.println("Order Details:");
		System.out.println("Order Id:"+order.getOrderId());
		System.out.println("Ordered Food:"+order.getOrderedFoods());
		System.out.println("Order Status:"+order.getStatus());
		System.out.println("Total Price:"+order.getTotalPrice());
		

	}

}
