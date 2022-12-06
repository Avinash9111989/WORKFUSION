package com.workfusion.movieTicket;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MovieTicket movieTicket = new MovieTicket(112, 3);
		double amount = movieTicket.calculateTotalAmount();
		if (amount==0)
		System.out.println("Sorry! Please enter valid movie Id and number of seats");
		else
		System.out.println("Total amount for booking : " + amount);
	}

}
