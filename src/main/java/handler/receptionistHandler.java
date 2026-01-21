package handler;

import model.receptionist.Receptionist;
import utils.dbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class receptionistHandler {

    // Method to register a receptionist
    public boolean register(Receptionist receptionist) {
        boolean success = false;
        String query = "INSERT INTO receptionists (name,  email,phoneNumber, address, password) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = dbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, receptionist.getName());
            statement.setString(2, receptionist.getEmail()); // Use phoneNumber instead of mobile
            statement.setString(3, receptionist.getPhoneNumber());
            statement.setString(4, receptionist.getAddress());
            statement.setString(5, receptionist.getPassword());

            int rowsInserted = statement.executeUpdate();
            success = (rowsInserted > 0);
        } catch (SQLException e) {
            System.err.println("Registration error: " + e.getMessage());
        }
        return success;
    }

    // Method for receptionist login
    public boolean login(String name, String password) {
        boolean loggedIn = false;
        String sql = "SELECT * FROM receptionists WHERE name = ? AND password = ?";

        try (Connection connection = dbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, name);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            loggedIn = resultSet.next(); // Returns true if login is successful
        } catch (SQLException e) {
            System.err.println("Login error: " + e.getMessage());
        }
        return loggedIn;
    }

    // Method to fetch all receptionists
    public List<Receptionist> fetchAllReceptionists() {
        List<Receptionist> receptionists = new ArrayList<>();
        String query = "SELECT * FROM receptionists"; // Adjust this query as necessary

        try (Connection connection = dbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Receptionist receptionist = new Receptionist(
                        resultSet.getString("name"),
                        resultSet.getString("email"), // Use phoneNumber instead of mobile
                        resultSet.getString("phoneNumber"),
                        resultSet.getString("address"), // Use address instead of Address
                        resultSet.getString("password") // You may not want to include the password
                );
                receptionists.add(receptionist);
            }
        } catch (SQLException e) {
            System.err.println("Fetch all receptionists error: " + e.getMessage());
        }

        return receptionists;
    }
}