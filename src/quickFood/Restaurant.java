package quickFood;

public class Restaurant extends Customer {

	// this is the restaurant object where the restaurant details are created it
	// also extends the customer class
	String orderNumber;
	String restaurantName;
	String restaurantLocation;
	String restaurantContactNumber;
	String mealsBeingOrderedAndPrices;
	String specialInstructionsFromCustomer;
	double totalAmountPaid;
	String yourDriver;

	// this is the restaurant constructor which is used to fill in the details of
	// the restaurant it extends the customer object to make it easy to record
	// details
	Restaurant(String customerName, String customerContactNumber, String customerAddress, String customerLocation,
			String customerEmailAddress, String orderNumber, String restaurantName, String restaurantLocation,
			String restaurantContactNumber, String mealsBeingOrderedAndPrices, String specialInstructionsFromCustomer,
			double totalAmountPaid, String yourDriver) {
		super(customerName, customerContactNumber, customerAddress, customerLocation, customerEmailAddress);
		this.orderNumber = orderNumber;
		this.restaurantName = restaurantName;
		this.restaurantLocation = restaurantLocation;
		this.restaurantContactNumber = restaurantContactNumber;
		this.mealsBeingOrderedAndPrices = mealsBeingOrderedAndPrices;
		this.specialInstructionsFromCustomer = specialInstructionsFromCustomer;
		this.totalAmountPaid = totalAmountPaid;
		this.yourDriver = yourDriver;
	}

	// below is a method to convert all the details into a string which serves as an
	// invoice for the customer and restaurant
	// this invoice is the main reason for extending the restaurant class because if
	// the class was not extended all the details from customer to restaurant would
	// be called
	// to fill in the details in the main method which would make the method long
	public String toInvoice() {
		String output = "Order Number: " + orderNumber;
		output += "\nCustomer: " + customerName;
		output += "\nEmail: " + customerEmailAddress;
		output += "\nPhone Number: " + customerContactNumber;
		output += "\nLocation:" + customerLocation;
		output += "\n" + "\nYou have ordered the following from " + restaurantName + " in " + restaurantLocation + ": ";
		output += "\n" + mealsBeingOrderedAndPrices;
		output += "\n" + "\nSpecial preparation Instructions: " + specialInstructionsFromCustomer;
		output += "\n" + "\nTotal: R" + totalAmountPaid;
		output += "\n" + "\n" + yourDriver
				+ " is nearest to the restaurant and so he/she will be delivering your order to you at: ";
		output += "\n" + "\n" + customerAddress;
		output += "\n" + "\nIf you need to contact the restaurant, their number is " + restaurantContactNumber;

		return output;
	}
}
