import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
/* Creates a scrollable text panel which displays
 * every item in the customer's basket with its 
 * corresponding information.
 */
public class CustomerViewBasket extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public CustomerViewBasket(Customer customer) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 329, 439);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 303, 388);
		contentPane.add(scrollPane);
		
		JTextPane basket = new JTextPane();
		scrollPane.setViewportView(basket);
		basket.setEditable(false);
		
		int numOfProducts = customer.getShoppingBasket().size();
		
		if (numOfProducts == 0) {
			basket.setText("Your basket is empty");
		} else {
			String cBasket = "You have "+numOfProducts+" item(s) in your basket\n\n";
			for (Product prod: customer.getShoppingBasket()) {	
				String prodData = prod.viewBasket() + "\n";
				cBasket = cBasket + prodData;
			}
			basket.setText(cBasket);
		}		
	}
}
