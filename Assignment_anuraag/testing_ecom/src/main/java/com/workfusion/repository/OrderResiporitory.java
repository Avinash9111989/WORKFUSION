package com.workfusion.repository;
import java.time.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import javax.print.attribute.standard.DateTimeAtCompleted;

import com.workfusion.beans.Customer;
import com.workfusion.beans.Products;
import com.workfusion.serviceImpl.CustomerServiceImpl;
//import com.workfusion.serviceImpl.OrderServicesImp;
import com.workfusion.serviceImpl.ProductServicesImp;
public class OrderResiporitory extends CustomerServiceImpl {
	
	static final String DB_URL = "jdbc:mysql://localhost:3306/ecom?characterEncoding=utf8";
    static final String USER = "root";
    static final String PASS = "Anuraag@6600";
    Products pro=new Products();	
    //Customer c=new Customer();
    Scanner sc=new Scanner(System.in);
    //CustomerServiceImpl csi = new CustomerServiceImpl();
	public void add_cart(int option,Customer c)
	{

		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager
					.getConnection(DB_URL,USER, PASS);
			PreparedStatement stmt = con.prepareStatement("insert into cart values (?,?,(select product_name from product where product_id=?),(select product_price from product where product_id=?))");
			stmt.setInt(1, c.getCustomerId());
			stmt.setInt(2, option);
			stmt.setInt(3, option);
			stmt.setInt(4, option);
			stmt.executeUpdate();
			 con.close();
			 System.out.println("Successfully product is added to cart "+ c.getCustomerId());
			 System.out.println("enter the option \n Press 1 : edit cart \n Press 2 :  to place the order");
				int option1=sc.nextInt();
				if(option1==1) {
				editcart(option1,c);
				}
				else
				{
					order(c);
				}
		 }
		catch( Exception e)
		{
			System.out.println(e.getMessage());
		}
	
	}
	public void editcart(int option1,Customer c)
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager
					.getConnection(DB_URL,USER, PASS);
			System.out.println("enter option 1 :  to enter the  new products to cart \n  option 2: to remove the products  " + c.getCustomerId());
			int option2=sc.nextInt();
			if(option2==1)
			{ 
				ProductServicesImp psii=new ProductServicesImp();
				psii.categories(c);
			}else
			{ 
				cartDisplay(c);
				System.out.println(" Enter the product which u want to remove");
				int choose=sc.nextInt();
			PreparedStatement stmt = con.prepareStatement("delete from cart where product_id=?");
			stmt.setInt(1, choose);
			stmt.executeUpdate();
			 con.close();
			 System.out.println("Successfully removed product from cart");
			 System.out.println("Press 1: for edit the cart \n Press 2: For Order");
			 int choice=sc.nextInt();
			 if(choice==1)
			 editcart(option1,c);
			 else
				 order(c);
			}
		 }
		
		catch( Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
		public void cartDisplay(Customer c)
		{
			try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager
						.getConnection(DB_URL,USER, PASS);
				PreparedStatement stmt = con.prepareStatement("select * from cart where customerId=?");
				stmt.setInt(1, c.getCustomerId());
				ResultSet rs= stmt.executeQuery();
				while(rs.next())
				{
					int id= rs.getInt("customerId");
					int id1=rs.getInt("product_id");
					String product_name=rs.getString("product_name");
					float product_price=rs.getFloat("product_price");
					System.out.println(id + "\t" + id1+ " \t " + product_name + " \t " +product_price);
				}
				 con.close();
			 }
			catch( Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
		public void order(Customer c) {
			try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager
						.getConnection(DB_URL,USER, PASS);
				PreparedStatement stmt = con.prepareStatement("insert into orders(customerId,amount,dateandtime) values (?,(select sum(product_price) from cart where customerId=?),current_timestamp())");
				stmt.setInt(1, c.getCustomerId());
				stmt.setInt(2, c.getCustomerId());
				stmt.executeUpdate();
				 con.close();
				 System.out.println("\n");
				 System.out.println("*****************************"+c.getCustomerId());
				 deleteCart();
				 displayOrder(c);
			 }
				
			catch( Exception e)
			{
				System.out.println(e.getMessage());
			}	
		}
	public void deleteCart()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager
					.getConnection(DB_URL,USER, PASS);
			PreparedStatement stmt = con.prepareStatement("truncate table cart ");
			stmt.executeUpdate();
			 con.close();
			 System.out.println("Successfully cleared cart");
		 }
		catch( Exception e)
		{
			System.out.println(e.getMessage());
		}
		//displayOrder(c);
	}
	public void displayOrder(Customer c)
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager
					.getConnection(DB_URL,USER, PASS);
			PreparedStatement stmt = con.prepareStatement("select orderId from orders where customerId = ? order by orderId desc limit 1");
			stmt.setInt(1, c.getCustomerId());
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				Statement stmt1 = con.createStatement();
				ResultSet rs1 = stmt1.executeQuery("select * from orders where orderId = '"+rs.getInt("orderId")+"'");
				while(rs1.next()) {
				int id1= rs1.getInt("orderId");
				int id2=rs1.getInt("customerId");
				float amount=rs1.getFloat("amount");
				
				System.out.println(id1 + " \t " + id2  + " \t " + amount + " \t "+ LocalDate.now() + " \t " + LocalTime.now() );
				}
			}
			 con.close();
		 }
		catch( Exception e)
		{
			System.out.println(e.getMessage());
		}
		System.out.println("Order has been SuccessFully Placed ");
		//deleteCart();
	}
	public void cancelOrder(int option) {
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager
					.getConnection(DB_URL,USER, PASS);
			PreparedStatement stmt = con.prepareStatement("delete from orders where orderId=? ");
			stmt.setInt(1, option);
			stmt.executeUpdate();
			 con.close();
			 System.out.println("Successfully Cancelled the order");
		 }
		catch( Exception e)
		{
			System.out.println(e.getMessage());
		}
		System.out.println("Cancelling Order");
	}
}
