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

public class CustomerPayPal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField email;

	public CustomerPayPal(Customer customer) throws Exception {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 174);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel enterEmail = new JLabel("Enter your email address:");
		enterEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		enterEmail.setHorizontalAlignment(SwingConstants.CENTER);
		enterEmail.setBounds(10, 11, 414, 25);
		contentPane.add(enterEmail);
		
		email = new JTextField();
		email.setBounds(112, 34, 208, 20);
		contentPane.add(email);
		email.setColumns(10);
			
		JLabel invalidEmail = new JLabel("Please provide a valid email");
		invalidEmail.setHorizontalAlignment(SwingConstants.CENTER);
		invalidEmail.setBounds(112, 76, 208, 14);
		invalidEmail.setForeground(Color.red);
		invalidEmail.setVisible(false);
		contentPane.add(invalidEmail);
		
		double totalSum = 0;
		for (Product prod: customer.getShoppingBasket()) {
			double price = prod.getRetailPrice() * prod.getQuantityInStock();
			totalSum += price;
		}
		double sum = Double.parseDouble(String.format("%.2f", totalSum));
		
		JLabel success = new JLabel(sum+" paid using PayPal");
		success.setHorizontalAlignment(SwingConstants.CENTER);
		success.setBounds(93, 76, 246, 14);
		success.setForeground(new Color(18, 132, 37));
		success.setVisible(false);
		contentPane.add(success);
		
		List<Product> stock = Stock.createStockList();
		
		JButton confirm = new JButton("Confirm");
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/* Make sure the email is valid (must contain "@") 
				 * by calling PayPal method. If so, proceed to pay 
				 * for all items, show an appropriate message with 
				 * the amount paid, and update the stock.
				 */
				String emailAddress = email.getText();
				PayPal payPal = new PayPal(emailAddress);
				try {
					if (!PayPal.verifyEmail(payPal)) {
						invalidEmail.setVisible(true);
						success.setVisible(false);
					} else {
						invalidEmail.setVisible(false);
						success.setVisible(true);
						customer.payItems(payPal);
						Stock.updateStockList(stock, customer);
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		confirm.setFont(new Font("Tahoma", Font.PLAIN, 18));
		confirm.setBounds(155, 91, 126, 33);
		contentPane.add(confirm);
	}

}
