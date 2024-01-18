import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.Box;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Get_Fee {
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
    
    private static void searchByName() {
        String studentName = name.getText();
        Get_Fee.fetchStudentInfo(studentName);

		tableFrame.setVisible(true); // Display the new window with the table
    }
    

    
    public static JTextField admis;
    public static JTextField tution;
    public static JTextField exam;
    public static JTextField annual;
    public static JTextField total;
	public static JTextField scholar;
	public static JTextField name;
	public static JTextField dob;
	public static JTextField father;
	public static JTextField mobile;
	public static JTextField stand;
    
    private static void updateTotal() {
        try {
        	int fee1 = Integer.parseInt(admis.getText());
            int fee2 = Integer.parseInt(tution.getText());
            int fee3 = Integer.parseInt(exam.getText());
            int fee4 = Integer.parseInt(annual.getText());

            // Calculate the total sum
            int total_fee = fee1 + fee2 + fee3 + fee4;

            // Update the total JTextField
            total.setText(String.valueOf(total_fee));
        } catch (NumberFormatException ex) {
            // Handle invalid input (non-numeric)
            total.setText("Invalid input");
        }
    }



    
	public static void main(String[] args) {
		JFrame frame = new JFrame();
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
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		horizontalStrut.setBounds(0, 133, 596, 21);
		panel.add(horizontalStrut);
		
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
		
		admis = new JTextField();
		admis.setBounds(431, 164, 130, 28);
		panel.add(admis);
		 admis.getDocument().addDocumentListener(new DocumentListener() {
	            @Override
	            public void insertUpdate(DocumentEvent e) {
	                updateTotal();
	            }

	            @Override
	            public void removeUpdate(DocumentEvent e) {
	                updateTotal();
	            }

	            @Override
	            public void changedUpdate(DocumentEvent e) {
	                updateTotal();
	            }
	        });
		admis.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Tution Fee:");
		lblNewLabel_9.setFont(new Font("Futura", Font.PLAIN, 15));
		lblNewLabel_9.setBounds(6, 199, 83, 21);
		panel.add(lblNewLabel_9);
		
		tution = new JTextField();
		tution.setBounds(151, 196, 130, 28);
		panel.add(tution);
		 tution.getDocument().addDocumentListener(new DocumentListener() {
	            @Override
	            public void insertUpdate(DocumentEvent e) {
	                updateTotal();
	            }

	            @Override
	            public void removeUpdate(DocumentEvent e) {
	                updateTotal();
	            }

	            @Override
	            public void changedUpdate(DocumentEvent e) {
	                updateTotal();
	            }
	        });
		tution.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Exam Fee:");
		lblNewLabel_10.setFont(new Font("Futura", Font.PLAIN, 15));
		lblNewLabel_10.setBounds(293, 202, 126, 18);
		panel.add(lblNewLabel_10);
		
		exam = new JTextField();
		exam.setBounds(431, 197, 130, 28);
		panel.add(exam);
		 exam.getDocument().addDocumentListener(new DocumentListener() {
	            @Override
	            public void insertUpdate(DocumentEvent e) {
	                updateTotal();
	            }

	            @Override
	            public void removeUpdate(DocumentEvent e) {
	                updateTotal();
	            }

	            @Override
	            public void changedUpdate(DocumentEvent e) {
	                updateTotal();
	            }
	        });
		exam.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("Annual Charges:");
		lblNewLabel_11.setFont(new Font("Futura", Font.PLAIN, 15));
		lblNewLabel_11.setBounds(6, 232, 115, 21);
		panel.add(lblNewLabel_11);
		
		annual = new JTextField();
		annual.setBounds(151, 230, 130, 28);
		panel.add(annual);
		 annual.getDocument().addDocumentListener(new DocumentListener() {
	            @Override
	            public void insertUpdate(DocumentEvent e) {
	                updateTotal();
	            }

	            @Override
	            public void removeUpdate(DocumentEvent e) {
	                updateTotal();
	            }

	            @Override
	            public void changedUpdate(DocumentEvent e) {
	                updateTotal();
	            }
	        });
		annual.setColumns(10);
		
		JLabel lblNewLabel_12 = new JLabel("Total Fee:");
		lblNewLabel_12.setFont(new Font("Futura", Font.PLAIN, 15));
		lblNewLabel_12.setBounds(293, 235, 83, 18);
		panel.add(lblNewLabel_12);
		
		total = new JTextField();
		total.setBounds(431, 230, 130, 28);
		total.setEditable(false);
		panel.add(total);
		total.setColumns(10);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setBounds(126, 273, 117, 29);
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
		            if (admis.getText().length() >= 0 && scholar.getText().length() > 0 && tution.getText().length() >= 0 && exam.getText().length() >= 0 && annual.getText().length() >= 0) {
		                
		                    String insertSQL = "INSERT INTO fees(date, scholar_num, admission_fee, tution_fee, exam_fee, annual_charges, total) VALUES (?, ?, ?, ?, ?, ?, ?)";
		                    PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);
		                    preparedStatement.setDate(1, sqlDate);
		                    preparedStatement.setInt(2, Integer.parseInt(scholar.getText()));
		                    preparedStatement.setInt(3, Integer.parseInt(admis.getText()));
		                    preparedStatement.setInt(4, Integer.parseInt(tution.getText()));
		                    preparedStatement.setInt(5, Integer.parseInt(exam.getText()));
		                    preparedStatement.setInt(6, Integer.parseInt(annual.getText()));
		                    preparedStatement.setInt(7, Integer.parseInt(total.getText()));
		                    

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
		btnNewButton_1.setBounds(314, 273, 117, 29);
        btnNewButton_1.addActionListener(e -> {
            frame.dispose();
            Home_Page.main(null);
        });
		panel.add(btnNewButton_1);
		
		scholar = new JTextField();
		scholar.setBounds(126, 32, 155, 28);
		scholar.setEditable(false);
		panel.add(scholar);
		scholar.setColumns(10);
		
		name = new JTextField();
		name.setBounds(79, 64, 202, 28);
		panel.add(name);
		name.setColumns(10);
		
		dob = new JTextField();
		dob.setBounds(79, 98, 202, 28);
		dob.setEditable(false); 
		panel.add(dob);
		dob.setColumns(10);

		father = new JTextField();
		father.setBounds(410, 65, 180, 28);
		father.setEditable(false); 
		panel.add(father);
		father.setColumns(10);

		mobile = new JTextField();
		mobile.setBounds(410, 98, 180, 28);
		mobile.setEditable(false); 
		panel.add(mobile);
		mobile.setColumns(10);

		stand = new JTextField();
		stand.setBounds(410, 32, 180, 28);
		stand.setEditable(false); 
		panel.add(stand);
		stand.setColumns(10);
		
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
        
        JButton search = new JButton("Search");
        search.setBounds(223, 133, 117, 29);
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String studentName = name.getText();
                Get_Fee.fetchStudentInfo(studentName);
                tableFrame.setVisible(true); // Display the new window with the table
            }
        });
        panel.add(search);
        
        resultTable.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = resultTable.getSelectedRow();
                if (selectedRow != -1) {
                    // Populate text fields with selected student's details
                    scholar.setText(tableModel.getValueAt(selectedRow, 0).toString());
                    name.setText(tableModel.getValueAt(selectedRow, 1).toString());
                    dob.setText(tableModel.getValueAt(selectedRow, 2).toString());
                    father.setText(tableModel.getValueAt(selectedRow, 3).toString());
                    mobile.setText(tableModel.getValueAt(selectedRow, 4).toString());
                    stand.setText(tableModel.getValueAt(selectedRow, 5).toString());
                }
            }
        });
        

		
		frame.setVisible(true);
		
		admis.setText("0");
		tution.setText("0");
		exam.setText("0");
		annual.setText("0");
		total.setText("0");
		
	}
	

    
    private static void setDetailsFromTable(int selectedRow) {
        scholar.setText(tableModel.getValueAt(selectedRow, 0).toString());
        name.setText(tableModel.getValueAt(selectedRow, 1).toString());
        dob.setText(tableModel.getValueAt(selectedRow, 2).toString());
        father.setText(tableModel.getValueAt(selectedRow, 3).toString());
        mobile.setText(tableModel.getValueAt(selectedRow, 4).toString());
        stand.setText(tableModel.getValueAt(selectedRow, 5).toString());
    }

	
}
