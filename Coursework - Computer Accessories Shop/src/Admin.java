import java.io.*;
import java.util.*;

public class Admin extends User {
	
	//Constructor
	public Admin(int userID, 
				 String username, 
				 String surname, 
				 Address address) {
		super(userID, username, surname, address);
	}
	/* This method adds a mouse item at the end on a new line in Stock.txt 
	 * by taking attributes chosen by the administrator and creating a Mouse 
	 * object from them.
	 */
	public void addMouse(int barcode, 						 
						String brand, 
						String colour, 
						Connectivity conn, 
						int quantityInStock, 
						double originalCost, 
						double retailPrice, 
						int numOfButtons, 
						MouseType mouseType) throws IOException {
		Mouse mouse = new Mouse(barcode, brand, colour, conn, quantityInStock, originalCost, retailPrice, numOfButtons, mouseType);
		File writeTo = new File("Stock.txt");
		FileWriter fr = new FileWriter(writeTo, true);
		BufferedWriter br = new BufferedWriter(fr);
		br.write(mouse.toString()+"\n");		
		br.close();
		fr.close();
	}
	/* This method adds a keyboard item at the end on a new line in Stock.txt 
	 * by taking attributes chosen by the administrator and creating a Keyboard 
	 * object from them.
	 */
	public void addKeyboard(int barcode,
							String brand,
							String colour,
							Connectivity conn,
							int quantityInStock,
							double originalCost,
							double retailPrice,
							KeyboardType keyboardType,
							Layout keyboardLayout) throws IOException {
		Keyboard keyboard = new Keyboard(barcode, brand, colour, conn, quantityInStock, originalCost, retailPrice, keyboardType, keyboardLayout);
		File writeTo = new File("Stock.txt");
		FileWriter fr = new FileWriter(writeTo, true);
		BufferedWriter br = new BufferedWriter(fr);
		br.write(keyboard.toString()+"\n");		
		br.close();
		fr.close();
	}
	/* This method allows the administrator to view all products that are 
	 * currently in stock with all their attributes. It works by creating an instance
	 * of the AdminViewProducts frame.
	 */
	public void viewProducts() throws Exception {
		AdminViewProducts viewProducts = new AdminViewProducts();
		viewProducts.setTitle("Stock");
		viewProducts.setLocationRelativeTo(null);
		viewProducts.setVisible(true);		
	}
	@Override
	public String toString() {
		return (+getID()+", "+getUsername()+", "+getSurname());
	}
	/* This method creates a list of administrators by reading
	 * UserAccounts.txt and creating an Admin object from every
	 * administrator string.
	 */
	public static class AdminList {
		public static List<Admin> createAdminList() throws FileNotFoundException {
			List<Admin> adminList = new ArrayList<Admin>();
			File readFrom = new File("UserAccounts.txt");
			Scanner scanner = new Scanner(readFrom);
			Admin admin = null;
			while (scanner.hasNextLine()) {
				String[] details = scanner.nextLine().split(",");
				if ((details[6]).trim().equals("admin")) {
					admin = new Admin(Integer.parseInt(details[0]),
									 details[1].trim(), details[2].trim(),
									 Address.parse(Integer.parseInt(details[3].trim()), details[4].trim(), details[5].trim()));
					adminList.add(admin);
				}
			}
			scanner.close();
			return adminList;
		}
	}
}
