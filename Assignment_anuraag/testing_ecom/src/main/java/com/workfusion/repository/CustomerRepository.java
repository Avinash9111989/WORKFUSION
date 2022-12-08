package com.workfusion.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.workfusion.beans.Adress;
import com.workfusion.beans.Customer;
import com.workfusion.serviceImpl.CustomerServiceImpl;


public class CustomerRepository {
	   static final String DB_URL = "jdbc:mysql://localhost:3306/ecom?characterEncoding=utf8";
	   static final String USER = "root";
	   static final String PASS = "Anuraag@6600";

	public void addNewCustomer(Customer c,Adress a) throws ClassNotFoundException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager
					.getConnection(DB_URL,USER, PASS);

			PreparedStatement stmt = con.prepareStatement("insert into customers(customerName,customerPhno) values(?,?)");
			stmt.setString(1, c.getCustomerName());
			stmt.setLong(2, c.getCustomerPhone());
			stmt.executeUpdate();
			stmt = con.prepareStatement("insert into customerlogin(customerId,customerusername,pass) values((select customerId from customers where customerPhno=?),?,?)");
			stmt.setLong(1, c.getCustomerPhone());
			stmt.setString(2, c.getCustomerUsername());
			stmt.setString(3, c.getCustomerPassword());
			stmt.executeUpdate();
			stmt = con.prepareStatement("insert into address(customerId,Street,city,pincode) values((select customerId from customers where customerPhno=?),?,?,?)");
			stmt.setLong(1, c.getCustomerPhone());
			stmt.setString(2, a.getStreet());
			stmt.setString(3, a.getCity());
			stmt.setLong(4, a.getPincode());
			stmt.executeUpdate();
			System.out.println(" Registration Successfull!! please Login");
			customerLogin(c);
			con.close();

		}

		catch (SQLException e) {
			System.out.println(e.getMessage());

		}
	}

	public void customerLogin(Customer c) throws ClassNotFoundException {
		CustomerServiceImpl csi=new CustomerServiceImpl();
		// TODO Auto-generated method stub
		//boolean flag = false;
		try {
		  Class.forName("com.mysql.cj.jdbc.Driver");  
		    Connection conn=DriverManager.getConnection(DB_URL,USER,PASS);  
		         Statement stmt = conn.createStatement();
		         ResultSet rs = stmt.executeQuery("select customerId from customerlogin where customerusername='"+c.getCustomerUsername()+"' and pass='"+c.getCustomerPassword()+"'");		      
		         while(rs.next()){
		           if(rs.getInt(1)>0){
		        	   c.setCustomerId(rs.getInt(1));
		        	   System.out.println("login successful");    
		           }else {
			        	 System.out.println("Invalid");
			        	 csi.customerLogin();
		           
		         }
		         }
		      
		         conn.close();
		       
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public void updateCustomerDetails(Customer c,int n,Adress a) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		try {
		  Class.forName("com.mysql.cj.jdbc.Driver");  
		    Connection conn=DriverManager.getConnection(DB_URL,USER,PASS);  
		    
		     
		     switch(n)
		     {
		     case 1:
		     {
		     PreparedStatement stmt = conn.prepareStatement("update customers set customername=? where customerId=(select customerId from customerlogin where customerusername=?)");
		     stmt.setString(1, c.getCustomerName());  
		     stmt.setString(2, c.getCustomerUsername());
		      stmt.executeUpdate();
		      break;
		     }
		     case 2:
		     {
		    	 PreparedStatement stmt = conn.prepareStatement("update customers set customerPhno=? where customerId=(select customerId from customerlogin where customerusername=?)");
		    	 stmt.setLong(1, c.getCustomerPhone()); 
		    	 stmt.setString(2, c.getCustomerUsername());
		    stmt.executeUpdate();
		    break;
		     }
		     case 3:
		     {
		    	 PreparedStatement stmt = conn.prepareStatement("update address set Street=? where customerId=(select customerId from customerlogin where customerusername=?)");
		    	 stmt.setString(1,a.getStreet() ); 
		    	 stmt.setString(2, c.getCustomerUsername());
		    stmt.executeUpdate();
		    break;
		     }
		     case 4:
		     {
		    	 PreparedStatement stmt = conn.prepareStatement("update address set city=? where customerId=(select customerId from customerlogin where customerusername=?)");
		    	 stmt.setString(1,a.getCity() ); 
		    	 stmt.setString(2, c.getCustomerUsername());
		    stmt.executeUpdate();
		    break;
		     }
		     case 5:
		     {
		    	 PreparedStatement stmt = conn.prepareStatement("update address set pincode=? where customerId=(select customerId from customerlogin where customerusername=?)");
		    	 stmt.setLong(1,a.getPincode() ); 
		    	 stmt.setString(2, c.getCustomerUsername());
		    stmt.executeUpdate();
		    break;
		     }
		     }
		     System.out.println("Modified Successfully");
		     conn.close();
		}catch(Exception e) {
			e.getMessage();
		}
	}
	
}
