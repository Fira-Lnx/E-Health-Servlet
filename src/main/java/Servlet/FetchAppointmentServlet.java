package Servlet;


import handler.appointmentHandler;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import model.appointment.Appointment;

@WebServlet("/fetch-appointments")
public class FetchAppointmentServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        appointmentHandler handler = new appointmentHandler();
        List<Appointment> appointments = handler.fetchAllAppointments();

        // Set the appointments list as a request attribute
        request.setAttribute("appointments", appointments);

        // Forward to the JSP page to display the appointments
        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/appointment-table.jsp"); // Adjust the path as necessary
        dispatcher.forward(request, response);
    }
}