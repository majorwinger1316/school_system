import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class Class_List {
    private static final String url = "jdbc:mysql://localhost:3306/" + Database_Manager.getInstance().getSelectedDatabase();
    private static final String username = "root";
    private static final String password = "Football@1316";
    private static JTable table;
    private static DefaultTableModel tableModel;

    private static void loadTableNames() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                DatabaseMetaData metaData = (DatabaseMetaData) connection.getMetaData();

                // Get the table names
                ResultSet resultSet = metaData.getTables(Database_Manager.getInstance().getSelectedDatabase(), null, "%", new String[]{"TABLE"});
                Vector<String> tableNames = new Vector<>();

                while (resultSet.next()) {
                    tableNames.add(resultSet.getString("TABLE_NAME"));
                }

                // Initialize the table model
                tableModel = new DefaultTableModel();

                // Display the table names in the JTable
                displayTableNames(tableNames);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private static void displayTableNames(Vector<String> tableNames) {
        // Set column names
        String[] columnNames = {"Table Name"};
        tableModel.setColumnIdentifiers(columnNames);

        // Add data to the table model
        for (String tableName : tableNames) {
            Vector<String> rowData = new Vector<>();
            rowData.add(tableName);
            tableModel.addRow(rowData);
        }

        // Set the table model to the JTable
        table.setModel(tableModel);
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
        loadTableNames();
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

