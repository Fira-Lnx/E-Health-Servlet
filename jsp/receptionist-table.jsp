<%@ page import="model.receptionist.Receptionist" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Receptionist List</title>
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
<h2>Receptionists</h2>
<table>
  <tr>
    <th>Name</th>
    <th>Email</th>
    <th>Mobile</th>
    <th>Address</th>
    <th>password</th>

  </tr>
  <%
    // Fetch the list of receptionists from the request
    List<Receptionist> receptionists = (List<Receptionist>) request.getAttribute("receptionists");

    if (receptionists != null && !receptionists.isEmpty()) {
      for (Receptionist receptionist : receptionists) {
  %>
  <tr>
    <td><%= receptionist.getName() %></td>
    <td><%= receptionist.getEmail() %></td>
    <td><%= receptionist.getPhoneNumber() %></td>
    <td><%= receptionist.getAddress() %></td>
    <td><%= receptionist.getPassword() %></td>

  </tr>
  <%
    }
  } else {
  %>
  <tr>
    <td colspan="4">No receptionists found.</td>
  </tr>
  <%
    }
  %>
</table>
<footer style="position: relative; bottom: 0;">
  <p>&copy; 2025 E-Health Care Management System. All rights reserved.</p>
</footer>
</body>
</html>