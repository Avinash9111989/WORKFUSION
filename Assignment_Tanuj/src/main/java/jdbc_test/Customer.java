package jdbc_test;

import java.sql.Connection;
import java.util.Scanner;

public class Customer {
	private int custID;
	private String name;
	private String number;
	private String username;
	private Address address;
	private String password;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password= password;
	}
	public int getCustID() {
		return custID;
	}
	public void setCustID(int custID) {
		this.custID = custID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public void registerUser() {
		Customer cust = new Customer();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Name");
		cust.setName(sc.next());
		System.out.println("Enter Number");
		cust.setNumber(sc.next());
		System.out.println("Enter Addr");
		Address ad = new Address();
		System.out.println("Enter Street");
		ad.setStreet(sc.next());
		System.out.println("Enter City");
		ad.setStreet(sc.next());
		System.out.println("Enter pinCode");
		ad.setPincode(sc.nextInt());
		cust.setAddress(ad);
		System.out.println("Enter Username");
		cust.setUsername(sc.next());
		System.out.println("Enter Pass");
		cust.setPassword(sc.next());
		//setCustID();
		//and push in database- id,pass
		MySqlCon mysqlcon = new MySqlCon();
		try {
			//Object ob = mysqlcon.executeQuery("", 6969);
			//Connection c = (Connection) ob;
			//c.setAutoCommit(false);
			mysqlcon.executeQuery("INSERT INTO customer(custerName, phonenumber) VALUES("
				+ "'"+ cust.getName() + "'"+ "," + "'"+ Integer.parseInt(cust.getNumber()) + "'"+
			");",3);
			String query1 = "SELECT customerId FROM customer WHERE phonenumber = '" + cust.getNumber() + "'";
			String id = mysqlcon.executeQuery(query1, 2).toString();
			String query2= "INSERT INTO customerlogin VALUES('"+ id+ "','"+ cust.getUsername() +"','" + cust.getPassword() +"')";
			mysqlcon.executeQuery(query2,3);
			//c.commit();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	public int signIn() {
		MySqlCon mysqlcon = new MySqlCon();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter username");
		String un = sc.next();
		System.out.println("Enter Password");
		String pass = sc.next();
		String query1="SELECT customerId FROM customerlogin WHERE customeruserName='"+ un +"' AND customerPassword = '" + pass + "';";
		String id = mysqlcon.executeQuery(query1, 2).toString();
		if(id.length()>0) {
			return Integer.parseInt(id);
		}
		return -1;
	}
}
