package handler;

import model.appointment.Appointment;
import utils.dbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class appointmentHandler {

    // Method to book an appointment
    public boolean bookAppointment(Appointment appointment) {
        String sql = "INSERT INTO appointments (doctor, appointment_date, appointment_time, reason) VALUES (?, ?, ?, ?)";
        try (Connection connection = dbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, appointment.getDoctor());
            statement.setDate(2, (java.sql.Date) appointment.getDate());
            statement.setTime(3, appointment.getTime());
            statement.setString(4, appointment.getReason());

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0; // Returns true if the insert was successful
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Handle exceptions appropriately
        }
    }

    // Method to fetch all appointments
    public List<Appointment> fetchAllAppointments() {
        List<Appointment> appointments = new ArrayList<>();
        String query = "SELECT * FROM appointments"; // Adapt as needed

        try (Connection connection = dbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Appointment appointment = new Appointment(
                        resultSet.getString("doctor"),
                        resultSet.getDate("appointment_date"),
                        resultSet.getTime("appointment_time"),
                        resultSet.getString("reason")
                );
                appointments.add(appointment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return appointments;
    }
}