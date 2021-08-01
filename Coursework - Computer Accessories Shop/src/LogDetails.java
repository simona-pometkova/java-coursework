/* This class is used to create a "log" object 
 * from every line in the ActivityLog.txt file.
 */
public class LogDetails {
	private int userID, barcode, quantity;
	private String postcode, status, paymentMethod;
	private double retailPrice;
	private String date;
	
	//Constructor
	public LogDetails(int userID, String postcode, int barcode,
					  double retailPrice, int quantity, String status,
					  String paymentMethod, String date) {
		this.userID = userID;
		this.postcode = postcode;
		this.barcode = barcode;
		this.retailPrice = retailPrice;
		this.quantity = quantity;
		this.status = status;
		this.paymentMethod = paymentMethod;
		this.date = date;	
	}
	public int getID() {
		return this.userID;
	}
	public int getBarcode() {
		return this.barcode;
	}
	public int getQuantity() {
		return this.quantity;
	}
	public String getPostcode() {
		return this.postcode;
	}
	public String getStatus() {
		return this.status;
	}
	public String getPaymentMethod() {
		return this.paymentMethod;
	}
	public double getPrice() {
		return this.retailPrice;
	}
	public String getDate() {
		return this.date;
	}
	@Override
	public String toString() {
		return (getID()+", "+getPostcode()+", "+getBarcode()+", "
				+getPrice()+", "+getQuantity()+", "+getStatus()+", "
				+getPaymentMethod()+", "+getDate());
	}
//	public int compareTo(LogDetails log) {
//		return (log.getDate().compareTo(this.getDate()));
//	}
}
