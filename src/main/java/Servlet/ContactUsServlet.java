package Servlet;

import handler.contactHandler;
import model.contactUs.ContactUs;
import utils.dbConnection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

@WebServlet("/contact-us")
public class ContactUsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/contact-us.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form data
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String message = request.getParameter("message");
        String subject = request.getParameter("subject");


        // Check database connection
        if (!dbConnection.isDatabaseConnected()) {
            request.setAttribute("errorMessage", "Database connection is unavailable. Please try again later.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/contact-us.jsp");
            dispatcher.forward(request, response);
            return;
        }

        Connection connection = null; // Declare connection
        try {
            connection = dbConnection.getConnection(); // Obtain a connection

            // Create a ContactUs object
            ContactUs contactUs = new ContactUs(name, email, message, subject);
            contactHandler submitHandler = new contactHandler();

            // Submit the contact form
            boolean success = submitHandler.submitContact(contactUs); // Pass connection to the handler

            if (success) {
                request.setAttribute("message", "Submission successful!");
                RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/patient-dashboard.jsp");
                dispatcher.forward(request,response);
            } else {
                request.setAttribute("errorMessage", "Submission failed. Please try again.");
                RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/contact-us.jsp");
                dispatcher.forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception
            request.setAttribute("errorMessage", "An error occurred while processing your request.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/contact-us.jsp");
            dispatcher.forward(request, response);
        } finally {
            dbConnection.closeConnection(connection); // Close the connection to prevent leaks
        }
    }
}