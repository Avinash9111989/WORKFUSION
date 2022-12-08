package com.workfusion.services;

import com.workfusion.beans.Customer;

public interface Orderservices {
	public void order();
	public void cancelOrder(int option);
	public void displayOrder(Customer c);
	public void cartDisplay(Customer c);
}
