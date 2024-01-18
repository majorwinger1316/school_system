import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.DatabaseMetaData;

import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class Search {
	
	   private static final String url = "jdbc:mysql://localhost:3306/" + Database_Manager.getInstance().getSelectedDatabase();
	   private static final String username = "root";
	   private static final String password = "Football@1316";
	    private static DefaultTableModel tableModel;
	    private static JFrame tableFrame;
	   
	    public static void fetchStudentInfo(String initialName) {
	        try (Connection connection = DriverManager.getConnection(url, username, password)) {
	            String query = "SELECT * FROM students WHERE student_name LIKE ?";
	            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	                preparedStatement.setString(1, initialName + "%"); // Add % to search for names starting with initialName
	                try (ResultSet resultSet = preparedStatement.executeQuery()) {
	                    tableModel.setRowCount(0); // Clear existing rows
	                    while (resultSet.next()) {
	                        int scholarNumber = resultSet.getInt("scholar_num");
	                        String studentName = resultSet.getString("student_name");
	                        String studentDob = resultSet.getString("DOB");
	                        String fatherName = resultSet.getString("father_name");
	                        String mobileNumber = resultSet.getString("mobile_num");
	                        String studentClass = resultSet.getString("class");

	                        tableModel.addRow(new Object[]{scholarNumber, studentName, studentDob, fatherName, mobileNumber, studentClass});
	                    }
	                }
	            }
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	    }
	    
	    public static JTextField name;
	    public static JTextField dob;
	    public static JTextField scholar;
	    public static JTextField stand;
		
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
		
		JLabel lblNewLabel_1 = new JLabel("Name:");
		lblNewLabel_1.setFont(new Font("Futura", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(6, 36, 54, 22);
		panel.add(lblNewLabel_1);
		
		name = new JTextField();
		name.setBounds(110, 34, 130, 29);
		panel.add(name);
		name.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("DOB:");
		lblNewLabel_2.setFont(new Font("Futura", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(256, 39, 47, 18);
		panel.add(lblNewLabel_2);
		
	    dob = new JTextField();
		dob.setBounds(315, 34, 117, 29);
		panel.add(dob);
		dob.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Scholar No.:");
		lblNewLabel_3.setFont(new Font("Futura", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(6, 68, 89, 22);
		panel.add(lblNewLabel_3);
		
		scholar = new JTextField();
		scholar.setBounds(110, 66, 130, 29);
		panel.add(scholar);
		scholar.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Class:");
		lblNewLabel_4.setFont(new Font("Futura", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(256, 72, 54, 22);
		panel.add(lblNewLabel_4);
		
		stand = new JTextField();
		stand.setBounds(315, 67, 117, 29);
		panel.add(stand);
		stand.setColumns(10);
		
		JButton search = new JButton("Search");
		search.setFont(new Font("Futura", Font.PLAIN, 13));
		search.setBounds(26, 96, 117, 29);
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String studentName = name.getText();
                Search.fetchStudentInfo(studentName);
                tableFrame.setVisible(true); // Display the new window with the table
            }
        });
		panel.add(search);
		
        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new Object[]{"Scholar No.", "Name", "DOB", "Father's Name", "Mobile No.", "Class"});
        JTable resultTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(resultTable);
		
        tableFrame = new JFrame("Search Results");
        tableFrame.setSize(600, 400);
        tableFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        tableFrame.add(scrollPane, BorderLayout.CENTER);
        
        resultTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) { // Double-click
                    int selectedRow = resultTable.getSelectedRow();
                    if (selectedRow != -1) {
                        setDetailsFromTable(selectedRow);
                        tableFrame.dispose(); // Close the window
                    }
                }
            }
        });
        
        resultTable.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    int selectedRow = resultTable.getSelectedRow();
                    if (selectedRow != -1) {
                        setDetailsFromTable(selectedRow);
                        tableFrame.dispose(); // Close the window
                    }
                }
            }
        });
        
        resultTable.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = resultTable.getSelectedRow();
                if (selectedRow != -1) {
                    // Populate text fields with selected student's details
                    scholar.setText(tableModel.getValueAt(selectedRow, 0).toString());
                    name.setText(tableModel.getValueAt(selectedRow, 1).toString());
                    dob.setText(tableModel.getValueAt(selectedRow, 2).toString());
                    stand.setText(tableModel.getValueAt(selectedRow, 5).toString());
                }
            }
        });
        
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
		                String deleteQuery = "DELETE FROM students WHERE class = ? and scholar_num = ?";
		                try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
		                	 preparedStatement.setInt(1, Integer.parseInt(stand.getText())); // Assuming class is an integer
		                	    preparedStatement.setInt(2, Integer.parseInt(scholar.getText()));
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
    private static void setDetailsFromTable(int selectedRow) {
        scholar.setText(tableModel.getValueAt(selectedRow, 0).toString());
        name.setText(tableModel.getValueAt(selectedRow, 1).toString());
        dob.setText(tableModel.getValueAt(selectedRow, 2).toString());
        stand.setText(tableModel.getValueAt(selectedRow, 5).toString());
    }
}
