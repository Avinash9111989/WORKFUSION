package com.workfusion.movieticket;
import java.lang.Math;

public class MovieTicket {
	public int movieId;
	public int noOfSeats;
	public int costPerTicket;
	public MovieTicket (int movieId, int noOfSeats) {
		this.movieId=movieId;
		this.noOfSeats=noOfSeats;
	}

	public double calculateTotalAmount() {
		return Math.round((this.noOfSeats*costPerTicket)+(2*(this.noOfSeats*costPerTicket))/100);	}

}
