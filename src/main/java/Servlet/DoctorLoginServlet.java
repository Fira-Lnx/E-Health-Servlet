package Servlet;

import handler.doctorHandler;
import utils.dbConnection;  // Import your DBConnection class

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

@WebServlet("/doctor-login")
public class DoctorLoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/doctor-login.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get login details from request
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        System.out.println("Post request for login");

        // Check database connection before proceeding with login
        if (!dbConnection.isDatabaseConnected()) {
            request.setAttribute("errorMessage", "Database connection is unavailable. Please try again later.");
            System.out.println("Connection Failed");
            RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/doctor-login.jsp");
            dispatcher.forward(request, response);
            return;
        }

        Connection connection = null;

        try {
            connection = dbConnection.getConnection(); // Obtain a connection
            doctorHandler handler = new doctorHandler();

            // Validate the doctor's credentials using the connection
            boolean loginSuccess = handler.login(name, password); // Implement this in your doctorHandler

            if (loginSuccess) {
                request.setAttribute("message", "Login successful!");
                request.getSession().setAttribute("user", name); // Store user details in the session

                // Redirecting to dashboard upon successful login
                response.sendRedirect("jsp/doctor-dashboard.jsp"); // Redirect instead of forward
            } else {
                request.setAttribute("errorMessage", "Invalid name or password. Please try again.");
                RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/doctor-login.jsp");
                dispatcher.forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace(); // Error handling (add your logging here)
            request.setAttribute("errorMessage", "An unexpected error occurred. Please try again.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/doctor-login.jsp");
            dispatcher.forward(request, response);
        } finally {
            dbConnection.closeConnection(connection); // Close connection to prevent leaks
        }
    }
}