package Servlet;

import handler.doctorHandler;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import model.doctor.Doctor;

@WebServlet("/fetch-doctors")
public class FetchDoctorServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doctorHandler handler = new doctorHandler();
        List<Doctor> doctors = handler.fetchAllDoctors();

        // Set the doctors list as a request attribute
        request.setAttribute("doctors", doctors);

        // Forward to the JSP page to display the doctors
        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/doctors-table.jsp"); // Adjust the path as necessary
        dispatcher.forward(request, response);
    }
}