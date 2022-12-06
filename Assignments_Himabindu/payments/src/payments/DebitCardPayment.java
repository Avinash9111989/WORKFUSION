package payments;

public class DebitCardPayment extends Payment {

	private static int counter;
	private double discountPercentage;
	static{
		counter = 1000;
	}

	public DebitCardPayment(int customerId) {
		super(customerId);
		System.out.println("Customer Id: "+getCustomerId());
		counter++;
		setPaymentId("D"+counter);
		System.out.println("Payment Id: "+getPaymentId());
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public double getDiscountPercentage() {
		return discountPercentage;
	}

	public void setDiscountPercentage(double discountPercentage) {
		this.discountPercentage = discountPercentage;
	}

	public double payBill(double amount) {
		if (amount <= 500) {
			setServiceTaxPercentage(2.5);
			discountPercentage = 1;
			System.out.println("Service tax percentage: " + getServiceTaxPercentage());
			System.out.println("Discount percentage: " + discountPercentage);
			return amount + ((getServiceTaxPercentage() * amount) / 100) - ((discountPercentage * amount) / 100);

		} else if (amount > 500 && amount <= 1000) {
			setServiceTaxPercentage(4);
			discountPercentage = 2;
			System.out.println("Service tax percentage: " + getServiceTaxPercentage());
			System.out.println("Discount percentage: " + discountPercentage);
			return amount + ((getServiceTaxPercentage() * amount) / 100) - ((discountPercentage * amount) / 100);
		} else {
			setServiceTaxPercentage(5);
			discountPercentage = 3;
			System.out.println("Service tax percentage: " + getServiceTaxPercentage());
			System.out.println("Discount percentage: " + discountPercentage);
			return amount - ((getServiceTaxPercentage() * amount) / 100) + ((discountPercentage * amount) / 100);
		}

	}

}
