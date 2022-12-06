package com.workfusion.validation;

import com.workfusion.repository.CustomerRepository;

public class ProductValidation {
	CustomerRepository repo = new CustomerRepository();
	public boolean isValidProductId(int productId) {
		boolean prodstatus=false;
		prodstatus=repo.checkProductExistence(productId);
		return prodstatus;

}
}
