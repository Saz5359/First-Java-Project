package quickFood;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// below is a scanner which records user input from the console
		Scanner scanword = new Scanner(System.in);

		// this array is used to store the information of the drivers available in the
		// customer/restaurant location
		// the array is also used to find the driver with the least amount of deliveries
		ArrayList<String> availableDrivers = new ArrayList<String>();

		// All restaurant and customer details are recorded from user input

		System.out.println("Enter the Order Number");
		String orderNumber = scanword.nextLine();

		System.out.println("Enter the Customers Name");
		String customerName = scanword.nextLine();

		System.out.println("Enter the Customer Contact Number");
		String customerContactNumber = scanword.nextLine();

		System.out.println("Enter the Customer's Address");
		String customerAddress = scanword.nextLine();

		System.out.println("Enter the Customer's Location");
		String customerLocation = scanword.nextLine();

		System.out.println("Enter the Customer's EmailAddress");
		String customerEmailAddress = scanword.nextLine();

		System.out.println("Enter the Restaurant's Name");
		String restaurantName = scanword.nextLine();

		System.out.println("Enter the Restaurant's Location");
		String restaurantLocation = scanword.nextLine();

		while (!(customerLocation.equalsIgnoreCase(restaurantLocation))) {

			System.out.println("The customer location and resturantlocation do not match");

			System.out.println("Enter the correct location");
			restaurantLocation = scanword.nextLine();
		}

		System.out.println("Enter the Restaurant's Contact Number");
		String restaurantContactNumber = scanword.nextLine();

		String mealsBeingOrderedAndPrices = "";

		double totalAmountPaid = 0;

		String addMeal = "y";

		// this loop is used to record multiple orders and the total
		while (addMeal.equalsIgnoreCase("y")) {
			System.out.println("Enter the meal you want to order");
			String meal = scanword.nextLine();

			System.out.println("Enter the number of " + meal + "'s you want");
			int mealNumber = scanword.nextInt();

			scanword.nextLine();

			// the scan was locale dependent which means it used ',' instead of '.'
			// but now it uses '.' when entering a double
			scanword.useLocale(Locale.US);

			System.out.println("Enter the price of the meal you want to order in 0.00(in decimals):");
			double mealPrice = scanword.nextDouble();

			scanword.nextLine();

			// all ordered meals are added to a string
			mealsBeingOrderedAndPrices += "\n" + mealNumber + " x " + meal + " R" + mealPrice;

			// the price of each meal is added to calculate the total
			totalAmountPaid += mealPrice;

			System.out.println("Would you like to add another order: y/n ?");
			addMeal = scanword.nextLine();

		}

		System.out.println("Enter any Special Instruction's you have for the restaurant");
		String specialInstructionsFromCustomer = scanword.nextLine();

		// the find driver method is called to find a driver
		String yourDriver = findDriver(availableDrivers, customerLocation);

		scanword.close();

		// new restaurant object is created with the info provided
		Restaurant order = new Restaurant(customerName, customerContactNumber, customerAddress, customerLocation,
				customerEmailAddress, orderNumber, restaurantName, restaurantLocation, restaurantContactNumber,
				mealsBeingOrderedAndPrices, specialInstructionsFromCustomer, totalAmountPaid, yourDriver);

		printInvoice(availableDrivers, order);

		System.out.println("Your order is Complete!");
	}

	// this method reads the line of the text file and creates a String array from
	// the line. The array is made of the name, location and number of loads
	// The location is matched with the customer location if it is equal the array
	// is looped through and each element is added to the array created in the
	// main method "availableDrivers"
	// this method is used to find all the drivers available in the customer
	// location and
	// adds all the drivers information into the array
	public static String driversInArea(String driverInfo, String customerLocation, ArrayList<String> array) {
		String[] driverArray = driverInfo.trim().split(", ");

		// the drivers information is added in a name,location,number of loads pattern
		if (driverArray[1].equalsIgnoreCase(customerLocation)) {
			for (int i = 0; i < driverArray.length; i++) {
				array.add(driverArray[i]);
			}
		}
		String word = "Your Drivers are ready";
		return word;
	}

//this method loops through the array which contains all available drivers in the customers location and finds the one with the smallest load
	public static String driver(ArrayList<String> availableDrivers) {

		String yourDriver = "";
//the code is in a statement so if there is no driver in the location nothing is coded and no errors are created
		if (availableDrivers.isEmpty()) {
			yourDriver = "no Driver";

		} else {
			// the third index which is a number/string is changed to a number and is made
			// as the minimum number
			int min = Integer.parseInt((availableDrivers.get(2)));
			int index = 2;
			// the array moves three positions to the numbers and the one with the lowest
			// number is made as the new minimum and its index is recorded
			for (int i = 2; i < availableDrivers.size(); i += 3) {

				if (Integer.parseInt(availableDrivers.get(i)) < min) {
					min = Integer.parseInt(availableDrivers.get(i));
					index = i;
				}
			}
			// the index of the lowest number is used and we move back two places to get the
			// name of the driver
			yourDriver = availableDrivers.get(index - 2);
		}
		return yourDriver;
	}

	// this method read the driver txt to find a driver available in the area and
	// with the smallest load
	// the method calls the drivers in area method and driver method to find the
	// answer
	public static String findDriver(ArrayList<String> availableDrivers, String customerLocation) {
		String driver = "";

		// the try statement reads the drivers file and finds a driver from the text
		// file
		try {
			File file = new File("drivers.txt");
			Scanner scan = new Scanner(file);
			String helperString = "";
			// the loop reads all lines and finds all the drivers in the area and adds them
			// to the array
			while (scan.hasNext()) {
				helperString = helperString.concat(driversInArea(scan.nextLine(), customerLocation, availableDrivers));
			}
			scan.close();
		} catch (FileNotFoundException e) {
			driver = "error - could not find driver";
			e.printStackTrace();
		}

		// the driver method is called to find the driver correct driver from the array
		driver = driver(availableDrivers);

		return driver;
	}

	// this method writes an invoice for the customer
	public static void printInvoice(ArrayList<String> availableDrivers, Restaurant order) {
		String invoice = "";

		// if the availableDrivers array is empty it means no driver
		// was found at the location provided so the unavailable invoice is
		// called and written in the invoicetxt
		// if the availableDrivers is not empty then a driver was found and an invoice
		// is written
		if (availableDrivers.isEmpty()) {
			invoice = order.unavailableInvoice();
		} else {
			invoice = order.toInvoice();
		}

		try {
			FileWriter writer = new FileWriter("invoice.txt");
			writer.write(invoice);
			writer.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
