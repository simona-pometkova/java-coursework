import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminAddMouse extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField barcode;
	private JLabel lblBrand;
	private JTextField brand;
	private JLabel lblColour;
	private JTextField colour;
	private JLabel lblConnectivity;
	private JLabel lblQuantity;
	private JTextField quantity;
	private JLabel lblOriginalCost;
	private JTextField origCost;
	private JLabel lblNewLabel_1;
	private JLabel lblRetailPrice;
	private JTextField retPrice;
	private JLabel lblNewLabel_2;
	private JLabel lblNumberOfButtons;
	private JTextField numButtons;
	private JLabel lblType;
	private JComboBox<String> type;
	private JLabel invalidDataWarning;
	private JLabel invalidBarcode;
	private JLabel digitsWarning;
	private JLabel success;

	public AdminAddMouse(Admin admin) throws Exception {
//		List<Admin> admins = Admin.AdminList.createAdminList();
//		Admin admin = admins.get(0);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 567);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Barcode (6 digits numer):");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 414, 28);
		contentPane.add(lblNewLabel);
		
		barcode = new JTextField();
		barcode.setBounds(144, 39, 142, 20);
		contentPane.add(barcode);
		barcode.setColumns(10);
		
		lblBrand = new JLabel("Brand:");
		lblBrand.setHorizontalAlignment(SwingConstants.CENTER);
		lblBrand.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBrand.setBounds(37, 70, 208, 28);
		contentPane.add(lblBrand);
		
		brand = new JTextField();
		brand.setColumns(10);
		brand.setBounds(76, 97, 142, 20);
		contentPane.add(brand);
		
		lblColour = new JLabel("Colour:");
		lblColour.setHorizontalAlignment(SwingConstants.CENTER);
		lblColour.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblColour.setBounds(185, 70, 208, 28);
		contentPane.add(lblColour);
		
		colour = new JTextField();
		colour.setColumns(10);
		colour.setBounds(228, 97, 142, 20);
		contentPane.add(colour);
		
		lblConnectivity = new JLabel("Connectivity:");
		lblConnectivity.setHorizontalAlignment(SwingConstants.CENTER);
		lblConnectivity.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblConnectivity.setBounds(10, 128, 414, 28);
		contentPane.add(lblConnectivity);
		
		JComboBox<String> connectivity = new JComboBox<String>();
		connectivity.setBounds(144, 153, 142, 20);
		contentPane.add(connectivity);
		connectivity.addItem("WIRED");
		connectivity.addItem("WIRELESS");
		
		lblQuantity = new JLabel("Quantity:");
		lblQuantity.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblQuantity.setBounds(10, 184, 414, 28);
		contentPane.add(lblQuantity);
		
		quantity = new JTextField();
		quantity.setColumns(10);
		quantity.setBounds(170, 211, 93, 20);
		contentPane.add(quantity);
		
		lblOriginalCost = new JLabel("Original cost:");
		lblOriginalCost.setHorizontalAlignment(SwingConstants.CENTER);
		lblOriginalCost.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblOriginalCost.setBounds(37, 242, 208, 28);
		contentPane.add(lblOriginalCost);
		
		origCost = new JTextField();
		origCost.setColumns(10);
		origCost.setBounds(95, 269, 93, 20);
		contentPane.add(origCost);
		
		lblNewLabel_1 = new JLabel("\u00A3");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(47, 271, 46, 17);
		contentPane.add(lblNewLabel_1);
		
		lblRetailPrice = new JLabel("Retail price:");
		lblRetailPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblRetailPrice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRetailPrice.setBounds(185, 242, 208, 28);
		contentPane.add(lblRetailPrice);
		
		retPrice = new JTextField();
		retPrice.setColumns(10);
		retPrice.setBounds(246, 269, 93, 20);
		contentPane.add(retPrice);
		
		lblNewLabel_2 = new JLabel("\u00A3");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(199, 271, 46, 17);
		contentPane.add(lblNewLabel_2);
		
		lblNumberOfButtons = new JLabel("Number of buttons:");
		lblNumberOfButtons.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumberOfButtons.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNumberOfButtons.setBounds(10, 300, 414, 28);
		contentPane.add(lblNumberOfButtons);
		
		numButtons = new JTextField();
		numButtons.setColumns(10);
		numButtons.setBounds(185, 326, 62, 20);
		contentPane.add(numButtons);
		
		lblType = new JLabel("Type:");
		lblType.setHorizontalAlignment(SwingConstants.CENTER);
		lblType.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblType.setBounds(10, 357, 414, 28);
		contentPane.add(lblType);
		
		type = new JComboBox<String>();
		type.setBounds(144, 382, 142, 20);
		contentPane.add(type);
		type.addItem("STANDARD");
		type.addItem("GAMING");
		
		invalidDataWarning = new JLabel("Please provide valid data");
		invalidDataWarning.setBackground(Color.WHITE);
		invalidDataWarning.setForeground(Color.red);
		invalidDataWarning.setVisible(false);
		invalidDataWarning.setHorizontalAlignment(SwingConstants.CENTER);
		invalidDataWarning.setBounds(10, 427, 414, 14);
		contentPane.add(invalidDataWarning);
		
		invalidBarcode = new JLabel("An item with this barcode already exists");
		invalidBarcode.setHorizontalAlignment(SwingConstants.CENTER);
		invalidBarcode.setForeground(Color.red);
		invalidBarcode.setVisible(false);
		invalidBarcode.setBounds(10, 427, 414, 14);
		contentPane.add(invalidBarcode);
		
		digitsWarning = new JLabel("Please enter 6 digits");
		digitsWarning.setBounds(296, 42, 128, 14);
		digitsWarning.setForeground(Color.red);
		digitsWarning.setVisible(false);
		contentPane.add(digitsWarning);
		
		success = new JLabel("Product added");
		success.setBounds(296, 468, 128, 14);
		success.setForeground(new Color(18, 132, 37));
		success.setVisible(false);
		contentPane.add(success);
		
		JButton add = new JButton("Add to stock");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/* On button pressed, first try to parse the barcode, quantity,
				 * original cost, retail price and number of buttons values as integers. Proceed
				 * with other data validity checks. Only proceed to add a mouse 
				 * to stock if the barcode is six digits long, is unique (there's no existing
				 * item with this barcode) and all other values are appropriate (e.g. original cost
				 * is numeric, not a string).
				 */
				int mBarcode, mQuantity, mButtons;
				double mOrigCost, mRetPrice;				
				String mBrand = brand.getText();
				String mColour = colour.getText();
				Connectivity mConnectivity = Enum.valueOf(Connectivity.class, (String)connectivity.getSelectedItem());
				MouseType mType = Enum.valueOf(MouseType.class, (String)type.getSelectedItem());				
				try {
					mBarcode = Integer.parseInt(barcode.getText());
					mQuantity = Integer.parseInt(quantity.getText());
					mOrigCost = Double.parseDouble(origCost.getText());
					mRetPrice = Double.parseDouble(retPrice.getText());
					mButtons = Integer.parseInt(numButtons.getText());
					try {
						invalidDataWarning.setVisible(false);
						if (!(Product.isSixDigits(mBarcode))) {
							digitsWarning.setVisible(true);
							invalidDataWarning.setVisible(false);
							invalidBarcode.setVisible(false);
							success.setVisible(false);
						} else if (!(Product.isUnique(mBarcode))) {
							digitsWarning.setVisible(false);
							invalidDataWarning.setVisible(false);
							success.setVisible(false);
							invalidBarcode.setVisible(true);
						} else {
							digitsWarning.setVisible(false);
							invalidBarcode.setVisible(false);
							invalidDataWarning.setVisible(false);
							success.setVisible(true);
							admin.addMouse(mBarcode, mBrand, mColour, mConnectivity, mQuantity, mOrigCost, mRetPrice, mButtons, mType);
						}						
					} catch (Exception e1) {
						success.setVisible(false);
						digitsWarning.setVisible(false);
						invalidBarcode.setVisible(false);
						invalidDataWarning.setVisible(true);
					}
				} catch (NumberFormatException ex) {
					success.setVisible(false);
					digitsWarning.setVisible(false);
					invalidBarcode.setVisible(false);
					invalidDataWarning.setVisible(true);
				}				
			}
		});
		add.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add.setBounds(144, 448, 142, 48);
		contentPane.add(add);

	}
}
