package Servlet;

import handler.userHandler;
import model.user.User;
import utils.dbConnection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/receptionist-register")
public class ReceptionistRegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.sendRedirect("jsp/receptionist-register.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // Get form parameters
        String name = request.getParameter("name");
        String mobile = request.getParameter("mobile");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
        String pincode = request.getParameter("pincode");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String address = request.getParameter("address");

        // Password confirmation check
        if (!password.equals(confirmPassword)) {
            request.setAttribute("errorMessage", "Passwords do not match. Please try again.");
            response.sendRedirect("jsp/receptionist-register.jsp");
            return;
        }

        // Check database connection
        if (dbConnection.isDatabaseConnected()) {
            request.setAttribute("errorMessage", "Database connection is unavailable. Please try again later.");
            response.sendRedirect("jsp/receptionist-register.jsp");
            return;
        }
        // Create a User object
        User user = new User(name, mobile, email, password, pincode, city, state, address);

        // Handle registration
        userHandler registrationHandler = new userHandler(); // No need to pass the Connection
        boolean success = registrationHandler.register(user);

        if (success) {
            request.setAttribute("message", "Registration successful!");
            response.sendRedirect("jsp/receptionist-dashboard.jsp");
        } else {
            request.setAttribute("errorMessage", "Registration failed. Please try again.");
            response.sendRedirect("jsp/receptionist-register.jsp");

        }
    }
}