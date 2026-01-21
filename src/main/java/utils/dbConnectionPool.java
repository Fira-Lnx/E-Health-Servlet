package utils;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class dbConnectionPool {

    private static HikariDataSource ds;

    // Static block to configure the connection pool
    static {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://localhost:3306/eHealth"); // Change as necessary
        config.setUsername("root"); // Change as necessary
        config.setPassword("admin@96"); // Change as necessary
        config.setMaximumPoolSize(10); // Adjust the pool size as needed
        config.setConnectionTimeout(30000); // Set connection timeout
        config.setIdleTimeout(600000); // Set idle timeout
        config.setMaxLifetime(1800000); // Set max lifetime of connections

        ds = new HikariDataSource(config);
    }

    // Method to get a connection from the pool
    public static Connection getConnection() throws SQLException {
        return ds.getConnection(); // Returns a Connection from the pool
    }

    // Method to shut down the connection pool
    public static void shutdownPool() {
        if (ds != null) {
            ds.close();
            System.out.println("DataSource closed.");
        }
    }
}