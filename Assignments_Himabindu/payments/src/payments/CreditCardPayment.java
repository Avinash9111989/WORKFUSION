package payments;

public class CreditCardPayment extends Payment {
	
	private static int counter;
	
	static{
		counter=1000;
	}
	
	public CreditCardPayment(int customerId) {
		super(customerId);
		System.out.println("Customer Id: "+getCustomerId());
		counter++;
		setPaymentId("C"+counter);
		System.out.println("Payment Id: "+getPaymentId());
		
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public double payBill(double amount) {
		if (amount <= 500) {
			setServiceTaxPercentage(3);
			
			return amount-((getServiceTaxPercentage()*amount)/100);
	
		} else if (amount > 500 && amount <= 1000) {
			setServiceTaxPercentage(5);
			System.out.println("Service tax percentage: "+getServiceTaxPercentage());
			return amount-((getServiceTaxPercentage()*amount)/100);
		}	
		else {
			setServiceTaxPercentage(6);
			
			return amount-((getServiceTaxPercentage()*amount)/100);                  
		}
			

	}

}
