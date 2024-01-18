import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JButton;

public class New_Database {
	private static final String url = "jdbc:mysql://localhost:3306/";
	private static final String username = "root";
    private static final String password = "Football@1316";
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setBounds(100, 100, 450, 143);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(6, 6, 438, 103);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADARSH VIDYALAYA, 11/223 SOUTER GANJ, KANPUR(208001)");
		lblNewLabel.setFont(new Font("Futura", Font.PLAIN, 13));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(6, 6, 426, 16);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Add a New Year to Database:");
		lblNewLabel_1.setFont(new Font("Futura", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(59, 34, 227, 16);
		panel.add(lblNewLabel_1);
		
		JTextField textField = new JTextField();
		textField.setBounds(298, 32, 84, 22);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Create");
		btnNewButton.setFont(new Font("Futura", Font.PLAIN, 13));
		btnNewButton.setBounds(69, 62, 117, 29);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (textField.getText().length() == 0) {
		            JOptionPane.showMessageDialog(frame, "Schema name cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
		            return;
		        }

				try (Connection connection = DriverManager.getConnection(url, username, password)) {
                    java.sql.Statement statement = connection.createStatement();

                    // Specify the database to use
                    statement.executeUpdate("CREATE DATABASE IF NOT EXISTS `" + textField.getText() + "`");
                    statement.executeUpdate("USE `" + textField.getText() + "`");

                    // Continue with table creation statements
                    statement.executeUpdate("CREATE TABLE IF NOT EXISTS classes (" + "class INT PRIMARY KEY NOT NULL)");

                    statement.executeUpdate("CREATE TABLE IF NOT EXISTS fees (" + "invoice_num INT PRIMARY KEY AUTO_INCREMENT NOT NULL,"
                            + "date DATE NOT NULL," + "scholar_num INT," + "admission_fee INT,"
                            + "tution_fee INT NOT NULL," + "exam_fee INT," + "annual_charges INT," + "total INT)");

                    statement.executeUpdate("CREATE TABLE IF NOT EXISTS students (" + "scholar_num INT PRIMARY KEY NOT NULL,"
                            + "class INT," + "student_name VARCHAR(100) NOT NULL," + "father_name VARCHAR(100),"
                            + "mother_name VARCHAR(100)," + "DOB VARCHAR(45)," + "address VARCHAR(100),"
                            + "mobile_num VARCHAR(10))");

                    JOptionPane.showMessageDialog(frame, "Schema created successfully.", "Success",
                            JOptionPane.INFORMATION_MESSAGE);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(frame, "Error creating schema: " + ex.getMessage(), "Error",
                            JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }
            }
        });
        panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setFont(new Font("Futura", Font.PLAIN, 13));
		btnNewButton_1.setBounds(249, 62, 117, 29);
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
