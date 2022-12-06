package com.workfusion.ecommerce;

import java.util.Scanner;

public class Purchase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PurchaseDetails p=new PurchaseDetails("P1001","Debit Card") ;
		Seller s=new  Seller("Europe");
		Scanner sc=new Scanner(System.in);
		double price=sc.nextDouble();
	
		double taxPercentage=p.calculateTax(price);
		double taxPercentageLocation=s.calculateTax(price);
		
		System.out.println("Purchase Details");
		System.out.println("*****************");
		System.out.println("Total purchase amount: "+(price+taxPercentage+taxPercentageLocation));
		System.out.println("Tax percentage: "+taxPercentage);

	}
}
