package payments;

public class Tester {
	public static void main(String[] args) {
		DebitCardPayment dcp=new DebitCardPayment(101);
		System.out.println("Total bill amount: "+dcp.payBill(500));
		
		System.out.println();
	
		CreditCardPayment ccp=new CreditCardPayment(102);
		System.out.println("Total bill amount: "+ccp.payBill(1000));
		
		System.out.println(); 
		
		CreditCardPayment ccp1=new CreditCardPayment(103);	
		System.out.println("Total bill amount: "+ccp1.payBill(1000));
	}
}

	
	
		
