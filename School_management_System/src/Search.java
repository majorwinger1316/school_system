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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.SwingConstants;

import com.mysql.cj.jdbc.DatabaseMetaData;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class Search {
	
	   private static final String url = "jdbc:mysql://localhost:3306/" + Database_Manager.getInstance().getSelectedDatabase();
	   private static final String username = "root";
	   private static final String password = "Football@1316";

	    
	   private static JComboBox<String> comboBox;
	   private static void populateComboBox() {
		   comboBox = new JComboBox<>();
		    try (Connection connection = DriverManager.getConnection(url, username, password)) {
		        DatabaseMetaData metaData = (DatabaseMetaData) connection.getMetaData();
		        ResultSet resultSet = metaData.getTables(Database_Manager.getInstance().getSelectedDatabase() , null, "%", new String[]{"TABLE"});
		        while (resultSet.next()) {
		            comboBox.addItem(resultSet.getString("TABLE_NAME"));
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		}
		
	public static void main(String[] args) {
		JFrame frame = new JFrame();
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
		
		JLabel lblNewLabel_1 = new JLabel("S. No.:");
		lblNewLabel_1.setFont(new Font("Futura", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(16, 62, 61, 22);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Class:");
		lblNewLabel_2.setFont(new Font("Futura", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(16, 34, 61, 16);
		panel.add(lblNewLabel_2);
		
		JTextField textField_1 = new JTextField();
		textField_1.setBounds(89, 61, 146, 26);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		comboBox = new JComboBox<>();
		populateComboBox();
		comboBox.setBounds(85, 31, 160, 27);
		panel.add(comboBox);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setFont(new Font("Futura", Font.PLAIN, 13));
		btnNewButton.setBounds(26, 96, 117, 29);
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try (Connection connection = DriverManager.getConnection(url, username, password)) {
					String query = "SELECT * FROM " + comboBox.getSelectedItem() + " WHERE scholar_num = ?";
					try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
					    preparedStatement.setString(1, textField_1.getText());
					    ResultSet resultSet = preparedStatement.executeQuery();

		                if (resultSet.next()) {
		                    String rowData = "S No.: " + resultSet.getInt("s_no") + "\n" +
		                            "Name: " + resultSet.getString("name") + "\n" +
		                            "Scholar Number: " + resultSet.getString("scholar_num") + "\n" + "DOB: " + resultSet.getString("DOB");
		                    JOptionPane.showMessageDialog(frame, rowData, "Row Details", JOptionPane.INFORMATION_MESSAGE);
		                } else {
		                    JOptionPane.showMessageDialog(frame, "Row not found", "Error", JOptionPane.ERROR_MESSAGE);
		                }
		            }
		        } catch (SQLException ex) {
		            ex.printStackTrace();
		        }
			}
			});
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setFont(new Font("Futura", Font.PLAIN, 13));
		btnNewButton_1.setBounds(290, 96, 117, 29);
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Home_Page home = new Home_Page();
				home.main(null);
			}
		});
		panel.add(btnNewButton_1);
		

		
		JButton btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.setFont(new Font("Futura", Font.PLAIN, 13));
		btnNewButton_2.setBounds(155, 96, 117, 29);
		btnNewButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
		        int choice = JOptionPane.showConfirmDialog(frame, "Are you sure you want to delete this row?", "Confirmation", JOptionPane.YES_NO_OPTION);
		        if (choice == JOptionPane.YES_OPTION) {
		            try (Connection connection = DriverManager.getConnection(url, username, password)) {
		                String deleteQuery = "DELETE FROM " + comboBox.getSelectedItem() + " WHERE scholar_num = ?";
		                try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
		                    preparedStatement.setString(1, textField_1.getText());
		                    int rowsAffected = preparedStatement.executeUpdate();

		                    if (rowsAffected > 0) {
		                        JOptionPane.showMessageDialog(frame, "Row deleted successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
		                    } else {
		                        JOptionPane.showMessageDialog(frame, "Row not found or deletion failed", "Error", JOptionPane.ERROR_MESSAGE);
		                    }
		                }
		            } catch (SQLException ex) {
		                ex.printStackTrace();
		                JOptionPane.showMessageDialog(frame, "Error deleting row: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		            }
		        }
		    }
			});
		panel.add(btnNewButton_2);
		
		frame.setVisible(true);
	}
}
