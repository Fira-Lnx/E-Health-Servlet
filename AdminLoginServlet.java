package Servlet;

import handler.adminHandler; // Make sure you have a handler for admin
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

@WebServlet("/admin-login")
public class AdminLoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Redirect to admin login page
        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/admin-login.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        // Check if email or password is missing
        if (name == null || password == null || name.isEmpty() || password.isEmpty()) {
            request.setAttribute("error", "Email and password are required!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/admin-login.jsp");
            dispatcher.forward(request, response);
            return;
        }



        Connection connection = null; // Declare connection
        adminHandler handler = new adminHandler(); // Assuming you have a handler for admin

        try {
            connection = dbConnection.getConnection(); // Obtain a connection

            // Validate the admin's credentials using the handler
            boolean loginSuccess = handler.login(name, password); // Implement this in your adminHandler

            if (loginSuccess) {
                HttpSession session = request.getSession();
                session.setAttribute("adminEmail", name); // Store email or admin object in session
                response.sendRedirect("jsp/admin-dashboard.jsp");
            } else {
                request.setAttribute("error", "Invalid email or password!");
                RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/admin-login.jsp");
                dispatcher.forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "An error occurred while trying to login.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/admin-login.jsp");
            dispatcher.forward(request, response);
        } finally {
            dbConnection.closeConnection(connection); // Close the connection to prevent leaks
        }
    }
}