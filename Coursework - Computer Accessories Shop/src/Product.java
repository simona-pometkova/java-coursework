import java.util.List;
/* Abstract Product class. Specifies the common attributes
 * between Mouse class and Keyboard class, as well as the
 * abstract methods, each further defined in the child classes.
 */
public abstract class Product implements Comparable<Product> {
	private int barcode, quantityInStock;
	private double originalCost, retailPrice;
	private String brand, colour;
	private Connectivity connectivity;
	
	//Constructor
	public Product(int barcode,  
				   String brand, 
				   String colour, 
				   Connectivity connectivity, 
				   int quantityInStock, 
				   double originalCost, 
				   double retailPrice) {
		this.barcode = barcode;
		this.brand = brand;
		this.colour = colour;
		this.connectivity = connectivity;
		this.quantityInStock = quantityInStock;
		this.originalCost = originalCost;
		this.retailPrice = retailPrice;
	}
	public int getBarcode() {
		return this.barcode;
	}
	public int getQuantityInStock() {
		return this.quantityInStock;
	}
	public void setQuantity(int newQuantity) {
		quantityInStock = newQuantity;
	}
	public double getRetailPrice() {
		return this.retailPrice;
	}
	public double getOriginalCost() {
		return this.originalCost;
	}
	public String getBrand() {
		return this.brand;
	}
	public String getColour() {
		return this.colour;
	}
	public Connectivity getConnectivity() {
		return this.connectivity;
	}
	//Abstract methods
	public abstract String toString();
	public abstract String viewBasket();
	
	public int compareTo(Product prod) {
		return prod.getQuantityInStock() - this.getQuantityInStock();
	}
	public boolean compare(Product prod) {
		return (this.getQuantityInStock() <= prod.getQuantityInStock());
	}
	//Checks if the barcode is 6 digits when the administrator tries to add a product.
	public static boolean isSixDigits(int barcode) throws Exception {
		boolean isSixDigits = true;
		int length = String.valueOf(barcode).length();
		if (length != 6) {
			isSixDigits = false;
		}
		return isSixDigits;
	}
	//Check if the barcode already exists when the administrator tries to add a product.
	public static boolean isUnique(int barcode) throws Exception {
		boolean isUnique = true;
		List<Product> stock = Stock.createStockList();
		for (Product prod: stock) {
			if (barcode == prod.getBarcode()) {
				isUnique = false;
			}
		}
		return isUnique;
	}
	//Checks if a product is already present in a customer's basket.
	public static boolean isAlreadyInBasket(Customer customer, Product product) {
		boolean isAlreadyInBasket = false;
		for (Product prod: customer.getShoppingBasket()) {
			if (prod.getBarcode() == product.getBarcode()) {
				isAlreadyInBasket = true;
			}
		}
		return isAlreadyInBasket;
	}
}
