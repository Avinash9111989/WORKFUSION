package jdbc_test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
	public static void main(String args[]) {
//		MySqlCon mysqlcon = new MySqlCon();
//		try {
//			var x = mysqlcon.executeQuery("select * from customer",2);
//			System.out.println(x);
//		}
//		catch(Exception e) {
//			System.out.println(e);
//		}
		
		int loggedIn = -1;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		List<Product> products = new ArrayList<Product>();
		int opt=0;
		Product p = new Product(1, "Laptop", 500, "Electronics");
		Product p1 = new Product(2, "iPhone", 300, "Electronics");
		Product p2 = new Product(3, "Cap", 10, "Fashion");
		products.add(p);
		products.add(p1);
		products.add(p2);
		Customer cust = new Customer();
		
		do{
			System.out.println("--------------");
			System.out.println("1. Register");
			System.out.println("2. Login");
			System.out.println("3. View Products");
			System.out.println("4. Order");
			if(loggedIn!=-1) {
				System.out.println("5. My Orders");
				System.out.println("6. Exit");
			}
			else {
				System.out.println("5. Exit");
			}
			opt = sc.nextInt();
			MySqlCon mysqlcon = new MySqlCon();
			switch(opt) {
				case 1 : 
						cust.registerUser();
						break;
				case 2 :
						loggedIn = cust.signIn();
						if(loggedIn != -1) {
							System.out.println("log in ID = "+ loggedIn);
						}
						else {
							System.out.println("wrong id pass");
						}
						break;
				case 3 : 
						for(int i=0; i<products.size(); i++) {
							System.out.println(products.get(i).getProdID() + "\t" +products.get(i).getName() + "\t" + products.get(i).getPrice() +"\t"+ products.get(i).getProductType());
						}
						break;
				case 4 : 
						Order order1 = new Order();
						if(loggedIn==-1) {
							System.out.println("Register/ Login before Purchasing");
						}
						else {
							int [] arrRes = order1.placeOrder(products.size());
							System.out.println(arrRes[0] + "" + arrRes[1]);

							String temp= "INSERT INTO orders(customerId, productId, amount, orderDate) values ("
									+loggedIn+ ","
									+arrRes[0]+ ","
									+products.get(arrRes[0]).getPrice()+ ",NOW())";
							for(int i=0; i<arrRes[1]; i++) {
								mysqlcon.executeQuery(temp, 3);
							}
						}
						break;
				case 5 : 
						if(loggedIn!=-1) {
							String temp = "SELECT * FROM  orders where customerId="+loggedIn+";";
							System.out.println("orderId customerId tproductId amount orderDate");
							mysqlcon.executeQuery(temp, 4).toString();
						}
						else {
							System.out.println("5. Exit");
						}
						break;
				default : break;
			}
			
		}while(loggedIn!=-1? opt<=5 : opt<=4);
	
	}
}
