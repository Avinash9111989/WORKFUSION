package com.shoppe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductService {
	
	String url = "jdbc:mysql://localhost:3306/shoppe";
	String uname = "root";
	String pass = "Lofsof68$";
	
	Customer customer = new Customer();
	
    
	
	public void displayProduct() throws Exception{
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager
					.getConnection(url, uname, pass);

			PreparedStatement stmt = con.prepareStatement("select * from product order by productPrice;");
			//stmt.setString(1, customer.getCustomerName());
			
			//stmt.setLong(2, customer.getPhoneNumber());
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				System.out.println(rs.getInt("productId") +"  "+ rs.getString("productName") +"  "+ rs.getLong("productPrice") +"  " + rs.getString("productType"));
			}
		}
		catch (SQLException e) {
			System.out.println(" i am in ae xception");

		}
	}
	
	public boolean checkProductExistence(int productId) {
        boolean flag=false;
		try {
        
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager
					.getConnection(url, uname, pass);
			PreparedStatement stmt = con.prepareStatement("SELECT EXISTS(SELECT * FROM product WHERE productId= ?) ");
         stmt.setInt(1, productId);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
			flag =	rs.getInt(1)==1?true:false;
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return flag;

	}
	
	public double checkProductAmount(int productId) {
		float productPrice=0;
		try {
			  
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager
					.getConnection(url, uname, pass);
			PreparedStatement stmt = con.prepareStatement("SELECT productPrice FROM product WHERE productId= ? ");
            stmt.setInt(1, productId);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
			productPrice=rs.getFloat(1);
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return productPrice;
	}
}
				
			
			
		
	


