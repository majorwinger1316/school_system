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

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Edit_Fee {
    private static final String url = "jdbc:mysql://localhost:3306/" + Database_Manager.getInstance().getSelectedDatabase();
    private static final String username = "root";
    private static final String password = "Football@1316";
    private static DefaultTableModel tableModel;
    private static JFrame tableFrame;
    
    public static void fetchStudentInfo(String initialName) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT * FROM fees WHERE scholar_num LIKE ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) { 
            	preparedStatement.setString(1, initialName + "%");// Add % to search for names starting with initialName
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    tableModel.setRowCount(0); // Clear existing rows
                    while (resultSet.next()) {
                        int scholarNumber = resultSet.getInt("scholar_num");
                        int invoice_num = resultSet.getInt("invoice_num");
                        String date = resultSet.getString("date");
                        int admission_fee = resultSet.getInt("admission_fee");
                        int tution_fee = resultSet.getInt("tution_fee");
                        int exam_fee = resultSet.getInt("exam_fee");
                        int annual_charges = resultSet.getInt("annual_charges");
                        int total = resultSet.getInt("total");

                        tableModel.addRow(new Object[]{invoice_num, scholarNumber, date, admission_fee, tution_fee, exam_fee, annual_charges, total});
                    }
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public static JTextField scholar;
    public static JTextField invoice;
    public static JTextField admission;
    public static JTextField tution;
    public static JTextField exam;
	public static JTextField annual;
	public static JTextField total;
	public static JTextField dateChooser;
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
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
		
		scholar = new JTextField();
		scholar.setBounds(130, 33, 112, 32);
		panel.add(scholar);
		scholar.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Date:");
		lblNewLabel_2.setFont(new Font("Futura", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(254, 39, 105, 21);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Invoice Number:");
		lblNewLabel_3.setFont(new Font("Futura", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(6, 72, 112, 21);
		panel.add(lblNewLabel_3);
		
		invoice = new JTextField();
		invoice.setBounds(130, 66, 112, 32);
		invoice.setEditable(false);
		panel.add(invoice);
		invoice.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Admission Fee:");
		lblNewLabel_4.setFont(new Font("Futura", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(254, 72, 105, 21);
		panel.add(lblNewLabel_4);
		
		admission = new JTextField();
		admission.setBounds(371, 66, 130, 32);
		admission.setEditable(false);
		panel.add(admission);
		admission.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Tution Fee:");
		lblNewLabel_5.setFont(new Font("Futura", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(6, 105, 112, 21);
		panel.add(lblNewLabel_5);
		
		tution = new JTextField();
		tution.setBounds(130, 99, 112, 32);
		tution.setEditable(false);
		panel.add(tution);
		tution.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Exam Fee:");
		lblNewLabel_6.setFont(new Font("Futura", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(254, 107, 105, 19);
		panel.add(lblNewLabel_6);
		
		exam = new JTextField();
		exam.setBounds(371, 99, 130, 32);
		exam.setEditable(false);
		panel.add(exam);
		exam.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Annual Charges:");
		lblNewLabel_7.setFont(new Font("Futura", Font.PLAIN, 14));
		lblNewLabel_7.setBounds(6, 138, 112, 21);
		panel.add(lblNewLabel_7);
		
		annual = new JTextField();
		annual.setBounds(130, 132, 112, 32);
		annual.setEditable(false);
		panel.add(annual);
		annual.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Total Fee:");
		lblNewLabel_8.setFont(new Font("Futura", Font.PLAIN, 14));
		lblNewLabel_8.setBounds(254, 138, 105, 21);
		panel.add(lblNewLabel_8);
		
		total = new JTextField();
		total.setBounds(371, 132, 130, 32);
		total.setEditable(false);
		panel.add(total);
		total.setColumns(10);
		
		dateChooser = new JTextField();
		dateChooser.setBounds(371, 33, 130, 32);
		dateChooser.setEditable(false);
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
		
        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new Object[]{"invoice_num", "scholarNumber", "date", "admission_fee", "tution_fee", "exam_fee", "annual_charges", "total"});
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
		
		JButton search = new JButton("Search");
		search.setBounds(193, 171, 117, 29);
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String schol = scholar.getText();
                Edit_Fee.fetchStudentInfo(schol);
                tableFrame.setVisible(true); // Display the new window with the table
            }
        });
		panel.add(search);
		
        resultTable.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = resultTable.getSelectedRow();
                if (selectedRow != -1) {
                    // Populate text fields with selected student's details
                    invoice.setText(tableModel.getValueAt(selectedRow, 0).toString());
                    scholar.setText(tableModel.getValueAt(selectedRow, 1).toString());
                    dateChooser.setText(tableModel.getValueAt(selectedRow, 2).toString());
                    admission.setText(tableModel.getValueAt(selectedRow, 3).toString());
                    tution.setText(tableModel.getValueAt(selectedRow, 4).toString());
                    exam.setText(tableModel.getValueAt(selectedRow, 5).toString());
                    annual.setText(tableModel.getValueAt(selectedRow, 6).toString());
                    total.setText(tableModel.getValueAt(selectedRow, 7).toString());
                }
            }
        });
		
		JTextField newschol = new JTextField();
		newschol.setBounds(254, 242, 117, 32);
		panel.add(newschol);
		newschol.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Change");
		btnNewButton_1.setBounds(104, 278, 117, 29);

btnNewButton_1.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        int selectedRow = resultTable.getSelectedRow();
        if (selectedRow != -1) {
            String newScholarNumber = newschol.getText();
            if (!newScholarNumber.isEmpty()) {
                if (updateScholarNumber(selectedRow, newScholarNumber)) {
                    fetchStudentInfo(newScholarNumber);
                    // Show a success message
                    JOptionPane.showMessageDialog(frame, "Scholar number changed successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    // Handle the case when the update fails
                    JOptionPane.showMessageDialog(frame, "Failed to change scholar number.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                // Handle the case when the new scholar number is empty
                JOptionPane.showMessageDialog(frame, "Please enter a new scholar number.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            // Handle the case when no row is selected
            JOptionPane.showMessageDialog(frame, "Please select a row to update.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
});
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.setBounds(275, 278, 117, 29);
		btnNewButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Home_Page.main(null);
			}
		});
		panel.add(btnNewButton_2);
		
		frame.setVisible(true);
	}
	private static boolean updateScholarNumber(int selectedRow, String newScholarNumber) {
	    try (Connection connection = DriverManager.getConnection(url, username, password)) {
	        String updateQuery = "UPDATE fees SET scholar_num = ? WHERE invoice_num = ?";
	        try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
	            preparedStatement.setString(1, newScholarNumber);
	            preparedStatement.setInt(2, (int) tableModel.getValueAt(selectedRow, 0)); // Assuming the first column is invoice_num
	            int rowsAffected = preparedStatement.executeUpdate();
	            return rowsAffected > 0; // If at least one row is affected, consider it a success
	        }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	        // Handle the SQL exception, show an error message, or take appropriate action
	        return false;
	    }
	}
	
    private static void setDetailsFromTable(int selectedRow) {
        invoice.setText(tableModel.getValueAt(selectedRow, 0).toString());
        scholar.setText(tableModel.getValueAt(selectedRow, 1).toString());
        dateChooser.setText(tableModel.getValueAt(selectedRow, 2).toString());
        admission.setText(tableModel.getValueAt(selectedRow, 3).toString());
        tution.setText(tableModel.getValueAt(selectedRow, 4).toString());
        exam.setText(tableModel.getValueAt(selectedRow, 5).toString());
        annual.setText(tableModel.getValueAt(selectedRow, 6).toString());
        total.setText(tableModel.getValueAt(selectedRow, 7).toString());
    }

}
