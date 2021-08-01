import java.awt.Color;
import java.awt.Font;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class CustomerAddItem extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	public CustomerAddItem(Customer customer) throws Exception {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 568, 259);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("1. Select item:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 532, 28);
		contentPane.add(lblNewLabel);
		
		JComboBox<Product> selectItem = new JComboBox<Product>();
		selectItem.setBounds(61, 41, 431, 20);
		contentPane.add(selectItem);
		List<Product> stock = Stock.createStockList();
		for (Product prod: stock) {
			selectItem.addItem(prod);
		}
		
		JLabel selectQuantity = new JLabel("2. Select quantity:");
		selectQuantity.setHorizontalAlignment(SwingConstants.CENTER);
		selectQuantity.setFont(new Font("Tahoma", Font.PLAIN, 14));
		selectQuantity.setBounds(10, 72, 532, 28);
		selectQuantity.setVisible(true);
		contentPane.add(selectQuantity);
		selectItem.setSelectedItem(selectItem.getSelectedItem());
		
		textField = new JTextField();
		textField.setBounds(232, 99, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel notEnough = new JLabel("You can't buy more than there is in stock");
		notEnough.setHorizontalAlignment(SwingConstants.CENTER);
		notEnough.setBounds(162, 140, 240, 14);
		notEnough.setForeground(Color.red);
		notEnough.setVisible(false);
		contentPane.add(notEnough);
		
		JLabel alreadyInBasket = new JLabel("This item is already in your basket");
		alreadyInBasket.setHorizontalAlignment(SwingConstants.CENTER);
		alreadyInBasket.setBounds(162, 140, 227, 14);
		alreadyInBasket.setVisible(false);
		alreadyInBasket.setForeground(Color.red);
		contentPane.add(alreadyInBasket);
		
		JLabel invalidData = new JLabel("Please provide valid data");
		invalidData.setHorizontalAlignment(SwingConstants.CENTER);
		invalidData.setBounds(162, 140, 227, 14);
		invalidData.setForeground(Color.red);
		invalidData.setVisible(false);
		contentPane.add(invalidData);	
		
		JLabel success = new JLabel("Item added");
		success.setBounds(376, 171, 116, 14);
		success.setForeground(new Color(18, 132, 37));
		success.setVisible(false);
		contentPane.add(success);
		
		JButton btnNewButton = new JButton("Add to basket");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/* On button pressed, proceeds to create product attributes
				 * by taking the values of the panel objects. If the quantity
				 * the customer chooses is more than the stock's availability, 
				 * or if the chosen item is already in the customer's basket, show
				 * appropriate message. Otherwise, show a confirmation message 
				 * and add the item to the customer's basket.
				 */
				Product prod = (Product)selectItem.getSelectedItem();
				int barcode = prod.getBarcode();
				String brand = prod.getBrand();
				String colour = prod.getColour();
				Connectivity conn = prod.getConnectivity();
				double origCost = prod.getOriginalCost();
				double retPrice = prod.getRetailPrice();
				int compareQuantity = prod.getQuantityInStock();				
				try {
					int quantity = Integer.parseInt(textField.getText());
					try {
						if (prod instanceof Mouse) {
							int numButtons = ((Mouse) prod).getNumOfButtons();
							MouseType mType = ((Mouse) prod).getMouseType();
							Mouse mouse = new Mouse(barcode, brand, colour, conn, quantity, origCost, retPrice, numButtons, mType);
							if (quantity > compareQuantity) {
								alreadyInBasket.setVisible(false);
								notEnough.setVisible(true);
								invalidData.setVisible(false);
								success.setVisible(false);								
							} else if (Product.isAlreadyInBasket(customer, prod)){
								alreadyInBasket.setVisible(true);
								notEnough.setVisible(false);
								invalidData.setVisible(false);
								success.setVisible(false);
							} else {
								alreadyInBasket.setVisible(false);
								notEnough.setVisible(false);
								invalidData.setVisible(false);
								success.setVisible(true);
								customer.addItem(mouse);
							}															
						} else if (prod instanceof Keyboard) {
							int quan = Integer.parseInt(textField.getText());
							KeyboardType kType = ((Keyboard) prod).getKeyboardType();
							Layout kLayout = ((Keyboard) prod).getKeyboardLayout();
							Keyboard keyboard = new Keyboard(barcode, brand, colour, conn, quan, origCost, retPrice, kType, kLayout);
							if (quantity > compareQuantity)  {
								alreadyInBasket.setVisible(false);
								notEnough.setVisible(true);
								invalidData.setVisible(false);
								success.setVisible(false);															
							} else if (Product.isAlreadyInBasket(customer, prod)){
								alreadyInBasket.setVisible(true);
								notEnough.setVisible(false);
								invalidData.setVisible(false);
								success.setVisible(false);
							} else {
								alreadyInBasket.setVisible(false);
								notEnough.setVisible(false);
								invalidData.setVisible(false);
								success.setVisible(true);
								customer.addItem(keyboard);
							}																				
						}
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				} catch (NumberFormatException e1) {
					invalidData.setVisible(true);
				} 
			}

		});	
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(192, 156, 174, 39);
		contentPane.add(btnNewButton);
	}
}
