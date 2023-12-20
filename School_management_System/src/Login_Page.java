import java.awt.BorderLayout;


import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLException;
import javax.swing.*;

public class Login_Page{
	 private static String passkey = "PASS";
	   private static final String url = "jdbc:mysql://localhost:3306";
	   private static final String username = "root";
	   private static final String password = "Football@1316";
	    private static JComboBox<String> comboBox;

	    private static void populateComboBox() {
	        // Initialize the JComboBox
	        comboBox = new JComboBox<>();

	        // Use SwingUtilities.invokeLater to update the GUI on the EDT

	                try {
	                    Class.forName("com.mysql.cj.jdbc.Driver");

	             
	                    // Establish the connection
	                    try (Connection connection = DriverManager.getConnection(url, username, password)) {
	                        // Get a list of databases
	                        java.sql.Statement statement = connection.createStatement();

	                        // Execute a query to get the list of databases
	                        ResultSet resultSet = statement.executeQuery("SHOW DATABASES");

	                        // Populate the combo box with database names
	                        while (resultSet.next()) {
	                            // Use the correct index (1) to retrieve the database name
	                            String dbName = resultSet.getString(1);
	                            System.out.println("Database Name: " + dbName); // Debug information
	                            comboBox.addItem(dbName);
	                        }


	                    }
	                } catch (ClassNotFoundException | SQLException e) {
	                    e.printStackTrace();
	                    // Handle exceptions as needed
	                }
	            }
	        
	    

	 
	   
	public static void main(String[] args) throws ClassNotFoundException {
		JFrame frame = new JFrame();
		frame.setBounds(100, 100, 450, 179);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(6, 6, 438, 139);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADARSH VIDYALAYA, 11/223 SOUTER GANJ, KANPUR(208001)");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Futura", Font.PLAIN, 13));
		lblNewLabel.setBounds(6, 6, 426, 16);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setFont(new Font("Futura", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(107, 34, 84, 22);
		panel.add(lblNewLabel_1);
		
		JPasswordField passwordField = new JPasswordField();
		passwordField.setBounds(203, 34, 145, 26);
		panel.add(passwordField);
		
		JLabel lblNewLabel_2 = new JLabel("Year:");
		lblNewLabel_2.setFont(new Font("Futura", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(107, 69, 84, 22);
		panel.add(lblNewLabel_2);

		comboBox = new JComboBox<>();
		populateComboBox();
		comboBox.setBounds(199, 69, 155, 27);
		panel.add(comboBox);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.setFont(new Font("Futura", Font.PLAIN, 13));
		btnNewButton.setBounds(155, 103, 117, 29);
	    btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
        		
        		if(passwordField.getText().equals(passkey)) {
        			frame.dispose();
        			Home_Page home = new Home_Page();
        			Database_Manager.getInstance().connect((String) comboBox.getSelectedItem());
        			home.main(null);
        		}
        		else
        			JOptionPane.showMessageDialog(null, "Incorrect Password");
        			System.out.println("Incorrect");
            }
    });
		panel.add(btnNewButton);
		frame.setVisible(true);
	}
}
