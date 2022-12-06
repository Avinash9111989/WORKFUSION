package payments;

public class Payment {
	private int customerId;
	private String paymentId;
	private double serviceTaxPercentage;
	private double amount;
	
	

	public Payment(int customerId) {
		// super();
		this.customerId = customerId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
		
	}

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
		
	}

	public void setServiceTaxPercentage(double serviceTaxPercentage) {
		this.serviceTaxPercentage = serviceTaxPercentage;
	}
	
	public double getServiceTaxPercentage() {
		return serviceTaxPercentage;
		// TODO Auto-generated method stub
		// return 0;
	}
	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	
	
	

	

	/*public double payBill(double amount) {

	}*/

}
