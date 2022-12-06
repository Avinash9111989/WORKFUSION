package com.workfusion.movieticket;

public class Tester_MovieTicket {
    public static void main(String[] args) {
        MovieTicket movieTicket = new MovieTicket(112, 3);
        movieTicket.costPerTicket=100;
        double amount = movieTicket.calculateTotalAmount();
        if (amount==0)
            System.out.println("Sorry! Please enter valid movie Id and number of seats");
        else
            System.out.println("Total amount for booking : $" + amount);
    }

}
