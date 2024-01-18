package Design;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.Box;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Fees {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fees window = new Fees();
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
	public Fees() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 608, 348);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(6, 6, 596, 308);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADARSH VIDYALAYA, 11/223 SOUTER GANJ, KANPUR(208001)");
		lblNewLabel.setBounds(6, 6, 584, 16);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Futura", Font.PLAIN, 13));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Scholar no.:");
		lblNewLabel_1.setBounds(6, 34, 177, 21);
		lblNewLabel_1.setFont(new Font("Futura", Font.PLAIN, 15));
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Class:");
		lblNewLabel_2.setBounds(293, 34, 61, 21);
		lblNewLabel_2.setFont(new Font("Futura", Font.PLAIN, 15));
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Name:");
		lblNewLabel_3.setBounds(6, 67, 61, 21);
		lblNewLabel_3.setFont(new Font("Futura", Font.PLAIN, 15));
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Father's name:");
		lblNewLabel_4.setBounds(293, 68, 105, 18);
		lblNewLabel_4.setFont(new Font("Futura", Font.PLAIN, 15));
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("DOB:");
		lblNewLabel_5.setFont(new Font("Futura", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(6, 100, 237, 21);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Mobile No.:");
		lblNewLabel_6.setFont(new Font("Futura", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(293, 101, 105, 18);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Date:");
		lblNewLabel_7.setFont(new Font("Futura", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(6, 166, 61, 21);
		panel.add(lblNewLabel_7);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(151, 166, 130, 26);
		panel.add(dateChooser);
		
		JLabel lblNewLabel_8 = new JLabel("Admission Fee:");
		lblNewLabel_8.setFont(new Font("Futura", Font.PLAIN, 15));
		lblNewLabel_8.setBounds(293, 169, 126, 18);
		panel.add(lblNewLabel_8);
		
		textField = new JTextField();
		textField.setBounds(431, 164, 130, 28);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Tution Fee:");
		lblNewLabel_9.setFont(new Font("Futura", Font.PLAIN, 15));
		lblNewLabel_9.setBounds(6, 199, 83, 21);
		panel.add(lblNewLabel_9);
		
		textField_1 = new JTextField();
		textField_1.setBounds(151, 196, 130, 28);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Exam Fee:");
		lblNewLabel_10.setFont(new Font("Futura", Font.PLAIN, 15));
		lblNewLabel_10.setBounds(293, 202, 126, 18);
		panel.add(lblNewLabel_10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(431, 197, 130, 28);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("Annual Charges:");
		lblNewLabel_11.setFont(new Font("Futura", Font.PLAIN, 15));
		lblNewLabel_11.setBounds(6, 232, 115, 21);
		panel.add(lblNewLabel_11);
		
		textField_3 = new JTextField();
		textField_3.setBounds(151, 230, 130, 28);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_12 = new JLabel("Total Fee:");
		lblNewLabel_12.setFont(new Font("Futura", Font.PLAIN, 15));
		lblNewLabel_12.setBounds(293, 235, 83, 18);
		panel.add(lblNewLabel_12);
		
		textField_4 = new JTextField();
		textField_4.setBounds(431, 230, 130, 28);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setBounds(126, 273, 117, 29);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setBounds(314, 273, 117, 29);
		panel.add(btnNewButton_1);
		
		textField_5 = new JTextField();
		textField_5.setBounds(126, 32, 155, 28);
		panel.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(79, 64, 202, 28);
		panel.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(79, 98, 202, 28);
		panel.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(410, 65, 180, 28);
		panel.add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setBounds(410, 98, 180, 28);
		panel.add(textField_9);
		textField_9.setColumns(10);
		
		textField_10 = new JTextField();
		textField_10.setBounds(410, 32, 180, 28);
		panel.add(textField_10);
		textField_10.setColumns(10);
		
		JButton search = new JButton("Search");
		search.setBounds(223, 133, 117, 29);
		panel.add(search);
	}
}
