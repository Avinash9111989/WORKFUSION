package com.workfusion.services;

import java.sql.SQLException;

public interface CustomerService 
{

	public void addNewCustomer() throws ClassNotFoundException, SQLException;
	public void updateCustomerDetails() throws ClassNotFoundException, SQLException;
	public boolean customerLogin();
}
