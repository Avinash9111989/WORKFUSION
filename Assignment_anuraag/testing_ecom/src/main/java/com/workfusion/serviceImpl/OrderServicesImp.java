package com.workfusion.serviceImpl;
import java.util.Scanner;

import com.workfusion.beans.Customer;
import com.workfusion.repository.OrderResiporitory;
public class OrderServicesImp {
	OrderResiporitory Or=new OrderResiporitory();
	Scanner sc=new Scanner(System.in);
	public void add_cart(int option,Customer c)
	{
		Or.add_cart(option,c);
		//OrderServicesImp osi=new OrderServicesImp();
//		System.out.println("enter the option \n Press 1 : edit cart \n Press 2 :  to place the order");
//		int option1=sc.nextInt();
//		if(option1==1) {
//		editcart(option1);
//		}
//		else
//		{
//			order(c);
//		}
	}
	public void editcart(int option1,Customer c) {
		Or.editcart(option1,c);
	}
	public void cartDisplay(Customer c)
	{
		Or.cartDisplay(c);
	}
	public void order(Customer c)
	{
		Or.order(c);
	}
	public void cancelOrder()
	{
		System.out.println("Enter the order_Id for Cancelling");
		int option=sc.nextInt();
		Or.cancelOrder(option);
		
	}
	public void displayOrder(Customer c) {
		Or.displayOrder(c);
	}
}
