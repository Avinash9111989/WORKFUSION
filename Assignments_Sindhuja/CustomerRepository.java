package com.shoppe;
import java.sql.*;
import java.util.Scanner;

public class CustomerRepository {
	Scanner sc = new Scanner(System.in);
	boolean flag;

	
	
	String url = "jdbc:mysql://localhost:3306/shoppe";
	String uname = "root";
	String pass = "Lofsof68$";
	
	public void addCustomer(Customer customer) throws Exception{
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager
					.getConnection(url, uname, pass);

			PreparedStatement stmt = con.prepareStatement("insert into customer(customerName,phonenumber) values(?,?);");
			stmt.setString(1, customer.getCustomerName());
			
			stmt.setLong(2, customer.getPhoneNumber());
			
			int i = stmt.executeUpdate();
			
			PreparedStatement s = con.prepareStatement("insert into customerLogin values(?,?,?);");
			s.setInt(1, customer.getCustomerId());
			s.setString(2, customer.getCustomerName());
			s.setString(3, customer.getCustomerPassword());
			
			int j = s.executeUpdate();
			
			System.out.println(" Registration Successfull!! please Login");
            
			con.close();

		}

		catch (SQLException e) {
			System.out.println(" i am in ae xception");

		}
		
	}
	
	public void customerLogin(Customer customer) {
		
		try {
			  Class.forName("com.mysql.cj.jdbc.Driver");  
			    Connection conn=DriverManager.getConnection(url, uname, pass);  
			         Statement stmt = conn.createStatement();
			         ResultSet rs = stmt.executeQuery("select customeruserName,customerPassword from customerLogin");		      
			         while(rs.next()){
			        	 //String username=rs.getString(1);
			        	 //String password=rs.getString(2);
			        	 //System.out.println("username is :"+ username +", password"+ password);
			        			 if(rs.getString(1).equals(customer.getCustomerUserName()) && rs.getString(2).equals(customer.getCustomerPassword())){
			        				 flag = true;
			        				 break;
			        				 
			                        }
			        			 else {
			        				 flag = false;
			        				 
			        			 }
			        			 
			        
			        			 
		 
			          
			         }
			         
			         if(flag == true)
			        	 System.out.println("LOGIN SUCCESSFULLL !!!!");
			             
			         else
			        	 System.out.println("LOGIN IS UNSUCCESSFUL...PLEASE TRY AGAIN...");
			         
			}catch(Exception e) {
				e.getMessage();
				
			}
	}
	
	
	public void updatecustomerDetails(int customerId) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager
					.getConnection(url, uname, pass);
			
			System.out.println("Select the field which you want to update:");
			System.out.println("1. Name");
			System.out.println("2. Phone Number");
			int option = sc.nextInt();
			
			if(option == 1)
			{
			PreparedStatement stmt = con.prepareStatement("update customer set customerName = ? where customerid = ?");
			System.out.println("Enter the new name");
			stmt.setString(1, sc.next());
			stmt.setInt(2, customerId);

			
			int i = stmt.executeUpdate();
			}
			
			if(option == 2)
			{ 
				PreparedStatement stmt = con.prepareStatement("update customer set phoneNumber = ? where customerid = ?");
				System.out.println("Enter the new phone number");
				stmt.setLong(1, sc.nextLong());
				stmt.setLong(2, customerId);

				
				int i = stmt.executeUpdate();
			}
			
			System.out.println("UPDATED SUCCESSFULLY !!!!!");
			System.out.println("");
            
			con.close();

		}

		catch (SQLException e) {
			System.out.println(" I am in exception");

		}
		
	}
	
	
	public void createOrderrr(int productId) throws ClassNotFoundException {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager
					.getConnection(url, uname, pass);

			PreparedStatement stmt = con.prepareStatement("select productName,productPrice from product where productId = ?");
			
			stmt.setLong(1, productId);

			
			ResultSet rs = stmt.executeQuery();
			rs.next();
			System.out.println("");
			System.out.println("The selected product is  " + rs.getString(1));
			System.out.println("The price of selected product is: " + rs.getFloat(2));
			System.out.println("");
			
			System.out.println("Oredr created successfully!!!! ");
            
			con.close();

		}

		catch (SQLException e) {
			System.out.println(e.getMessage());

		}
		
		
	}
	

	}

	
	


	
	


