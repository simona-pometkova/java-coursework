import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.util.List;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class MainMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	Admin admin = null;
	Customer customer = null;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu();
					frame.setTitle("Main menu");
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public MainMenu() throws Exception {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 320);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Please login:");
		lblNewLabel_1.setBounds(5, 42, 559, 22);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Welcome to Computer Accessories Shop");
		lblNewLabel.setBounds(5, 5, 549, 26);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		
		List<Admin> adminList = Admin.AdminList.createAdminList();
		List<Customer> customerList = Customer.CustomerList.createCustomerList();
		
		JComboBox<Object> users = new JComboBox<Object>();
		users.setBounds(177, 75, 208, 36);
		contentPane.add(users);
		users.addItem("(Admin) "+adminList.get(0).toString());
		for (Customer c: customerList) {
			users.addItem("(Customer) "+c.toString());
		}
		
		JButton btnNewButton = new JButton("Confirm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String value = (String)users.getSelectedItem();
				if (value.contains("Admin")) {
					AdminFrame aFrame;
					try {
						admin = adminList.get(0);
						aFrame = new AdminFrame(admin);
						aFrame.setTitle("Admin "+value.substring(20));
						aFrame.setLocationRelativeTo(null);
						aFrame.setVisible(true);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}					
				} else if (value.contains("Customer")) {
					if (value.contains("user2")) {
						customer = customerList.get(0);
					} else if (value.contains("user3")) {
						customer = customerList.get(1);
					} else if (value.contains("user4")) {
						customer = customerList.get(2);
					}
					CustomerFrame cFrame = new CustomerFrame(customer);
					cFrame.setTitle("Customer"+value.substring(22));
					cFrame.setLocationRelativeTo(null);
					cFrame.setVisible(true);
				}
			}
		});
		btnNewButton.setBounds(223, 214, 115, 36);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(btnNewButton);
	}
}
