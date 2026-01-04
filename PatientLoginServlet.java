package Servlet;

import handler.userHandler;
import model.receptionist.Receptionist;
import utils.dbConnection;  // Import your DBConnection class

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/patient-login")
public class PatientLoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/patient-login.jsp");
        dispatcher.forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String password = request.getParameter("password");

        // Check database connection before proceeding with login
        if (!dbConnection.isDatabaseConnected()) {
            request.setAttribute("errorMessage", "Database connection is unavailable. Please try again later.");
            System.out.println("Connection Failed");
            RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/patient-login.jsp");
            dispatcher.forward(request, response);
            return;
        }

        Connection connection = null; // Declare connection
        userHandler loginHandler = new userHandler();

        try {
            connection = dbConnection.getConnection(); // Obtain a connection

            // Validate the user's credentials using the connection
            boolean success = loginHandler.login(firstName, password); // Pass the connection to login

            if (success) {
                request.setAttribute("message", "Login successful");
                request.getSession().setAttribute("user", firstName);
                RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/patient-dashboard.jsp");
                dispatcher.forward(request, response);
            } else {
                request.setAttribute("errorMessage", "Invalid credentials, please try again.");
                RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/patient-login.jsp");
                dispatcher.forward(request, response);
            }
        } finally {
            dbConnection.closeConnection(connection); // Close the connection to prevent leaks
        }
    }
}