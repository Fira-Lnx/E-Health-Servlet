<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add New Doctor</title>
    <link rel="stylesheet" href="../style/forms.css">
    <link rel="stylesheet" href="../style/doctors.css">
</head>
<body>
<section class="form-section">
<h1>Add New Doctor</h1>

    <%
        String errorMessage = (String) request.getAttribute("errorMessage");
        String message = (String) request.getAttribute("message");

        if (errorMessage != null && !errorMessage.isEmpty()) {
    %>
    <div class="error"><%= errorMessage %></div>
    <%
        }

        if (message != null && !message.isEmpty()) {
    %>
    <div class="success"><%= message %></div>
    <%
        }
    %>

<form action="/add-new-doctor" method="post">
    <label for="name">Name:</label>
    <input type="text" name="name" required><br>

    <label for="email">Email:</label>
    <input type="email" name="email" required><br>

    <label for="password">Password:</label>
    <input type="password" name="password" required><br>

    <label for="qualification">Qualification:</label>
    <input type="text" name="qualification" required><br>

    <label for="specialization">Specialization:</label>
    <input type="text" name="specialization" required><br>

    <label for="contact">Contact:</label>
    <input type="text" name="contact" required><br>

    <label for="address">Address:</label>
    <textarea name="address" required></textarea><br>

    <input type="submit" value="Add Doctor">
</form>
</section>
</body>
</html>