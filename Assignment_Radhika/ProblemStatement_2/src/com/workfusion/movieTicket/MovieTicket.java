package com.workfusion.movieTicket;

public class MovieTicket {
	private int movieId;
	private int noOfSeats;
	private double totalAmount;
	public MovieTicket(int movieId, int noOfSeats) {
		super();
		this.movieId = movieId;
		this.noOfSeats = noOfSeats;
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public int getNoOfSeats() {
		return noOfSeats;
	}
	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}
	
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	public double calculateTotalAmount() {
		totalAmount=(int) Math.round(100*noOfSeats)+(100*noOfSeats)*(2.0/100);
		return totalAmount;
		
	}

}
