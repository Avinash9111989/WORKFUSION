package com.workfusion.UI;
import com.workfusion.serviceImpl.CustomerServiceImpl;
//import com.workfusion.serviceImpl.ProductServicesImp;
import com.workfusion.services.CustomerService;
//import com.workfusion.services.ProductServices;
import java.util.*;
public class EcomUI {

	public static void main(String[] args) {
		CustomerService cs =  new CustomerServiceImpl();
		Scanner scanner = new Scanner(System.in);
		//boolean option1 = true;
		//while (option1) {
			System.out.println("1. Register New Customer");
			System.out.println("2. Login Existing Customer");
			System.out.println("3. Update Existing Customer");
			int option = scanner.nextInt();
			switch (option) {
			case 1:
				cs.addNewCustomer();//option1 = false;
				break;
			case 2:
				cs.customerLogin();//option1 = false;
				break;
			case 3:
				cs.updateCustomerDetails();//option1 = false;
				break;
			default:
				System.out.println("Please provide correct option");
			}
			scanner.close();
		//}

	}

}
