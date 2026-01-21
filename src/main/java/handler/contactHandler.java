package handler;


import model.appointment.Appointment;
import model.contactUs.ContactUs;
import utils.dbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class contactHandler {

    // Method to book an appointment
    public boolean submitContact(ContactUs contactUs) {
        String sql = "INSERT INTO contacts (name,email,message,subject) VALUES (?, ?, ?, ?)";
        try {
            Connection connection = dbConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, contactUs.getName());
            statement.setString(2, contactUs.getEmail());
            statement.setString(3, contactUs.getMessage());
            statement.setString(4, contactUs.getSubject());

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0; // Returns true if the insert was successful
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Handle exceptions appropriately
        }
    }

    // Method to fetch all appointments
    public List<ContactUs> fetchAllContacts() {
        List<ContactUs> contactUsList = new ArrayList<>();
        String query = "SELECT * FROM contacts"; // Adapt as needed

        try (Connection connection = dbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                ContactUs contactUs = new ContactUs(
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getString("message"),
                        resultSet.getString("subject")
                );
                contactUsList.add(contactUs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return contactUsList;
    }
}