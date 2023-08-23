package quickFood;

public class Customer {

	// this is the customer object where the customers details are created
	String customerName;
	String customerContactNumber;
	String customerAddress;
	String customerLocation;
	String customerEmailAddress;

	// this is the customer constructor which is used to fill in the details of the
	// customer
	Customer(String customerName, String customerContactNumber, String customerAddress, String customerLocation,
			String customerEmailAddress) {
		this.customerName = customerName;
		this.customerContactNumber = customerContactNumber;
		this.customerAddress = customerAddress;
		this.customerLocation = customerLocation;
		this.customerEmailAddress = customerEmailAddress;
	}

	// below is a method for customers that are far away
	// it is created here because there is space available and so that the other
	// classes are not to long
	public String unavailableInvoice() {

		String customerInvoice = "Sorry! Our drivers are too far away from you to be able to deliver to your location.";

		return customerInvoice;
	}
}
