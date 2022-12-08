package com.shoppe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);

		// TODO Auto-generated method stub
		
		CustomerService cs = (CustomerService) new CustomerService();
		Scanner scanner = new Scanner(System.in);
		ProductService ps = new ProductService();
		
		while (true) {
			System.out.println("1. Register New Customer");
			System.out.println("2. Login Existing Customer");
			System.out.println("3. Update Existing Customer");
			System.out.println("4. view all the products");
			System.out.println("5. Create order");


			int option = scanner.nextInt();
			switch (option) {
			case 1:
				cs.addNewCustomer();
				break;
			case 2:
				//try {
				cs.customerLogin();
				/*System.out.println("Logged in successfully...!!!!");*/
				//}
				/*catch(InputMismatchException e) {*/
					/*System.out.println("Invalid credentials");*/
					
				break;
				//}
			case 3:
				System.out.println("Enter the customer id that you want to update...");
				cs.updateCustomerDetails(sc.nextInt());
				break;
				
			case 4:
				try {
					ps.displayProduct();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				
			case 5:
				System.out.println("Enter the product id that you want to purchase...");
				cs.createOrder(sc.nextInt());
				break;
				
			default:
			
				System.out.println("Please provide correct option");
			}
		}

		
		

	}

}
