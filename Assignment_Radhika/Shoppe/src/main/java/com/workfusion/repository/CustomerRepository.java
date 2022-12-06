package com.workfusion.repository;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.x.protobuf.MysqlxCrud.Order;
import com.workfusion.beans.Customer;
import com.workfusion.beans.CustomerAddress;
import com.workfusion.beans.OrderDetails;
import com.workfusion.beans.ProductDetails;

public class CustomerRepository {
	   static final String DB_URL = "jdbc:mysql://localhost:3306/shopping";
	   static final String USER = "root";
	   static final String PASS = "Radhi6302@";
	  // static float totalAmount;
	public void addNewCustomer(Customer c,CustomerAddress a) throws ClassNotFoundException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(DB_URL,USER,PASS);

			PreparedStatement stmt = con.prepareStatement("insert into customer(customerName,phoneNumber) values(?,?)");
			stmt.setString(1, c.getCustomerName());
			stmt.setLong(2, c.getCustomerPhone());

			int i = stmt.executeUpdate();
			
		//	System.out.println(c.getCustomerPhone());
			PreparedStatement stmt2 = con.prepareStatement("select customerId from customer where phoneNumber=?;");
				stmt2.setLong(1, c.getCustomerPhone());
	        ResultSet rs = stmt2.executeQuery();
	         rs.next();
	         c.setCustomerId(rs.getInt(1));
	       //  System.out.println(id);
			PreparedStatement stmt1 = con.prepareStatement("insert into customerLogin(customerId,customeruserName,customerPassword) values(?,?,?)");
			stmt1.setInt(1, c.getCustomerId());
			stmt1.setString(2, c.getCustomerUsername());
			stmt1.setString(3, c.getCustomerPassword());
			stmt1.executeUpdate();
			PreparedStatement stmt3 = con.prepareStatement("insert into address(customerId,street,city,pincode) values(?,?,?,?)");
			stmt3.setInt(1, c.getCustomerId());
			stmt3.setString(2, a.getStreet());
			stmt3.setString(3, a.getCity());
			stmt3.setLong(4, a.getPincode());
			 stmt3.executeUpdate();
			con.close();
			System.out.println(" Registration Successfull!! please Login");

		}

		catch (SQLException e) {
			System.out.println(e.getMessage());

		}
	}

	public void customerLogin(Customer c) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
		    Connection conn=DriverManager.getConnection(DB_URL,USER,PASS);  
		    int flag=0;
		         Statement stmt = conn.createStatement();
		         ResultSet rs = stmt.executeQuery("select customeruserName,customerPassword from customerLogin");		      
		         while(rs.next()){
		           if(rs.getString(1).equalsIgnoreCase(c.getCustomerUsername()) && rs.getString(2).equals(c.getCustomerPassword())){
		         flag=1;
		           
		           }
		         }
		         if(flag==1)
		        	  System.out.println("Login Successful!!");
		}catch(Exception e) {
			e.getMessage();
		}
	}
	public void updateCustomerDetails(Customer c,CustomerAddress a,int option) throws ClassNotFoundException {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver"); 
	    Connection con=DriverManager.getConnection(DB_URL,USER,PASS); 
	    if(option==1) {
	    
	         PreparedStatement stmt = con.prepareStatement("select customerId from customerLogin where customeruserName=?;");
				stmt.setString(1, c.getCustomerUsername());
	        ResultSet rs = stmt.executeQuery();
	         rs.next();
	         c.setCustomerId(rs.getInt(1));
	    
	    	  PreparedStatement stmt1 = con.prepareStatement("update customer set customerName=? where customerId=?");
	    	  
	    	  stmt1.setString(1, c.getCustomerName());
	    	 // System.out.println(c.getCustomerName());
	    	  stmt1.setInt(2, c.getCustomerId());
	    	 // System.out.println(id);
	    	  stmt1.executeUpdate();
				con.close();
				System.out.println("Sucessfully Name Updated!");

	    	  
	    }
	    if(option==2) {
	    	//System.out.println(c.getCustomerPhone());
			PreparedStatement stmt = con.prepareStatement("select customerId from customerLogin where customeruserName=?;");
				stmt.setString(1, c.getCustomerUsername());
	        ResultSet rs = stmt.executeQuery();
	         rs.next();
	      
	         c.setCustomerId(rs.getInt(1));
	        // System.out.println(id);
	    	  PreparedStatement stmt1 = con.prepareStatement("update customer set phoneNumber=? where customerId=?");
	    	  
	    	  stmt1.setLong(1, c.getCustomerPhone());
	    	 // System.out.println(c.getCustomerName());
	    	  stmt1.setInt(2, c.getCustomerId());
	    	 // System.out.println(id);
	    	  stmt1.executeUpdate();
				con.close();
				System.out.println("Sucessfully Mobile Number Updated!");

	    	  
	    }
	  
	    if(option==3) {
	    	PreparedStatement stmt = con.prepareStatement("select customerId from customerLogin where customeruserName=?;");
			stmt.setString(1, c.getCustomerUsername());
        ResultSet rs = stmt.executeQuery();
         rs.next();
      
         c.setCustomerId(rs.getInt(1));
        // System.out.println(id);
    	  PreparedStatement stmt1 = con.prepareStatement("update customerLogin set customerPassword=? where customerId=?");
    	  
    	  stmt1.setString(1, c.getCustomerPassword());
    	 // System.out.println(c.getCustomerName());
    	  stmt1.setInt(2, c.getCustomerId());
    	 // System.out.println(id);
    	  stmt1.executeUpdate();
			con.close();
			System.out.println("Sucessfully Password Updated!");

	    }
	    if(option==4) {
	    	PreparedStatement stmt = con.prepareStatement("select customerId from customerLogin where customeruserName=?;");
			stmt.setString(1, c.getCustomerUsername());
        ResultSet rs = stmt.executeQuery();
         rs.next();
      
         c.setCustomerId(rs.getInt(1));
       //  System.out.println(id);
    	  PreparedStatement stmt1 = con.prepareStatement("update address set street=?,city=?,pincode=? where customerId=?");
    	  
    	  stmt1.setString(1, a.getStreet());
    	  stmt1.setString(2, a.getCity());
    	  stmt1.setLong(3, a.getPincode());
    	 // System.out.println(c.getCustomerName());
    	  stmt1.setInt(4, c.getCustomerId());
    	 // System.out.println(id);
    	  stmt1.executeUpdate();
			con.close();
			System.out.println("Sucessfully Address Updated!");

	    }
	    
	    
	  
	    
		
	}
		catch (SQLException e) {
			System.out.println(e.getMessage());

		}
}
	public void displayProductDetails() throws ClassNotFoundException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
		    Connection con=DriverManager.getConnection(DB_URL,USER,PASS); 
		    Statement stmt = con.createStatement();
	         ResultSet rs = stmt.executeQuery("select * from product;");	
	         System.out.println("ProductId\t ProductName\t ProductPrice\t ProductType\t");
	         while(rs.next()){
	        	 System.out.println(rs.getInt(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getFloat(3)+"\t\t"+rs.getString(4)); 
	        	 
	         }
	         con.close();
			
		}
			catch (SQLException e) {
				System.out.println(e.getMessage());

			}
		    
		
	}
	public void createOrder(Customer c,ProductDetails p,OrderDetails o) throws ClassNotFoundException {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
		    Connection con=DriverManager.getConnection(DB_URL,USER,PASS); 
		    PreparedStatement stmt = con.prepareStatement("select customerId from customerLogin where customeruserName=?;");
		    stmt.setString(1, c.getCustomerUsername());
	        ResultSet rs = stmt.executeQuery();
	         rs.next();
	         c.setCustomerId(rs.getInt(1));
	         
	         PreparedStatement stmt1 = con.prepareStatement("select productPrice from product where productId=?;");
	         stmt1.setInt(1, p.getProductId());
	         ResultSet rs1 = stmt1.executeQuery();
	         rs1.next();
	         System.out.println(p.getProductId());
	         p.setProductPrice(rs1.getFloat(1));
	         System.out.println(p.getProductPrice());
	     //  totalAmount+=p.getProductPrice();
	       PreparedStatement stmt2 = con.prepareStatement("insert into orders(customerId,productId,amount,orderDate) values(?,?,?,CURRENT_TIMESTAMP);");
	       stmt2.setInt(1, c.getCustomerId());
	       stmt2.setInt(2,p.getProductId());
	       stmt2.setFloat(3, p.getProductPrice());
	       //stmt2.setLocalDateTime(4,)
	       stmt2.execute();
	       con.close();
	     
	       
		}
		
			catch (SQLException e) {
				System.out.println(e.getMessage());

			}
	}
	public void previousOrderDetails(Customer c) throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		
	    Connection con=DriverManager.getConnection(DB_URL,USER,PASS); 
	    PreparedStatement stmt = con.prepareStatement("select customerId from customerLogin where customeruserName=?;");
	    stmt.setString(1, c.getCustomerUsername());
        ResultSet rs = stmt.executeQuery();
         rs.next();
         c.setCustomerId(rs.getInt(1));
         PreparedStatement stmt1 = con.prepareStatement("select * from orders where customerId=?;");
         stmt1.setInt(1, c.getCustomerId());
         ResultSet rs1 = stmt1.executeQuery();
         System.out.println("Order id\t Product Id\t Amount\t Order Date");
         while(rs1.next()) {
        	System.out.println(rs1.getInt(1)+"\t\t"+rs1.getInt(3)+"\t\t"+rs1.getFloat(4)+"\t\t"+rs1.getDate(5));
        	
        	 
         }
         con.close();
		} catch (ClassNotFoundException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	public void deleteOrders(OrderDetails o) throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		
	    Connection con=DriverManager.getConnection(DB_URL,USER,PASS); 
	    PreparedStatement stmt = con.prepareStatement("delete from orders where orderId=?;");
        stmt.setInt(1, o.getOrderId());
        stmt.execute();
        System.out.println("Deleted Sucessfully");
        con.close();
	    
} catch (ClassNotFoundException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	public boolean checkProductExistence(int productId) {
        boolean flag=false;
        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		
	    Connection con=DriverManager.getConnection(DB_URL,USER,PASS); 
	    PreparedStatement stmt = con.prepareStatement("SELECT EXISTS(SELECT * FROM product WHERE productId= ?) ");
         stmt.setInt(1, productId);
         ResultSet resultset = stmt.executeQuery();
			if (resultset.next()) {
			flag=	resultset.getInt(1)==1?true:false;
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return flag;

	}

}

