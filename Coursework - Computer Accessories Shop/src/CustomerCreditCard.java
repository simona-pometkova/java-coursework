import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class CustomerCreditCard extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField cardNumber;
	private JTextField securityCode;
	private JLabel invalidData;
	private JLabel confirm;

	public CustomerCreditCard(Customer customer) throws Exception {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 262);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel enterNumber = new JLabel("Enter card number (16 digits):");
		enterNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		enterNumber.setHorizontalAlignment(SwingConstants.CENTER);
		enterNumber.setBounds(10, 11, 414, 26);
		contentPane.add(enterNumber);
		
		cardNumber = new JTextField();
		cardNumber.setBounds(107, 36, 219, 20);
		contentPane.add(cardNumber);
		cardNumber.setColumns(10);
		
		JLabel enterCode = new JLabel("Enter security code (3 digits):");
		enterCode.setHorizontalAlignment(SwingConstants.CENTER);
		enterCode.setFont(new Font("Tahoma", Font.PLAIN, 14));
		enterCode.setBounds(10, 67, 414, 26);
		contentPane.add(enterCode);
		
		securityCode = new JTextField();
		securityCode.setColumns(10);
		securityCode.setBounds(107, 93, 219, 20);
		contentPane.add(securityCode);
		
		invalidData = new JLabel("Please provide valid data");
		invalidData.setHorizontalAlignment(SwingConstants.CENTER);
		invalidData.setBounds(107, 135, 219, 14);
		invalidData.setVisible(false);
		invalidData.setForeground(Color.red);
		contentPane.add(invalidData);
		
		//Calculate the total sum of the items in the customer's basket.
		double totalSum = 0;
		for (Product prod: customer.getShoppingBasket()) {
			double price = prod.getRetailPrice() * prod.getQuantityInStock();
			totalSum += price;
		}
		double sum = Double.parseDouble(String.format("%.2f", totalSum));
		
		confirm = new JLabel(String.valueOf(sum)+" paid using Credit Card");
		confirm.setHorizontalAlignment(SwingConstants.CENTER);
		confirm.setBounds(107, 135, 219, 14);
		confirm.setForeground(new Color(18, 132, 37));
		confirm.setVisible(false);
		contentPane.add(confirm);
		
		List<Product> stock = Stock.createStockList();
		
		JButton btnNewButton = new JButton("Confirm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/* Make sure the card number is 16 digits long 
				 * and the security code is 3 digits long by calling
				 * CreditCard methods. If so, proceed to pay for all items,
				 * show an appropriate message with the amount paid, 
				 * and update the stock.
				 */
				try {
					long num = Long.parseLong(cardNumber.getText());
					int code = Integer.parseInt(securityCode.getText());
					try {
						CreditCard card = new CreditCard(num, code);
						if (!CreditCard.verifyCode(card)) {
							invalidData.setVisible(true);
							confirm.setVisible(false);
						} else if (!CreditCard.verifyNumber(card)) {
							invalidData.setVisible(true);
							confirm.setVisible(false);
						} else {
							invalidData.setVisible(false);
							confirm.setVisible(true);
							customer.payItems(card);
							Stock.updateStockList(stock, customer);
						}
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				} catch (NumberFormatException e1) {
					invalidData.setVisible(true);
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(148, 150, 138, 41);
		contentPane.add(btnNewButton);	
	}
}
