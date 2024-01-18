package Design;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;

public class edit {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					edit window = new edit();
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
	public edit() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 536, 359);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(6, 6, 524, 319);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADARSH VIDYALAYA, 11/223 SOUTER GANJ, KANPUR(208001)");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Futura", Font.PLAIN, 15));
		lblNewLabel.setBounds(6, 6, 512, 21);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Scholar Number:");
		lblNewLabel_1.setFont(new Font("Futura", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(6, 39, 112, 21);
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(130, 33, 112, 32);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Date:");
		lblNewLabel_2.setFont(new Font("Futura", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(254, 39, 105, 21);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Invoice Number:");
		lblNewLabel_3.setFont(new Font("Futura", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(6, 72, 112, 21);
		panel.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(130, 66, 112, 32);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Admission Fee:");
		lblNewLabel_4.setFont(new Font("Futura", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(254, 72, 105, 21);
		panel.add(lblNewLabel_4);
		
		textField_3 = new JTextField();
		textField_3.setBounds(371, 66, 130, 32);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Tution Fee:");
		lblNewLabel_5.setFont(new Font("Futura", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(6, 105, 112, 21);
		panel.add(lblNewLabel_5);
		
		textField_4 = new JTextField();
		textField_4.setBounds(130, 99, 112, 32);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Exam Fee:");
		lblNewLabel_6.setFont(new Font("Futura", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(254, 107, 105, 19);
		panel.add(lblNewLabel_6);
		
		textField_5 = new JTextField();
		textField_5.setBounds(371, 99, 130, 32);
		panel.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Annual Charges:");
		lblNewLabel_7.setFont(new Font("Futura", Font.PLAIN, 14));
		lblNewLabel_7.setBounds(6, 138, 112, 21);
		panel.add(lblNewLabel_7);
		
		textField_6 = new JTextField();
		textField_6.setBounds(130, 132, 112, 32);
		panel.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Total Fee:");
		lblNewLabel_8.setFont(new Font("Futura", Font.PLAIN, 14));
		lblNewLabel_8.setBounds(254, 138, 105, 21);
		panel.add(lblNewLabel_8);
		
		textField_7 = new JTextField();
		textField_7.setBounds(371, 132, 130, 32);
		panel.add(textField_7);
		textField_7.setColumns(10);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(371, 33, 130, 32);
		panel.add(dateChooser);
		
		JLabel lblNewLabel_9 = new JLabel("__________________________________________________________________________");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setBounds(0, 191, 518, 16);
		panel.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Enter new Scholar Number");
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10.setFont(new Font("Futura", Font.PLAIN, 14));
		lblNewLabel_10.setBounds(6, 219, 512, 16);
		panel.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Scholar Number:");
		lblNewLabel_11.setFont(new Font("Futura", Font.PLAIN, 14));
		lblNewLabel_11.setBounds(130, 250, 112, 16);
		panel.add(lblNewLabel_11);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setBounds(193, 171, 117, 29);
		panel.add(btnNewButton);
		
		textField_1 = new JTextField();
		textField_1.setBounds(254, 242, 117, 32);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Change");
		btnNewButton_1.setBounds(104, 278, 117, 29);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.setBounds(275, 278, 117, 29);
		panel.add(btnNewButton_2);
	}
}
