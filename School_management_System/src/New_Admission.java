import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.mysql.cj.jdbc.DatabaseMetaData;
import com.toedter.calendar.JDateChooser;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;



public class New_Admission {

   private static final String url = "jdbc:mysql://localhost:3306/" + Database_Manager.getInstance().getSelectedDatabase();
   private static final String username = "root";
   private static final String password = "Football@1316";

    
   private static JComboBox<String> comboBox;
    
   private static void populateComboBox() {
	    try (Connection connection = DriverManager.getConnection(url, username, password)) {
	        String query = "SELECT class FROM classes";
	        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
	             ResultSet resultSet = preparedStatement.executeQuery()) {

	            List<String> classNames = new ArrayList<>();
	            while (resultSet.next()) {
	                String className = resultSet.getString("class");
	                classNames.add(className);
	            }

	            DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>(classNames.toArray(new String[0]));
	            comboBox.setModel(comboBoxModel);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public static void main(String[] args) throws Exception {
		JFrame frame = new JFrame("New Admission");
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
		
		JTextField name = new JTextField();
		name.setBounds(79, 51, 165, 23);
		panel.add(name);
		name.setColumns(100);
		
		JTextField scholar = new JTextField();
		scholar.setBounds(283, 18, 130, 22);
		panel.add(scholar);
		scholar.setColumns(100);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(321, 48, 111, 26);

		panel.add(dateChooser);
		
		JTextField father = new JTextField();
		father.setBounds(146, 86, 165, 23);
		panel.add(father);
		father.setColumns(100);
		
		JTextField mother = new JTextField();
		mother.setBounds(146, 119, 165, 23);
		panel.add(mother);
		mother.setColumns(100);
		
		JTextField address = new JTextField();
		address.setBounds(146, 154, 267, 25);
		panel.add(address);
		address.setColumns(100);
		
		JLabel lblNewLabel_7 = new JLabel("Mobile Number:");
		lblNewLabel_7.setFont(new Font("Futura", Font.PLAIN, 16));
		lblNewLabel_7.setBounds(6, 188, 128, 22);
		panel.add(lblNewLabel_7);
		
		JTextField mobile = new JTextField();
		mobile.setBounds(146, 187, 171, 26);
		panel.add(mobile);
		mobile.setColumns(999999999);
		
		JLabel lblNewLabel_8 = new JLabel("Class:");
		lblNewLabel_8.setFont(new Font("Futura", Font.PLAIN, 16));
		lblNewLabel_8.setBounds(6, 18, 61, 22);
		panel.add(lblNewLabel_8);
		  
		comboBox = new JComboBox<>();
		populateComboBox();
		comboBox.setToolTipText("class");
		comboBox.setBounds(79, 18, 78, 27);
		panel.add(comboBox);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setFont(new Font("Futura", Font.PLAIN, 16));
		btnNewButton.setBounds(79, 225, 117, 29);
		btnNewButton.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			java.util.Date selectedDate = dateChooser.getDate();
			Date sqlDate = new Date(selectedDate.getTime());
			Connection connection = null;
			try {
				connection = DriverManager.getConnection(url, username, password);
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(frame, "Error", "", JOptionPane.INFORMATION_MESSAGE);
				e1.printStackTrace();
			}
		    if (connection == null) {
		        // Handle the connection error
		        return;
		    }

		    try {
		            if (name.getText().length() > 0 && scholar.getText().length() > 0 && father.getText().length() > 0 && mother.getText().length() > 0 && address.getText().length() > 0 && mobile.getText().length() > 0) {
		                
		                    String insertSQL = "INSERT INTO students(class, student_name, scholar_num, DOB, father_name, mother_name, address, mobile_num) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		                    PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);
		                    preparedStatement.setInt(1, Integer.parseInt((String) comboBox.getSelectedItem()));
		                    preparedStatement.setString(2, name.getText());
		                    preparedStatement.setInt(3, Integer.parseInt(scholar.getText()));
		                    preparedStatement.setDate(4, sqlDate);
		                    preparedStatement.setString(5, father.getText());
		                    preparedStatement.setString(6, mother.getText());
		                    preparedStatement.setString(7, address.getText());
		                    preparedStatement.setString(8, mobile.getText());
		                    preparedStatement.executeUpdate();
		                    JOptionPane.showMessageDialog(frame, "Submitted", "", JOptionPane.INFORMATION_MESSAGE);
		            }
		}  
		        
		     catch (SQLException ex) {
		    	 JOptionPane.showMessageDialog(frame, "Error", "", JOptionPane.INFORMATION_MESSAGE);
		        ex.printStackTrace();
		    } 
		}
		});
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setFont(new Font("Futura", Font.PLAIN, 16));
		btnNewButton_1.setBounds(256, 225, 117, 29);
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Home_Page.main(null);
			}
		});
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("ADARSH VIDYALAYA, 11/223 SOUTER GANJ, KANPUR(208001)");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Futura", Font.PLAIN, 13));
		lblNewLabel.setBounds(6, 267, 426, 16);
		panel.add(lblNewLabel);
		
		frame.setVisible(true);
		
	}


}

