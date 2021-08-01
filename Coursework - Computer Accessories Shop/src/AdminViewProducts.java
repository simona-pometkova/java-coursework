import java.util.Collections;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
/* Creates a scrollable table, which shows every product in the stock
 * with all their attributes as separate columns.
 */
public class AdminViewProducts extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable stock;
	private DefaultTableModel dtStock;

	public AdminViewProducts() throws Exception {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 977, 416);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 0, 951, 376);
		contentPane.add(scrollPane);
		
		stock = new JTable();
		stock.setDefaultEditor(Object.class, null);
		dtStock = new DefaultTableModel();
		scrollPane.setViewportView(stock);
		dtStock.setColumnIdentifiers(new Object[] {"Barcode", "Product", "Type", 
												   "Brand", "Colour", "Connectivity", 
												   "In stock", "Original cost", 
												   "Retail price", "Other"});
		stock.setModel(dtStock);
		List<Product> productList = Stock.createStockList();
		Collections.sort(productList);
		for (Product prod: productList) {
			Object[] data;
			
			int barcode = prod.getBarcode();
			String brand = prod.getBrand();
			String colour = prod.getColour();
			Connectivity conn = prod.getConnectivity();
			int quantity = prod.getQuantityInStock();
			double origCost = prod.getOriginalCost();
			double retPrice = prod.getRetailPrice();
			
			if (prod instanceof Mouse) {
				String product = "mouse";
				MouseType mType = ((Mouse) prod).getMouseType();
				int buttons = ((Mouse) prod).getNumOfButtons();
				data = new Object[] {barcode, product, mType, brand, colour, conn, quantity, "£ "+origCost, "£ "+retPrice, buttons};
				dtStock.addRow(data);
			} else if (prod instanceof Keyboard) {
				String product = "keyboard";
				KeyboardType kType = ((Keyboard) prod).getKeyboardType();
				Layout kLayout = ((Keyboard) prod).getKeyboardLayout();
				data = new Object[] {barcode, product, kType, brand, colour, conn, quantity, "£ "+origCost, "£ "+retPrice, kLayout};
				dtStock.addRow(data);
			}
		}		
	}
}
