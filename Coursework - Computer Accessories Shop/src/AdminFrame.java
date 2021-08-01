import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public AdminFrame(Admin admin) throws Exception {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 337, 300);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("View all products");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					admin.viewProducts(); //Call method from class
				} catch (Exception e1) {
					e1.printStackTrace();
				}				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(42, 48, 237, 37);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Add keyboard");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminAddKeyboard addKeyboard;
				try {
					addKeyboard = new AdminAddKeyboard(admin);
					addKeyboard.setTitle("Add keyboard");
					addKeyboard.setLocationRelativeTo(null);
					addKeyboard.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setBounds(42, 96, 237, 37);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Add mouse");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminAddMouse addMouse;
				try {
					addMouse = new AdminAddMouse(admin);
					addMouse.setTitle("Add mouse");
					addMouse.setLocationRelativeTo(null);
					addMouse.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}				
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_2.setBounds(42, 144, 237, 37);
		contentPane.add(btnNewButton_2);
	}
}
