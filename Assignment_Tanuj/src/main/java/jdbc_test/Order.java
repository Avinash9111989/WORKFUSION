package jdbc_test;

import java.util.Scanner;

public class Order {
	private int orderId;
	private int customerId;
	private float amount;
	private String dateTime;
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
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	int[] placeOrder(int e) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter product ID");
		int product_id = sc.nextInt();
		if((product_id>=e)&&(product_id<1)) {
			System.out.println("Not valid product ID");
			int[] res = {-1,-1};
			return res;
		}
		System.out.println("Enter quantity");
		int quantity = sc.nextInt();
		int[] res = {product_id, quantity};
		return res;
	}
	
	
}
