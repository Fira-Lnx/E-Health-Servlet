package Servlet;

import handler.receptionistHandler; // Make sure this handler exists
import model.receptionist.Receptionist; // Ensure you have a Receptionist model
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/fetch-receptionist")
public class FetchReceptionistServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        receptionistHandler handler = new receptionistHandler();
        List<Receptionist> receptionists = handler.fetchAllReceptionists(); // Implement this method in your handler

        request.setAttribute("receptionists", receptionists); // Store receptionists in request attribute

        // Forward to the view page
        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/receptionist-table.jsp");
        dispatcher.forward(request, response);
    }
}