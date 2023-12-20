package Design;
import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.JComboBox;

public class admis {

	private JFrame frame;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admis window = new admis();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public admis() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 329);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(6, 6, 438, 289);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Name:");
		lblNewLabel_1.setFont(new Font("Futura", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(6, 52, 61, 22);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Scholar No.:");
		lblNewLabel_2.setFont(new Font("Futura", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(169, 18, 102, 22);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Father's Name:");
		lblNewLabel_3.setFont(new Font("Futura", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(6, 86, 118, 22);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Mother's Name:");
		lblNewLabel_4.setFont(new Font("Futura", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(6, 120, 128, 22);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Address:");
		lblNewLabel_5.setFont(new Font("Futura", Font.PLAIN, 16));
		lblNewLabel_5.setBounds(6, 154, 75, 22);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("D.O.B:");
		lblNewLabel_6.setFont(new Font("Futura", Font.PLAIN, 16));
		lblNewLabel_6.setBounds(256, 54, 61, 18);
		panel.add(lblNewLabel_6);
		
		textField_1 = new JTextField();
		textField_1.setBounds(79, 51, 165, 23);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(283, 18, 130, 22);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(321, 48, 111, 26);
		panel.add(dateChooser);
		
		textField_3 = new JTextField();
		textField_3.setBounds(146, 86, 165, 23);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(146, 119, 165, 23);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(146, 154, 267, 25);
		panel.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Mobile Number:");
		lblNewLabel_7.setFont(new Font("Futura", Font.PLAIN, 16));
		lblNewLabel_7.setBounds(6, 188, 128, 22);
		panel.add(lblNewLabel_7);
		
		textField_6 = new JTextField();
		textField_6.setBounds(146, 187, 171, 26);
		panel.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Class:");
		lblNewLabel_8.setFont(new Font("Futura", Font.PLAIN, 16));
		lblNewLabel_8.setBounds(6, 18, 61, 22);
		panel.add(lblNewLabel_8);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setFont(new Font("Futura", Font.PLAIN, 16));
		btnNewButton.setBounds(79, 225, 117, 29);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setFont(new Font("Futura", Font.PLAIN, 16));
		btnNewButton_1.setBounds(256, 225, 117, 29);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("ADARSH VIDYALAYA, 11/223 SOUTER GANJ, KANPUR(208001)");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Futura", Font.PLAIN, 13));
		lblNewLabel.setBounds(6, 267, 426, 16);
		panel.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setToolTipText("class");
		comboBox.setBounds(79, 18, 78, 27);
		panel.add(comboBox);
	}
}
