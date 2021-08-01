import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class CustomerFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	public CustomerFrame(Customer customer) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 337, 422);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton viewProducts = new JButton("View all products");
		viewProducts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					customer.viewProducts();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		viewProducts.setFont(new Font("Tahoma", Font.PLAIN, 14));
		viewProducts.setBounds(42, 48, 237, 37);
		contentPane.add(viewProducts);
		
		JLabel emptyBasket = new JLabel("Your basket is empty");
		emptyBasket.setFont(new Font("Tahoma", Font.PLAIN, 14));
		emptyBasket.setHorizontalAlignment(SwingConstants.CENTER);
		emptyBasket.setBounds(42, 11, 237, 26);
		emptyBasket.setForeground(Color.red);
		emptyBasket.setVisible(false);
		contentPane.add(emptyBasket);
		
		JLabel cancelled = new JLabel("Items cancelled");
		cancelled.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cancelled.setHorizontalAlignment(SwingConstants.CENTER);
		cancelled.setBounds(10, 11, 311, 22);
		cancelled.setForeground(new Color(18, 132, 37));
		cancelled.setVisible(false);
		contentPane.add(cancelled);
		
		JLabel saved = new JLabel("Items saved for later");
		saved.setFont(new Font("Tahoma", Font.PLAIN, 14));
		saved.setHorizontalAlignment(SwingConstants.CENTER);
		saved.setBounds(10, 11, 311, 22);
		saved.setForeground(new Color(18, 132, 37));
		saved.setVisible(false);
		contentPane.add(saved);
		
		JButton viewBasket = new JButton("View basket");
		viewBasket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/* Create a CustomerViewBasket frame. This frame displays
				 * information about each item in the customer's basket.
				 * If the basket is empty, it displays "Your basket is empty".
				 */
				CustomerViewBasket cViewBasket = new CustomerViewBasket(customer);
				cViewBasket.setTitle(customer.getSurname()+"'s basket");
				cViewBasket.setLocationRelativeTo(null);
				cViewBasket.setVisible(true);
			}
		});
		viewBasket.setFont(new Font("Tahoma", Font.PLAIN, 14));
		viewBasket.setBounds(42, 96, 237, 37);
		contentPane.add(viewBasket);
		
		JButton addItem = new JButton("Add an item to basket");
		addItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/* Create a CustomerAddItem frame, where the user can choose
				 * the item they want and the quantity they want of it.
				 */
				try {
					CustomerAddItem addProd = new CustomerAddItem(customer);
					addProd.setLocationRelativeTo(null);
					addProd.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		addItem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		addItem.setBounds(42, 144, 237, 37);
		contentPane.add(addItem);
		
		JButton payItems = new JButton("Pay for all items in basket");
		payItems.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (customer.getShoppingBasket().isEmpty()) {
					/* If the customer's basket is empty, show an appropriate message
					 * and don't allow the customer to proceed to payment.
					 */
					emptyBasket.setVisible(true);
					cancelled.setVisible(false);
					saved.setVisible(false);
				} else {
					/* Otherwise, create and open the frame which lets the customer
					 * to choose their payment method.
					 */
					saved.setVisible(false);
					cancelled.setVisible(false);
					emptyBasket.setVisible(false);
					ChoosePaymentMethod paymentMethod = new ChoosePaymentMethod(customer);
					paymentMethod.setTitle("Choose payment method");
					paymentMethod.setLocationRelativeTo(null);
					paymentMethod.setVisible(true);
				}				
			}
		});
		payItems.setFont(new Font("Tahoma", Font.PLAIN, 14));
		payItems.setBounds(42, 192, 237, 37);
		contentPane.add(payItems);
		
		JButton cancel = new JButton("Cancel items");
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (customer.getShoppingBasket().isEmpty()) {
					/* If the customer's basket is empty, show an appropriate message
					 * and don't allow the customer to proceed to cancellation.
					 */
					emptyBasket.setVisible(true);
					saved.setVisible(false);
					cancelled.setVisible(false);
				} else {
					/* Otherwise, create and open the frame which asks for confirmation
					 * of the action.
					 */
					emptyBasket.setVisible(false);
					saved.setVisible(false);
					ConfirmAction confirmCancel = new ConfirmAction(customer, saved, cancelled);
					confirmCancel.setTitle("Confirm cancellation");
					confirmCancel.setLocationRelativeTo(null);
					confirmCancel.setVisible(true);
				}
			}
		});
		cancel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cancel.setBounds(42, 240, 237, 37);
		contentPane.add(cancel);
		
		JButton saveForLater = new JButton("Save items for later");
		saveForLater.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (customer.getShoppingBasket().isEmpty()) {
					/* If the customer's basket is empty, show an appropriate message
					 * and don't allow the customer to proceed to the action.
					 */
					emptyBasket.setVisible(true);
					cancelled.setVisible(false);
					saved.setVisible(false);
				} else {
					/* Otherwise, create and open the frame which asks for confirmation
					 * of the action.
					 */
					emptyBasket.setVisible(false);
					cancelled.setVisible(false);
					ConfirmAction confirmSave = new ConfirmAction(customer, saved, cancelled);
					confirmSave.setTitle("Confirm save for later");
					confirmSave.setLocationRelativeTo(null);
					confirmSave.setVisible(true);
				}
			}
		});
		saveForLater.setFont(new Font("Tahoma", Font.PLAIN, 14));
		saveForLater.setBounds(42, 288, 237, 37);
		contentPane.add(saveForLater);		
	}
}
