<%@ page import="model.user.User" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Patient List</title>
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
<h2>Patients</h2>
<table>
    <tr>
        <th>Name</th>
        <th>Mobile</th>
        <th>Email</th>
        <th>Pincode</th>
        <th>City</th>
        <th>State</th>
        <th>Address</th>
    </tr>
    <%
        // Fetch the list from the request
        List<User> patients = (List<User>) request.getAttribute("patients");

        if (patients != null && !patients.isEmpty()) {
            for (User patient : patients) {
    %>
    <tr>
        <td><%= patient.getName() %></td>
        <td><%= patient.getMobile() %></td>
        <td><%= patient.getEmail() %></td>
        <td><%= patient.getPincode() %></td>
        <td><%= patient.getCity() %></td>
        <td><%= patient.getState() %></td>
        <td><%= patient.getAddress() %></td>
    </tr>
    <%
        }
    } else {
    %>
    <tr>
        <td colspan="7">No patients found.</td>
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