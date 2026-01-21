package handler;

import utils.dbConnection; // Ensure you have your DBConnection class imported

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class adminHandler {

    // Method to validate admin login credentials
    public boolean login(String name, String password) {
        String sql = "SELECT * FROM admins WHERE name = ? AND password = ?";

        try (Connection connection = dbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            // Set parameters for the prepared statement
            statement.setString(1, name);
            statement.setString(2, password); // It's better to hash the password in a real application

            // Execute the query and check for results
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next(); // Return true if there is a result (matching admin)
        } catch (Exception e) {
            e.printStackTrace();
            return false; // Handle exceptions appropriately
        }
    }
    public boolean changePassword(String email, String oldPassword, String newPassword) {
        // Step 1: Verify old password
        if (!login(email, oldPassword)) {
            System.err.println("Old password is incorrect.");
            return false; // Old password is incorrect
        }

        String sql = "UPDATE admins SET password = ? WHERE email = ?";
        boolean isUpdated = false;

        try (Connection connection = dbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, newPassword); // Ideally, hash this password
            statement.setString(2, email);

            int rowsAffected = statement.executeUpdate();
            isUpdated = rowsAffected > 0; // Returns true if the password was updated
        } catch (SQLException e) {
            System.err.println("Change password error: " + e.getMessage());
        }

        return isUpdated; // Return whether the update was successful
    }
}