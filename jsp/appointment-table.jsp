<%@ page import="model.appointment.Appointment" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Appointment List</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 20px;
        }

        h2 {
            color: #333;
            text-align: center;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin: 0 auto;
            background-color: #fff;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
        }

        th, td {
            padding: 12px 15px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #007BFF;
            color: white;
        }

        tr:hover {
            background-color: #f1f1f1;
        }

        td {
            color: #555;
        }
    </style>
</head>
<body>
<h2>Appointments</h2>
<table>
    <tr>
        <th>Doctor</th>
        <th>Appointment Date</th>
        <th>Appointment Time</th>
        <th>Reason</th>
    </tr>
    <%
        // Fetch the list from the request
        List<Appointment> appointments = (List<Appointment>) request.getAttribute("appointments");

        if (appointments != null && !appointments.isEmpty()) {
            for (Appointment appointment : appointments) {
    %>
    <tr>
        <td><%= appointment.getDoctor() %></td>
        <td><%= appointment.getDate() %></td>
        <td><%= appointment.getTime() %></td>
        <td><%= appointment.getReason() %></td>
    </tr>
    <%
        }
    } else {
    %>
    <tr>
        <td colspan="4">No appointments found.</td>
    </tr>
    <%
        }
    %>
</table>
<footer style="position: relative;bottom: 0" >
    <p>&copy; 2025 E-Health Care Management System. All rights reserved.</p>
</footer>
</body>
</html>