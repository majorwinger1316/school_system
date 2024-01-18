import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class Class_List {
    private static final String url = "jdbc:mysql://localhost:3306/" + Database_Manager.getInstance().getSelectedDatabase();
    private static final String username = "root";
    private static final String password = "Football@1316";
    private static JTable table;
    private static DefaultTableModel tableModel;

    private static void loadTableData(String tableName) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                // Prepare a SQL query to fetch all rows from the selected table
                String query = "SELECT class FROM classes";
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    // Execute the query
                    ResultSet resultSet = preparedStatement.executeQuery();

                    // Initialize the table model
                    tableModel = new DefaultTableModel();

                    // Set column names
                    int columnCount = resultSet.getMetaData().getColumnCount();
                    Vector<String> columnNames = new Vector<>();
                    for (int i = 1; i <= columnCount; i++) {
                        columnNames.add(resultSet.getMetaData().getColumnName(i));
                    }
                    tableModel.setColumnIdentifiers(columnNames);

                    // Add data to the table model
                    while (resultSet.next()) {
                        Vector<Object> rowData = new Vector<>();
                        for (int i = 1; i <= columnCount; i++) {
                            rowData.add(resultSet.getObject(i));
                        }
                        tableModel.addRow(rowData);
                    }

                    // Set the table model to the JTable
                    table.setModel(tableModel);
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setBounds(100, 100, 450, 286);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(6, 6, 438, 246);
        frame.getContentPane().add(panel);
        panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADARSH VIDYALAYA, 11/223 SOUTER GANJ, KANPUR(208001)");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Futura", Font.PLAIN, 13));
		lblNewLabel.setBounds(6, 6, 426, 16);
		panel.add(lblNewLabel);
		
        table = new JTable();
		table.setBounds(115, 34, 203, 162);
        loadTableData(null);
        panel.add(table);

        JButton btnNewButton = new JButton("Back");
        btnNewButton.setBounds(162, 208, 117, 29);
        btnNewButton.addActionListener(e -> {
            frame.dispose();
            Home_Page.main(null);
        });
        panel.add(btnNewButton);

        frame.setVisible(true);
    }
}

