import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.SwingConstants;

import com.mysql.cj.xdevapi.Statement;

import javax.swing.JTextField;
import javax.swing.JButton;

public class Adding_Class {
	
	private static final String url = "jdbc:mysql://localhost:3306/" + Database_Manager.getInstance().getSelectedDatabase();
	private static final String username = "root";
    private static final String password = "Football@1316";
	   
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setBounds(100, 100, 450, 149);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(6, 6, 438, 109);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADARSH VIDYALAYA, 11/223 SOUTER GANJ, KANPUR(208001)");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Futura", Font.PLAIN, 13));
		lblNewLabel.setBounds(6, 6, 426, 16);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Add a Class:");
		lblNewLabel_1.setFont(new Font("Futura", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(82, 34, 111, 16);
		panel.add(lblNewLabel_1);
		
		JTextField textField = new JTextField();
		textField.setBounds(205, 30, 127, 26);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setFont(new Font("Futura", Font.PLAIN, 13));
		btnNewButton.setBounds(92, 62, 117, 29);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

		        if (textField.getText().length() == 0) {
		            JOptionPane.showMessageDialog(frame, "Cannot be emplty", "Error", JOptionPane.ERROR_MESSAGE);
		            return;
		        }

		        try (Connection connection = DriverManager.getConnection(url, username, password)) {
		            java.sql.Statement statement = connection.createStatement();
		

		            String sql = "INSERT INTO classes (class) VALUES " + "('" + textField.getText() + "')";

		            statement.executeUpdate(sql);
		            
		            JOptionPane.showMessageDialog(frame, "Table created successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
		        } catch (SQLException | NumberFormatException ex) {
		            JOptionPane.showMessageDialog(frame, "Error creating table: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		            ex.printStackTrace();
		        }
		    }

		});
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setBounds(215, 62, 117, 29);
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Home_Page home = new Home_Page();
				home.main(null);
			}
		});
		panel.add(btnNewButton_1);
		
		frame.setVisible(true);
	}
}
