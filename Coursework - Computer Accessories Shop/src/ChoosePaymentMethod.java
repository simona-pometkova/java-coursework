import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/* A frame which allows the user to choose a payment method
 * for their items. Has two buttons - "Credit Card" and "PayPal"
 * and on a button pressed opens the corresponding frame.
 */
public class ChoosePaymentMethod extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public ChoosePaymentMethod(Customer customer) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 461, 143);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton creditCard = new JButton("Credit Card");
		creditCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerCreditCard enterDetails;
				try {
					enterDetails = new CustomerCreditCard(customer);
					enterDetails.setTitle("Enter details");
					enterDetails.setLocationRelativeTo(null);
					enterDetails.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		creditCard.setFont(new Font("Tahoma", Font.PLAIN, 18));
		creditCard.setBounds(44, 31, 159, 43);
		contentPane.add(creditCard);
		
		JButton payPal = new JButton("PayPal");
		payPal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					CustomerPayPal payPalDetails = new CustomerPayPal(customer);
					payPalDetails.setTitle("Enter details");
					payPalDetails.setLocationRelativeTo(null);
					payPalDetails.setVisible(true);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		payPal.setFont(new Font("Tahoma", Font.PLAIN, 18));
		payPal.setBounds(248, 31, 159, 43);
		contentPane.add(payPal);
	}
}
