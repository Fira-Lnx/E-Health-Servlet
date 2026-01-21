package handler;

import model.user.User; // Assuming you have a User model class defined.
import utils.dbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class userHandler {

    public boolean register(User user) {
        boolean success = false;
        String query = "INSERT INTO users (name, mobile, email, password, pincode, city, state, address) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = dbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, user.getName());
            statement.setString(2, user.getMobile());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getPassword());
            statement.setString(5, user.getPincode());
            statement.setString(6, user.getCity());
            statement.setString(7, user.getState());
            statement.setString(8, user.getAddress());

            int rowsInserted = statement.executeUpdate();
            success = (rowsInserted > 0);
        } catch (SQLException e) {
            System.err.println("Registration error: " + e.getMessage());
        }
        return success;
    }

    // For login
    public boolean login(String firstName, String password) {
        boolean loggedIn = false;
        String sql = "SELECT * FROM users WHERE name = ? AND password = ?";
        try (Connection connection = dbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, firstName);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();
            loggedIn = resultSet.next();
        } catch (SQLException e) {
            System.err.println("Login error: " + e.getMessage());
        }
        return loggedIn;
    }

    // Method to fetch all patients
    public List<User> fetchAllPatients() {
        List<User> patients = new ArrayList<>();
        String query = "SELECT * FROM users"; // Adjust this query as necessary

        try (Connection connection = dbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                // Assuming the User class has an appropriate constructor
                User user = new User(
                        resultSet.getString("name"),
                        resultSet.getString("mobile"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("pincode"),
                        resultSet.getString("city"),
                        resultSet.getString("state"),
                        resultSet.getString("address")
                );
                patients.add(user);
            }
        } catch (SQLException e) {
            System.err.println("Fetch all patients error: " + e.getMessage());
        }

        return patients;
    }
}
