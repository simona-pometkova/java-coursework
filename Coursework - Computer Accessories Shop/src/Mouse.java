public class Mouse extends Product {
	private int numOfButtons;
	private MouseType mouseType;
	
	//Constructor
	public Mouse(int barcode,  
			     String brand, 
			     String colour, 
			     Connectivity connectivity, 
			     int quantityInStock, 
			     double originalCost, 
			     double retailPrice, 
			     int numOfButtons, 
			     MouseType mouseType) {
		super(barcode, brand, colour, connectivity, quantityInStock, originalCost, retailPrice);
		this.numOfButtons = numOfButtons;
		this.mouseType = mouseType;
	}
	public int getNumOfButtons() {
		return this.numOfButtons;
	}
	public MouseType getMouseType() {
		return this.mouseType;
	}
	@Override
	public String toString() {
		return (getBarcode()+", mouse, "
				+getMouseType()+", "
				+getBrand()+", "
				+getColour()+", "
				+getConnectivity()+", "
				+getQuantityInStock()+", "
				+getOriginalCost()+", "
				+getRetailPrice()+", "
				+getNumOfButtons());
	}
	/* This is how each mouse product with its information appears in the customer' basket
	 * (when creating a CustomerViewBasket.java frame).
	 */
	public String viewBasket() {
		return ("Product: mouse\nType: "+getMouseType()
				+"\nBrand: "+getBrand()
				+"\nColour: "+getColour()
				+"\nConnectivity: "+getConnectivity()
				+"\nNumber of Buttons: "+getNumOfButtons()
				+"\nQuantity: "+getQuantityInStock()
				+"\nPrice (each): £ "+getRetailPrice()+"\n--------------------");
	}
}
