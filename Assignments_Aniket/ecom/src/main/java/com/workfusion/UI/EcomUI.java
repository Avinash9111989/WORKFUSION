package com.workfusion.UI;

import java.sql.SQLException;
import java.util.Scanner;

import com.workfusion.Exception.*;
import com.workfusion.serviceImpl.CustomerServiceImpl;
import com.workfusion.serviceImpl.OrderServiceImpl;
import com.workfusion.services.CustomerService;
import com.workfusion.services.OrderService;

public class EcomUI 
{

	public static void main(String[] args) throws InvalidPhoneNumberException,InvalidNameException,InvalidPasswordException,InvalidAddressException,ClassNotFoundException, SQLException 
	{
		// TODO Auto-generated method stub

		CustomerService cs = (CustomerService) new CustomerServiceImpl();
		OrderService os = (OrderService) new OrderServiceImpl();
		
		Scanner scanner = new Scanner(System.in);
		boolean flag=true;
		while (flag) 
		{
			System.out.println("1. Register New Customer");
			System.out.println("2. Login Existing Customer");
			System.out.println("3. Update Existing Customer.");
			System.out.println("4. Display Products.");
			System.out.println("5. Order Products.");
			System.out.println("6. Exit");
			System.out.println("Enter your Choice:");
			int option = scanner.nextInt();
			switch (option) {
			case 1:
				cs.addNewCustomer();
				break;
			case 2:
				cs.customerLogin();
				break;
			case 3:
				if(cs.customerLogin())
				{
					cs.updateCustomerDetails(); //Login is required to update or edit customer details.
				}
				break;
			case 4:
				if(cs.customerLogin())
					os.displayProducts(); // Login is required to display the products from database.
				break;
			case 5:
				if(cs.customerLogin())
				{
					os.orderProducts();
				}
			case 6:
				System.out.println("Logged-out!!!!");
				flag = false;
				break;
			default:
				System.out.println("Please provide correct option");
			}
		}

	}

}
