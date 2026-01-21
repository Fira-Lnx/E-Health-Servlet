package handler;

import model.doctor.Doctor; // Ensure this model exists
import utils.dbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class doctorHandler {

    public boolean login(String name, String password) {
        String sql = "SELECT * FROM doctors WHERE name = ? AND password = ?";
        boolean login = false;

        try (Connection connection = dbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, name);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            login = resultSet.next(); // Returns true if doctor exists
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return login;
    }

    public List<Doctor> fetchAllDoctors() {
        List<Doctor> doctors = new ArrayList<>();
        String query = "SELECT name, email, password, qualification, specialization, contact, address FROM doctors";

        try (Connection connection = dbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Doctor doctor = new Doctor(
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("qualification"),
                        resultSet.getString("specialization"),
                        resultSet.getString("contact"),
                        resultSet.getString("address")
                );
                doctors.add(doctor);
            }
        } catch (SQLException e) {
            System.err.println("Fetch all doctors error: " + e.getMessage());
        }

        return doctors;
    }

    public boolean register(Doctor doctor) {
        String sql = "INSERT INTO doctors (name, email, password, qualification, specialization, contact, address) VALUES (?, ?, ?, ?, ?, ?, ?)";
        boolean isRegistered = false;

        // Check if the email already exists
        if (isEmailExists(doctor.getEmail())) {
            System.err.println("Email already exists: " + doctor.getEmail());
            return false; // Email already exists
        }

        try (Connection connection = dbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, doctor.getName());
            statement.setString(2, doctor.getEmail());
            statement.setString(3, doctor.getPassword());
            statement.setString(4, doctor.getQualification());
            statement.setString(5, doctor.getSpecialization());
            statement.setString(6, doctor.getContact());
            statement.setString(7, doctor.getAddress());

            int rowsAffected = statement.executeUpdate();
            isRegistered = rowsAffected > 0; // Returns true if the registration was successful
        } catch (SQLException e) {
            System.err.println("Registration error: " + e.getMessage());
        }

        return isRegistered;
    }

    private boolean isEmailExists(String email) {
        String sql = "SELECT COUNT(*) FROM doctors WHERE email = ?";
        try (Connection connection = dbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getInt(1) > 0; // Returns true if email exists
            }
        } catch (SQLException e) {
            System.err.println("Check email existence error: " + e.getMessage());
        }
        return false; // Default as false if any error occurs
    }

    // Method to change the doctor's password
    public boolean changePassword(String email, String oldPassword, String newPassword) {
        // Step 1: Verify old password
        if (!login(email, oldPassword)) {
            System.err.println("Old password is incorrect.");
            return false; // Old password is incorrect
        }

        String sql = "UPDATE doctors SET password = ? WHERE email = ?";
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