package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnection {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/eHealth";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "admin@96";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.err.println("Database Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Error establishing database connection: " + e.getMessage());
        }
        return connection;
    }

    // Method to check if the database connection is active
    public static boolean isDatabaseConnected() {
        Connection connection = null;
        try {
            connection = getConnection();
            return connection != null && !connection.isClosed();
        } catch (SQLException e) {
            System.err.println("Error checking database connection: " + e.getMessage());
            return false;
        } finally {
            if (connection != null) {
                try {
                    connection.close(); // close the connection after checking
                } catch (SQLException e) {
                    System.err.println("Error closing connection: " + e.getMessage());
                }
            }
        }
    }

        // Method to close the provided connection
        public static void closeConnection(Connection connection) {
            if (connection != null) {
                try {
                    connection.close();
                    System.out.println("Database connection closed.");
                } catch (SQLException e) {
                    System.err.println("Error closing database connection: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        }



}