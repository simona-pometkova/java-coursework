import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Customer extends User {
	private List<Product> basket;
	
	//Constructor
	public Customer(int userID, 
					String username, 
					String surname, 
					Address address, 
					List<Product> basket) { 
		super(userID, username, surname, address);
		this.basket = basket;
	}
	public List<Product> getShoppingBasket() {
		return this.basket;
	}
	//Takes a Product object and adds it to the basket (List<Product>)
	public void addItem(Product prod) {
		this.basket.add(prod);
	}
	/* Takes a CreditCard object and pays for all items in basket.
	 * Activity is logged by adding a LogDetails object to ActivityLog.txt.
	 * Appropriate message for payment is shown and the stock is
	 * updated in the frame (CustomerCreditCard.java), after which the 
	 * basket is cleared.
	 */
	public void payItems(CreditCard card) throws Exception { 	
		List<LogDetails> details = ActivityLog.createLogList();
		LogDetails log = null;
		DateTimeFormatter dtInput = DateTimeFormatter.ofPattern("dd-MM-yyyy");

		for (Product prod: this.basket) {
			String dateString = dtInput.format(LocalDate.now());
			log = new LogDetails(getID(), 
								 getAddress().getPostcode(), 
								 prod.getBarcode(),
								 prod.getRetailPrice(),
								 prod.getQuantityInStock(),
								 "purchased",
								 "Credit Card",
								 dateString);
			details.add(0, log);
		}
		BufferedWriter br = new BufferedWriter(new FileWriter("ActivityLog.txt"));
		for (LogDetails logDet : details) {
			br.write(logDet.toString());
			br.newLine();
		}
		br.close();
	}
	/* Takes a PayPal object and pays for all items in basket.
	 * Activity is logged by adding a LogDetails object to ActivityLog.txt.
	 * Appropriate message for payment is shown and the stock is
	 * updated in the frame (CustomerPayPal.java), after which the 
	 * basket is cleared.
	 */
	public void payItems(PayPal paypal) throws Exception {		
		List<LogDetails> details = ActivityLog.createLogList();
		LogDetails log = null;
		DateTimeFormatter dtInput = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		for (Product prod: this.basket) {
			String dateString = dtInput.format(LocalDate.now());
			log = new LogDetails(getID(), 
								 getAddress().getPostcode(), 
								 prod.getBarcode(),
								 prod.getRetailPrice(),
								 prod.getQuantityInStock(),
								 "purchased",
								 "PayPal",
								 dateString);
			details.add(0, log);
		}
		BufferedWriter br = new BufferedWriter(new FileWriter("ActivityLog.txt"));
		for (LogDetails logDet : details) {
			br.write(logDet.toString());
			br.newLine();
		}
		br.close();
	}
	/* This method allows the customer to view all products that are 
	 * currently in stock with all their attributes, except the original cost. 
	 * It works by creating an instance of the CustomerViewProducts frame.
	 */
	public void viewProducts() throws Exception {
		CustomerViewProducts availableProducts = new CustomerViewProducts();
		availableProducts.setTitle("Available products");
		availableProducts.setLocationRelativeTo(null);
		availableProducts.setVisible(true);
	}
	/* This method cancels all items currently in the customer's basket.
	 * Activity is logged by adding a LogDetails object to ActivityLog.txt.
	 * Appropriate message that confirms the cancellation is shown in CustomerFrame.java.
	 * Customer's basket is cleared.
	 */
	public void cancelItems() throws Exception {
		List<LogDetails> details = ActivityLog.createLogList();
		LogDetails log = null;
		DateTimeFormatter dtInput = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		for (Product prod: this.basket) {
			String dateString = dtInput.format(LocalDate.now());
			log = new LogDetails(getID(),
								 getAddress().getPostcode(),
								 prod.getBarcode(),
								 prod.getRetailPrice(),
								 prod.getQuantityInStock(),
								 "cancelled",
								 "",
								 dateString);
			details.add(0, log);
		}
		BufferedWriter br = new BufferedWriter(new FileWriter("ActivityLog.txt"));
		for (LogDetails logDet: details) {
			br.write(logDet.toString());
			br.newLine();
		}
		basket.clear();
		br.close();
	}
	/* This method saves all items currently in the customer's basket for later.
	 * Activity is logged by adding a LogDetails object to ActivityLog.txt.
	 * Appropriate message that confirms the action is shown in CustomerFrame.java.
	 * Customer's basket is cleared.
	 */
	public void saveForLater() throws Exception {
		List<LogDetails> details = ActivityLog.createLogList();
		LogDetails log = null;
		DateTimeFormatter dtInput = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		for (Product prod: this.basket) {
			String dateString = dtInput.format(LocalDate.now());
			log = new LogDetails(getID(),
								 getAddress().getPostcode(),
								 prod.getBarcode(),
								 prod.getRetailPrice(),
								 prod.getQuantityInStock(),
								 "saved",
								 "",
								 dateString);
			details.add(0, log);
		}
		BufferedWriter br = new BufferedWriter(new FileWriter("ActivityLog.txt"));
		for (LogDetails logDet: details) {
			br.write(logDet.toString());
			br.newLine();
		}
		basket.clear();
		br.close();
	}
	@Override
	public String toString() {
		return (+getID()+", "+getUsername()+", "+getSurname());
	}
	/* This method creates a list of customers by reading
	 * UserAccounts.txt and creating a Customer object from every
	 * customer string.
	 */
	public static class CustomerList {
		//This method creates a list by reading from "UserAccounts.txt"
		public static List<Customer> createCustomerList() throws FileNotFoundException {
			List<Customer> customerList = new ArrayList<Customer>();
			File readFrom = new File("UserAccounts.txt");
			Scanner scanner = new Scanner(readFrom);
			Customer customer = null;
			while (scanner.hasNextLine()) {
				String[] details = scanner.nextLine().split(",");
				if ((details[6]).trim().equals("customer")) {
					List<Product> basket = new ArrayList<Product>();
					customer = new Customer(Integer.parseInt(details[0]), 
								           details[1].trim(), details[2].trim(),
								           Address.parse(Integer.parseInt(details[3].trim()), details[4].trim(), details[5].trim()),
								           basket);
					customerList.add(customer);
				} 
			}
			scanner.close();
			return customerList;
		}
	}
}
