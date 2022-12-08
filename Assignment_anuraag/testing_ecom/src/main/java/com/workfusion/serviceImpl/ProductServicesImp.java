package com.workfusion.serviceImpl;
import java.util.*;

import com.workfusion.beans.Customer;
import com.workfusion.beans.Products;
import com.workfusion.repository.ProductRepository;
import com.workfusion.services.ProductServices;

public  class ProductServicesImp implements ProductServices{
	ProductRepository pror=new ProductRepository();
	Scanner sc=new Scanner(System.in);
	Products pro=new Products();	
	public void categories(Customer c) 
	{
		ProductServicesImp psi=new  ProductServicesImp();
		boolean option1=true;
		while(option1)
		{
		System.out.println("1.mobile \n2.Laptop \n3.Snacks");
		System.out.println("Enter the Type" + c.getCustomerId());
		int option=sc.nextInt();
		switch(option)
		{
		case 1:
			psi.displayProducts("mobile",c);
			option1=false;
			break;
		case 2:
			psi.displayProducts("Laptop",c);
			option1=false;
			break;
		case 3:
			psi.displayProducts("Snacks",c);
			option1=false;
			break;
		default:
				System.out.println(" Please enter valid option!!!");
		}
		}
		}
		public void displayProducts(String item,Customer c)
		{
		
			pror.displayProduct(item,c);
		
}
	
}
