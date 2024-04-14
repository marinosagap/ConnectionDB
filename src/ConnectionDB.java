import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class ConnectionDB {
    // Database connection parameters
    private static final String URL = "jdbc:postgresql://localhost:5432/marinos_db";
    private static final String USER = "marinos";
    private static final String PASSWORD = "marinos123!";

    // Method to create and return database connection
    public static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    // Method to fetch the current date and time from the database
    public static void getCurrentDateTime() {
        String SQL = "SELECT NOW()";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {
            if (rs.next()) {
                System.out.println("Current date and time: " + rs.getString(1));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) {
        getCurrentDateTime();
    }
}
