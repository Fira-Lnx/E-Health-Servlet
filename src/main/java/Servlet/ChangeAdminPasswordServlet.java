package Servlet;

import handler.adminHandler;
import handler.doctorHandler; // Make sure this handler exists
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/change-admin-password")
public class ChangeAdminPasswordServlet extends HttpServlet {

    private final adminHandler handler = new adminHandler();

    // Handle GET requests
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Forward to a page with the change password form
        request.getRequestDispatcher("jsp/change-admin-password.jsp").forward(request, response);
    }

    // Handle POST requests
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String oldPassword = request.getParameter("oldPassword");
        String newPassword = request.getParameter("newPassword");

        // Execute password change
        boolean success = handler.changePassword(email, oldPassword, newPassword);

        if (success) {
            request.setAttribute("message", "Password changed successfully.");
        } else {
            request.setAttribute("error", "Failed to change password. Please check your old password.");
        }

        // Forward the request to a confirmation page or back to the profile
        request.getRequestDispatcher("jsp/admin-dashboard.jsp").forward(request, response);
    }
}