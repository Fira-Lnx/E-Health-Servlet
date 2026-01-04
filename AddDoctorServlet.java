package Servlet;

import handler.doctorHandler;
import model.doctor.Doctor;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add-new-doctor")
public class AddDoctorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Forward to the add-new-doctor.jsp form
        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/add-new-doctor.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get form parameters
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String qualification = request.getParameter("qualification");
        String specialization = request.getParameter("specialization");
        String contact = request.getParameter("contact");
        String address = request.getParameter("address");

        // Create a new Doctor object
        Doctor newDoctor = new Doctor(name, email, password, qualification, specialization, contact, address);

        // Use the doctorHandler to register the new doctor
        doctorHandler handler = new doctorHandler();
        boolean success = handler.register(newDoctor); // Assume this method exists

        if (success) {
            // If registration successful, redirect to a success page or dashboard
            request.setAttribute("message", "Doctor added successfully!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/admin-dashboard.jsp");
            dispatcher.forward(request,response);
        } else {
            // If registration fails, show an error message and redirect back to the form
            request.setAttribute("errorMessage", "Failed to add doctor. Please try again or check for duplicate email.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/add-new-doctor.jsp");
            dispatcher.forward(request, response);
        }
    }
}