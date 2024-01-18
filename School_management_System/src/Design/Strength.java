package Design;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class Strength {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Strength window = new Strength();
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
	public Strength() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 151);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(6, 6, 438, 111);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADARSH VIDYALAYA, 11/223 SOUTER GANJ, KANPUR(208001)");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Futura", Font.PLAIN, 14));
		lblNewLabel.setBounds(6, 6, 426, 16);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Select Class:");
		lblNewLabel_1.setFont(new Font("Futura", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(86, 34, 110, 22);
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setFont(new Font("Futura", Font.PLAIN, 13));
		btnNewButton.setBounds(79, 71, 117, 29);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setFont(new Font("Futura", Font.PLAIN, 13));
		btnNewButton_1.setBounds(208, 71, 117, 29);
		panel.add(btnNewButton_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(191, 34, 136, 27);
		panel.add(comboBox);
	}
}
