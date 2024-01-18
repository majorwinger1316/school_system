package Design;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class searchy {

	private JFrame frame;
	private JTextField textField_1;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					searchy window = new searchy();
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
	public searchy() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 176);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(6, 6, 438, 136);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADARSH VIDYALAYA, 11/223 SOUTER GANJ, KANPUR(208001)");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Futura", Font.PLAIN, 13));
		lblNewLabel.setBounds(6, 6, 426, 16);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name:");
		lblNewLabel_1.setFont(new Font("Futura", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(6, 36, 54, 22);
		panel.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(110, 34, 130, 29);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setFont(new Font("Futura", Font.PLAIN, 13));
		btnNewButton.setBounds(26, 96, 117, 29);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setFont(new Font("Futura", Font.PLAIN, 13));
		btnNewButton_1.setBounds(290, 96, 117, 29);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.setFont(new Font("Futura", Font.PLAIN, 13));
		btnNewButton_2.setBounds(155, 96, 117, 29);
		panel.add(btnNewButton_2);
		
		JLabel lblNewLabel_2 = new JLabel("DOB:");
		lblNewLabel_2.setFont(new Font("Futura", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(256, 39, 47, 18);
		panel.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(315, 34, 117, 29);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Scholar No.:");
		lblNewLabel_3.setFont(new Font("Futura", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(6, 68, 89, 22);
		panel.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(110, 66, 130, 29);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Class:");
		lblNewLabel_4.setFont(new Font("Futura", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(256, 72, 54, 22);
		panel.add(lblNewLabel_4);
		
		textField_3 = new JTextField();
		textField_3.setBounds(315, 67, 117, 29);
		panel.add(textField_3);
		textField_3.setColumns(10);
	}

}
