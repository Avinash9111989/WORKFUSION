package com.workfusion.swiftfood;
public class Tester_Order {

	public static void main(String[] args) {
		
		Order o=new Order();
		o.orderId=101;
		o.orderedFoods="Spinach Alfredo Pasta";
		o.status="Ordered";
		
		System.out.println("Order Details");
		System.out.println("Order Id: "+o.orderId);
		System.out.println("Order Id: "+o.orderedFoods);
		System.out.println("Order Id: "+o.status);
		System.out.println("Total Price: "+o.calculateTotalPrice(20));
	}

}
