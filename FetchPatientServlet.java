package Servlet;

import handler.userHandler;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import model.user.User;

@WebServlet("/fetch-patients")
public class FetchPatientServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        userHandler handler = new userHandler();
        List<User> patients = handler.fetchAllPatients();

        // Adding debug information
        if (patients != null) {
            System.out.println("Patients retrieved: " + patients.size());
        } else {
            System.out.println("No patients retrieved.");
        }

        // Set the patients list as a request attribute
        request.setAttribute("patients", patients);

        // Forward to the JSP page to display the patients
        RequestDispatcher dispatcher  = request.getRequestDispatcher("jsp/patient-table.jsp");
        dispatcher.forward(request,response);
    }
}