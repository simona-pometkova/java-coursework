import java.io.*;
import java.util.*;
/* Creates a stocklist by reading from Stock.txt and creating an object
 * from each line by parsing appropriate values.
 */
public class Stock {
	public static List<Product> createStockList() throws IOException {
		List<Product> productList = new ArrayList<Product>();
		File readFrom = new File("Stock.txt");
		Scanner scanner = new Scanner(readFrom);
		Keyboard keyboard = null;
		Mouse mouse = null;
		while (scanner.hasNextLine()) {
			String[] details = scanner.nextLine().split(",");
			if ((details[1]).trim().equals("mouse")) {
				//Creates mouse products of Mouse class
				mouse = new Mouse(Integer.parseInt(details[0].trim()), 
							      details[3].trim(), details[4].trim(), 
							      Enum.valueOf(Connectivity.class, (details[5].trim()).toUpperCase()), 
							      Integer.parseInt(details[6].trim()), 
							      Double.parseDouble(details[7].trim()), 
							      Double.parseDouble(details[8].trim()), 
							      Integer.parseInt(details[9].trim()), 
							      Enum.valueOf(MouseType.class, (details[2].trim().toUpperCase())));
				productList.add(mouse);
			} else if ((details[9].trim()).equals("UK") || (details[9].trim()).equals("US")) {
				//Creates keyboard products of Keyboard class
				keyboard = new Keyboard(Integer.parseInt(details[0].trim()), 						                
						                details[3].trim(), details[4].trim(), 
						                Enum.valueOf(Connectivity.class, (details[5].trim()).toUpperCase()), 
						                Integer.parseInt(details[6].trim()), 
						                Double.parseDouble(details[7].trim()), 
						                Double.parseDouble(details[8].trim()), 
						                Enum.valueOf(KeyboardType.class, (details[2].trim()).toUpperCase()), 
						                Enum.valueOf(Layout.class, (details[9].trim()).toUpperCase()));
				productList.add(keyboard);
			}
		} 
		scanner.close();
		return productList;
	}
	//Overwrites "Stock.txt" with new data after customer has purchased products.
	public static void updateStockList(List<Product> stock, Customer c1) throws IOException {
		List<Product> basket = c1.getShoppingBasket();
		List<Product> newStock = new ArrayList<Product>();
		BufferedWriter br = new BufferedWriter(new FileWriter("Stock.txt"));
		
		for (Product prod : stock) {
			for (Product prod1 : basket) {
				if (prod1.compare(prod) && prod1.getBarcode() == prod.getBarcode()) {
					prod.setQuantity(prod.getQuantityInStock() - prod1.getQuantityInStock());
				} //add else-if statement
			}
			newStock.add(prod);
		}
		for (Product pr: newStock) {
			br.write(pr.toString());
			br.newLine();
		}
		br.close();
		basket.clear();
	}
}