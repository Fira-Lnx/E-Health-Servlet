package Servlet;

import handler.receptionistHandler; // Make sure you have a handler for receptionist
import utils.dbConnection; // Import your DBConnection class

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;

@WebServlet("/receptionist-login")
public class ReceptionistLoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // Redirect to receptionist login page
        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/receptionist-login.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String password = request.getParameter("password");

        // Check if firstName or password is missing
        if (firstName == null || password == null || firstName.isEmpty() || password.isEmpty()) {
            request.setAttribute("errorMessage", "Both username and password are required!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/receptionist-login.jsp");
            dispatcher.forward(request, response);
            return;
        }

        // Check database connection before proceeding with login
        if (!dbConnection.isDatabaseConnected()) {
            request.setAttribute("errorMessage", "Database connection is unavailable. Please try again later.");
            System.out.println("Connection Failed");
            RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/receptionist-login.jsp");
            dispatcher.forward(request, response);
            return;
        }

        Connection connection = null; // Declare connection
        receptionistHandler loginHandler = new receptionistHandler(); // Assuming there's a handler for receptionists

        try {
            connection = dbConnection.getConnection(); // Obtain a connection

            // Validate the receptionist's credentials using the handler
            boolean success = loginHandler.login(firstName, password); // Ensure the login method is defined

            if (success) { // If login is successful
                HttpSession session = request.getSession();
                session.setAttribute("user", firstName); // Store the username or receptionist object in session
                RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/receptionist-dashboard.jsp");
                dispatcher.forward(request, response);
            } else {
                // If login is unsuccessful
                request.setAttribute("errorMessage", "Invalid credentials, please try again.");
                RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/receptionist-login.jsp");
                dispatcher.forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "An error occurred while trying to login.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/receptionist-login.jsp");
            dispatcher.forward(request, response);
        } finally {
            dbConnection.closeConnection(connection); // Close the connection to prevent leaks
        }
    }
}