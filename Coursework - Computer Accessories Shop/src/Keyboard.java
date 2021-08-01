public class Keyboard extends Product{
	private KeyboardType keyboardType;
	private Layout keyboardLayout;
	
	//Constructor
	public Keyboard(int barcode,  
					String brand, 
					String colour, 
					Connectivity connectivity, 
					int quantityInStock, 
					double originalCost, 
					double retailPrice, 
					KeyboardType keyboardType, 
					Layout keyboardLayout) {
		super(barcode, brand, colour, connectivity, quantityInStock, originalCost, retailPrice);
		this.keyboardType = keyboardType;
		this.keyboardLayout = keyboardLayout;
	}
	public KeyboardType getKeyboardType() {
		return this.keyboardType;
	}
	public Layout getKeyboardLayout() {
		return this.keyboardLayout;
	}
	@Override
	public String toString() {
		return (getBarcode()+", keyboard, "
				+getKeyboardType()+", "
				+getBrand()+", "
				+getColour()+", "
				+getConnectivity()+", "
				+getQuantityInStock()+", "
				+getOriginalCost()+", "
				+getRetailPrice()+", "
				+getKeyboardLayout());
	}
	/* This is how each keyboard product with its information appears in the customer' basket
	 * (when creating a CustomerViewBasket.java frame).
	 */
	public String viewBasket() {
		return ("Product: keyboard\nType: "+getKeyboardType()
				+"\nBrand: "+getBrand()
				+"\nColour: "+getColour()
				+"\nConnectivity: "+getConnectivity()
				+"\nLayout: "+getKeyboardLayout()
				+"\nQuantity: "+getQuantityInStock()
				+"\nPrice (each): £ "+getRetailPrice()+"\n--------------------");
	}
}
