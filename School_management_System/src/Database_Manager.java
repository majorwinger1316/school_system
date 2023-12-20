import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database_Manager {
	private static final String url = "jdbc:mysql://localhost:3306/";
	private static final String username = "root";
	private static final String password = "Football@1316";
    private static Database_Manager instance = null;

    private String selectedDatabase;
    private Connection connection;

    private Database_Manager() {
        // Private constructor to prevent instantiation
    }

    public static Database_Manager getInstance() {
        if (instance == null) {
            instance = new Database_Manager();
        }
        return instance;
    }

    public void connect(Object object) {
        String jdbcUrl = url + object;

        try {
            connection = DriverManager.getConnection(jdbcUrl, username, password);
            selectedDatabase = (String) object;
            System.out.println("Connected to database: " + object);
        } catch (SQLException ex) {
            System.err.println("Error connecting to the database: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public String getSelectedDatabase() {
        return selectedDatabase;
    }
}
