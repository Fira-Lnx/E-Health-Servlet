<%@ page import="model.doctor.Doctor" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Doctor List</title>
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
<h2>Doctors</h2>
<table>
    <tr>
        <th>Name</th>
        <th>Email</th>
        <th>Contact</th>
        <th>Address</th>
        <th>Qualification</th>
        <th>Specialization</th>
    </tr>
    <%
        // Fetch the list from the request
        List<Doctor> doctors = (List<Doctor>) request.getAttribute("doctors");

        if (doctors != null && !doctors.isEmpty()) {
            for (Doctor doctor : doctors) {
    %>
    <tr>
        <td><%= doctor.getName() %></td>
        <td><%= doctor.getEmail() %></td>
        <td><%= doctor.getContact() %></td>
        <td><%= doctor.getAddress() %></td>
        <td><%= doctor.getQualification() %></td>
        <td><%= doctor.getSpecialization() %></td>

    </tr>
    <%
        }
    } else {
    %>
    <tr>
        <td colspan="4">No doctors found.</td>
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