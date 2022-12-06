package com.workfusion.serviceImpl;

import java.sql.SQLException;

import java.time.LocalDateTime;
import java.util.Scanner;

import com.workfusion.beans.Customer;
import com.workfusion.beans.CustomerAddress;
import com.workfusion.beans.OrderDetails;
import com.workfusion.beans.ProductDetails;
import com.workfusion.exception.InvalidAddressException;
import com.workfusion.exception.InvalidNameException;
import com.workfusion.exception.InvalidPhoneNumberException;
import com.workfusion.exception.InvalidProductIdException;
import com.workfusion.repository.CustomerRepository;
import com.workfusion.services.CustomerService;
import com.workfusion.validation.ProductValidation;

public class CustomerServiceImpl implements CustomerService {

	Scanner scanner = new Scanner(System.in);
	Customer c = new Customer();
	CustomerAddress a=new CustomerAddress(); 
	CustomerRepository cr = new CustomerRepository();
	ProductDetails p=new ProductDetails();
	OrderDetails o=new OrderDetails();
	ProductValidation ordervalidation=new ProductValidation();

	public void addNewCustomer() {
		// TODO Auto-generated method stub
		System.out.println("Enter your Name");
		try {
			c.setCustomerName(scanner.next());
		} catch (InvalidNameException e1) {
			// TODO Auto-generated catch block
			System.out.println(e1.getMessage());
			addNewCustomer();
		}
		System.out.println("Enter your Mobile Number");
		try {
			c.setCustomerPhone(scanner.nextLong());
		} catch (InvalidPhoneNumberException e1) {
			// TODO Auto-generated catch block
			System.out.println(e1.getMessage());
			addNewCustomer();

		}
		System.out.println("Enter your username");
		c.setCustomerUsername(scanner.next());
		System.out.println("Enter your password");
		c.setCustomerPassword(scanner.next());
		System.out.println("Enter your address- street");
		a.setStreet(scanner.next());
		System.out.println("Enter your city");
		a.setCity(scanner.next());
		System.out.println("Enter your pincode");
		try {
			a.setPincode(scanner.nextLong());
		} catch (InvalidAddressException e1) {
			// TODO Auto-generated catch block
			e1.getMessage();
			addNewCustomer();
		}
		try {
			cr.addNewCustomer(c,a);
			
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void updateCustomerDetails(int option) {
		// TODO Auto-generated method stub
		
		if(option==1) {
		System.out.println("Enter your name");
		try {
			c.setCustomerName(scanner.next());
		} catch (InvalidNameException e1) {
			// TODO Auto-generated catch block
			System.out.println(e1.getMessage());
			updateCustomerDetails(option);
		}
		try {
			cr.updateCustomerDetails(c, a, option);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		if(option==2) {
			System.out.println("Enter your Mobile Number");
			try {
				c.setCustomerPhone(scanner.nextLong());
			} catch (InvalidPhoneNumberException e1) {
				// TODO Auto-generated catch block
				System.out.println(e1.getMessage());
				updateCustomerDetails(option);
			}
			try {
				cr.updateCustomerDetails(c, a, option);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		if(option==3) {
			System.out.println("Enter your password");
			c.setCustomerPassword(scanner.next());
			try {
				cr.updateCustomerDetails(c, a, option);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(option==4) {
			System.out.println("Enter your address- street");
			a.setStreet(scanner.next());
			System.out.println("Enter your city");
			a.setCity(scanner.next());
			System.out.println("Enter your pincode");
			try {
				a.setPincode(scanner.nextLong());
			} catch (InvalidAddressException e1) {
				// TODO Auto-generated catch block
				e1.getMessage();
				updateCustomerDetails(option);
			}
			try {
				cr.updateCustomerDetails(c, a, option);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		

	}
	
	public void customerLogin() {
		// TODO Auto-generated method stub
		try {
			System.out.println("Enter your username");
			c.setCustomerUsername(scanner.next());
			System.out.println("Enter your password");
			c.setCustomerPassword(scanner.next());
			cr.customerLogin(c);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void createOrder() {
		
		System.out.println("Enter product id to order");
		int productId=scanner.nextInt();
		p.setProductId(productId);
		try {
			cr.displayProductDetails();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (!ordervalidation.isValidProductId(productId)) {
			try {
			throw new InvalidProductIdException("Please enter valid productId");
			}catch (InvalidProductIdException e) {
				System.out.println(e.getMessage());
				createOrder();
			}

			}
		else {
	
		//o.setOrderDate(LocalDateTime.now());
		try {
			cr.createOrder(c,p,o);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
		
		

}
	public void previousOrderDetails() {
		System.out.println("Your previous Details:");
		try {
			cr.previousOrderDetails(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void deleteOrders() {
		System.out.println("Enter order id to cancel order");
		o.setOrderId(scanner.nextInt());
		try {
			cr.deleteOrders(o);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
