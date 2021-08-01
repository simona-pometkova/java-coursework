import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/* Asks the user to confirm they want to 
 * cancel their items/save their items for later,
 * showing appropriate message in the main user frame
 * (CustomerFrame.java) depending on what action 
 * is being confirmed.
 */
public class ConfirmAction extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public ConfirmAction(Customer customer, JLabel saved, JLabel cancelled) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 405, 156);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel confirm = new JLabel("Are you sure?");
		confirm.setFont(new Font("Tahoma", Font.PLAIN, 20));
		confirm.setHorizontalAlignment(SwingConstants.CENTER);
		confirm.setBounds(10, 11, 369, 36);
		contentPane.add(confirm);
		
		JButton yes = new JButton("Yes");
		yes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				try {
					if (getTitle().contains("save")) {
						saved.setVisible(true);
						cancelled.setVisible(false);
						customer.saveForLater();
					} else if (getTitle().contains("cancellation")) {
						saved.setVisible(false);
						cancelled.setVisible(true);
						customer.cancelItems();
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		yes.setFont(new Font("Tahoma", Font.PLAIN, 18));
		yes.setBounds(74, 58, 89, 38);
		contentPane.add(yes);
		
		JButton no = new JButton("No");
		no.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		no.setFont(new Font("Tahoma", Font.PLAIN, 18));
		no.setBounds(228, 58, 89, 38);
		contentPane.add(no);
	}

}
