package com.workfusion.UI;

import java.util.Scanner;


import com.workfusion.serviceImpl.CustomerServiceImpl;
import com.workfusion.services.CustomerService;


public class EcomUI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ch = 0, ch1 = 0;
		CustomerService cs = (CustomerService) new CustomerServiceImpl();
		//OrderService os = new OrderService();
		Scanner scanner = new Scanner(System.in);
		while (true) {
			ch1 = 0;
			System.out.println("1. Register New Customer");
			System.out.println("2. Login Existing Customer");
			System.out.println("3. Exit ");
			int option = scanner.nextInt();

			switch (option) { 
			case 1:
				cs.addNewCustomer();
				break;
			case 2:
				cs.customerLogin();
				while (true) {
					 ch= 0;
					System.out.println("1. Update Existing Customer");
					System.out.println("2. Order products");
					System.out.println("3. Previous Orders");
					System.out.println("4. Delete Orders");
					System.out.println("5. logout ");
					int opt = scanner.nextInt();
					switch (opt) {
					case 1:

						System.out.println("1. Update Name");
						System.out.println("2. Update Mobile Number");
						System.out.println("3. Update Password");
						System.out.println("4. Update Address");
						int option2 = scanner.nextInt();

						cs.updateCustomerDetails(option2);
						break;
					case 2:
						cs.createOrder();
						break;
					case 3:
						cs.previousOrderDetails();
						break;
					case 4:
						cs.deleteOrders();
						break;
					case 5:
						ch = 1;
						break;

					}
					if (ch == 1)
						break;
				}

				break;
			case 3:
				ch1 = 1;
				break;

			default:
				System.out.println("Please provide correct option");
				break;

			}
			if (ch1 == 1)
				break;
		}
		System.out.println("Thank you");

	}

}
