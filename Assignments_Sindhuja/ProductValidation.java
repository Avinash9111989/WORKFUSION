package com.shoppe;

import com.shoppe.ProductService;

public class ProductValidation {
	
	ProductService prodrepo = new ProductService();
	public boolean isValidProductId(int productId) {
		boolean prodstatus=false;
		prodstatus=prodrepo.checkProductExistence(productId);
		return prodstatus;
	}

}
