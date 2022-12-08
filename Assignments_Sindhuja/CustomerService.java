package com.shoppe;
import java.util.Scanner;


public class CustomerService {
	
	CustomerRepository cr = new CustomerRepository();
	Scanner scanner = new Scanner(System.in);
	Customer customer = new Customer();
	ProductValidation ordervalidation = new ProductValidation();
	CustomerRepository orderrepo = new CustomerRepository();
	Order order = new Order();
    ProductService prodrepo = new ProductService();
    Product p = new Product();


	public void addNewCustomer() {
		// TODO Auto-generated method stub
		System.out.println("Enter your Name");
		customer.setCustomerName(scanner.next());
		System.out.println("Enter your Mobile Number");
		customer.setPhoneNumber(scanner.nextLong());
		//System.out.println("Enter your cust id");
		//customer.setCustomerId(scanner.nextInt());
		System.out.println("Enter your username");
		customer.setCustomerUserName(scanner.next());
		System.out.println("Enter your password");
		customer.setCustomerPassword(scanner.next());
		try {
			cr.addCustomer(customer);
			//cr.customerLogin(customer);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void updateCustomerDetails(int customerId) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("WE ARE IN UPDATE BLOCK...!!!!");
		cr.updatecustomerDetails(customerId);
		

	}

	public void customerLogin() {
		// TODO Auto-generated method stub
		try {
			System.out.println("Enter your username");
			customer.setCustomerUserName(scanner.next());
			System.out.println("Enter your password");
			customer.setCustomerPassword(scanner.next());
			cr.customerLogin(customer);
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
public void createOrder(int productId) throws ClassNotFoundException {
		
    	
		if (!ordervalidation.isValidProductId(productId)) {
			try {
			throw new InvalidProductIdException("Please enter valid productId");
			}catch (InvalidProductIdException e) {
				System.out.println(e.getMessage());
			}

			} else {
			
			double productPrice = prodrepo.checkProductAmount(productId);
			order.setProductId(productId);
			order.setCustomerId(customer.getCustomerId());
			order.setAmount(productPrice);
			//orderrepo.createorder(order);
			
			cr.createOrderrr(productId);
		}
	}






}
