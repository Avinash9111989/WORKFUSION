package com.workfusion.serviceImpl;

import java.util.Scanner;

import com.workfusion.beans.Adress;
import com.workfusion.beans.Customer;
import com.workfusion.repository.CustomerRepository;
import com.workfusion.services.CustomerService;

public class CustomerServiceImpl implements CustomerService {

	Scanner scanner = new Scanner(System.in);
	public Customer c = new Customer();
	Adress a=new Adress();
	CustomerRepository cr = new CustomerRepository();
	ProductServicesImp psi=new ProductServicesImp();
	public void addNewCustomer() {
		// TODO Auto-generated method stub
		System.out.println("Enter your Name");
		c.setCustomerName(scanner.next());
		System.out.println("Enter your Mobile Number");
		c.setCustomerPhone(scanner.nextLong());
		System.out.println("Enter your username");
		c.setCustomerUsername(scanner.next());
		System.out.println("Enter your password");
		c.setCustomerPassword(scanner.next());
		System.out.println("Enter Street");
		a.setStreet(scanner.next());
		System.out.println("Enter city");
		a.setCity(scanner.next());
		System.out.println("Enter pincode");
		a.setPincode(scanner.nextLong());
		try {
			cr.addNewCustomer(c,a);
			customerLogin();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void updateCustomerDetails() {
		// TODO Auto-generated method stub
		try {
		customerLogin();
		System.out.println("1. Modify name \n 2.Modify mobile number \n 3. Street \n 4. city \n 5. pincode ");
		int n=scanner.nextInt();
		switch(n)
		{
		case 1:
		{
			System.out.println("enter modified name");
			c.setCustomerName(scanner.next());
			System.out.println("Successfully modified Name");
			break;
		}
		case 2:
		{
			System.out.println("enter phone number");
			c.setCustomerPhone(scanner.nextLong());
			System.out.println("phone number modified successfully");
			break;
		}
		case 3:
		{
			System.out.println("Street");
			a.setStreet(scanner.next());
			System.out.println("Street modified successfully");
			break;
		}
		case 4:
		{
			System.out.println("City");
			a.setCity(scanner.next());
			System.out.println("city modified successfully");
			break;
		}
		case 5:
		{
			System.out.println("pincode");
			a.setPincode(scanner.nextLong());
			System.out.println("pincode modified successfully");
			break;
		}
		default:
			System.out.println("enter correct option");
		}
		cr.updateCustomerDetails(c,n,a);
	}catch (Exception e)
		{
		e.getMessage();
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
			System.out.println("Do you want shop \n Press 1 :\t to continue\n Press 2 : \t  exit  ");
			int option=scanner.nextInt();
			if(option==1)
			psi.categories(c);

			else
				System.out.println("Thank You Visit Again");
		} catch (Exception e) {
			e.getMessage();
		}
	}

}
