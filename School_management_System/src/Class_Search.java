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
import javax.swing.JButton;
import javax.swing.JComboBox;

public class Class_Search {
    
    private static final String url = "jdbc:mysql://localhost:3306/" + Database_Manager.getInstance().getSelectedDatabase();
    private static final String username = "root";
    private static final String password = "Football@1316";
    
    private static JComboBox<String> comboBox;
    
    private static void populateComboBox() {
        comboBox.removeAllItems();
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String tableName = "students";
            String columnName = "class";

            String sql = "SELECT DISTINCT " + columnName + " FROM " + tableName;
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
                 ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    String classValue = resultSet.getString(columnName);
                    comboBox.addItem(classValue);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setBounds(100, 100, 450, 151);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBounds(6, 6, 438, 111);
        frame.getContentPane().add(panel);
        panel.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("ADARSH VIDYALAYA, 11/223 SOUTER GANJ, KANPUR(208001)");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Futura", Font.PLAIN, 14));
        lblNewLabel.setBounds(6, 6, 426, 16);
        panel.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("Select Class:");
        lblNewLabel_1.setFont(new Font("Futura", Font.PLAIN, 15));
        lblNewLabel_1.setBounds(86, 34, 110, 22);
        panel.add(lblNewLabel_1);
        
        comboBox = new JComboBox<>();
        comboBox.setBounds(191, 34, 136, 27);
        panel.add(comboBox);

        // Populate JComboBox
        populateComboBox();
        
        JButton btnNewButton = new JButton("Search");
        btnNewButton.setFont(new Font("Futura", Font.PLAIN, 13));
        btnNewButton.setBounds(79, 71, 117, 29);
        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection connection = DriverManager.getConnection(url, username, password);

                    // Replace with your actual table name and column name
                    String tableName = "students";
                    String columnName = "class";

                    // Prepare SQL query
                    String sql = "SELECT COUNT(*) AS count_of_rows FROM " + tableName + " WHERE " + columnName + " = ?";
                    PreparedStatement preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.setString(1, (String) comboBox.getSelectedItem());

                    // Execute the query
                    ResultSet resultSet = preparedStatement.executeQuery();

                    // Process the result
                    if (resultSet.next()) {
                        int count = resultSet.getInt("count_of_rows");
                        // Display the result in a dialog box
                        JOptionPane.showMessageDialog(frame, "Total Number of Students in class " + comboBox.getSelectedItem() + ": " + count);
                    }

                    // Close resources
                    resultSet.close();
                    preparedStatement.close();
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panel.add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("Back");
        btnNewButton_1.setFont(new Font("Futura", Font.PLAIN, 13));
        btnNewButton_1.setBounds(208, 71, 117, 29);
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
