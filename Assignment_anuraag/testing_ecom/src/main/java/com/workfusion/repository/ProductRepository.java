package com.workfusion.repository;
import java.sql.*;
import java.time.LocalDate;
import java.util.Scanner;

import com.workfusion.beans.Customer;
import com.workfusion.serviceImpl.OrderServicesImp;
public class ProductRepository {
		static final String DB_URL = "jdbc:mysql://localhost:3306/ecom?characterEncoding=utf8";
	    static final String USER = "root";
	    static final String PASS = "Anuraag@6600";
	    Scanner sc=new Scanner(System.in);
	    LocalDate ld=LocalDate.now();

	public void displayProduct(String item,Customer c)
	{

		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager
					.getConnection(DB_URL,USER, PASS);
			PreparedStatement stmt = con.prepareStatement("select product_id,product_name,product_price from product where product_type=?");
			stmt.setString(1, item);
			ResultSet rs = stmt.executeQuery();
			 while(rs.next())
			 {
				 int id=rs.getInt("product_id");
				 String name=rs.getString("product_name");
				 float  price=rs.getFloat("product_price");
				 System.out.println(id + "\t"+ name + "\t" + price );
			 }
				OrderServicesImp Osi=new OrderServicesImp();
				 System.out.println("==========================");
				System.out.println("select option");
				int option=sc.nextInt();
					  Osi.add_cart(option,c);
			 con.close();
			 
		 }
		catch( Exception e)
		{
			System.out.println(e.getMessage());
		} 


		
}
}
