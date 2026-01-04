package Servlet;

import handler.appointmentHandler;
import model.appointment.Appointment;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;

@WebServlet("/receptionist-book-appointment")
public class ReceptionistAppointmentServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/receptionist-appointment-form.jsp");
        dispatcher.forward(request , response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get appointment details from the request
        String doctor = request.getParameter("doctor");
        Date date = Date.valueOf(request.getParameter("date")); // Expect format yyyy-mm-dd
        String timeParam = request.getParameter("time"); // Get the time input as a string
        String reason = request.getParameter("reason");

        // Validate time format for HH:mm (24-hour format)
        if (timeParam == null || !timeParam.matches("\\d{2}:\\d{2}")) {
            request.setAttribute("errorMessage", "Invalid time format. Please use HH:mm.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/receptionist-appointment-form.jsp");
            dispatcher.forward(request, response);
            return;
        }

        // Convert input time to SQL Time Object
        Time time = Time.valueOf(timeParam + ":00"); // Append seconds, as Time.valueOf expects HH:mm:ss


        // Create an Appointment object
        Appointment appointment = new Appointment(doctor, date, time, reason);

        // Create an instance of appointmentHandler to handle booking
        appointmentHandler handler = new appointmentHandler();
        boolean success = handler.bookAppointment(appointment);

        // Redirect or forward based on booking success
        if (success) {
            request.setAttribute("message", "Appointment booked successfully!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/receptionist-dashboard.jsp");
            dispatcher.forward(request,response);
        } else {
            request.setAttribute("errorMessage", "Failed to book appointment. Please try again.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/receptionist-appointment-form.jsp");
            dispatcher.forward(request, response);
        }
    }


}