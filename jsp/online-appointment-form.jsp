<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>All Appointments</title>
    <link rel="stylesheet" href="../style/doctors.css" />
    <link rel="stylesheet" href="../style/forms.css" />
    <style>
        /* Basic styles for dropdown */
        .dropdown {
            position: relative;
            display: inline-block;
        }

        .dropdown .dropdown-content {
            display: none;
            position: absolute;
            background-color: #f9f9f9;
            min-width: 160px;
            box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
            z-index: 1;
        }

        .dropdown:hover .dropdown-content {
            display: block;
        }

        .dropdown-content a {
            color: black;
            padding: 12px 16px;
            text-decoration: none;
            display: block;
        }

        .dropdown-content a:hover {
            background-color: #f1f1f1;
        }

        /* Add some margin to the search bar */
        .search-bar {
            margin-left: auto;
        }
    </style>
</head>
<body>
<!-- Header -->
<header class="header">
    <div class="logo">
        <h1>E-Health Care Management System</h1>
        <p class="subtitle">A portal for e-health care</p>
    </div>
    <nav class="main-nav">
        <ul>
            <li><a href="/fetch-doctors">All Doctors</a></li>
            <li><a href="/online-book-appointment">Book Appointment</a></li>
            <li><a href="/login">Logout</a></li>
            <li><a href="/contact-us">Contact Us</a></li>
            <!-- Search Bar inside the nav list -->
            <li>
            </li>
        </ul>
    </nav>
</header>

<!-- Appointment Booking Form -->
<section class="form-section">
    <h2>Book an Appointment</h2>
    <% if (request.getAttribute("errorMessage") != null) { %>
    <p style="color: red;"><%= request.getAttribute("errorMessage") %></p>
    <% } %>
    <form id="appointmentForm" action="/online-book-appointment" method="post">
        <label for="doctor">Select Doctor</label>
        <select id="doctor" name="doctor" required>
            <option value="">-- Choose a doctor --</option>
            <option value="Dr. Smith">Dr. Smith</option>
            <option value="Dr. Johnson">Dr. Johnson</option>
            <!-- Add more doctors as needed -->
        </select>

        <label for="date">Date</label>
        <input type="date" id="date" name="date" required />

        <label for="time">Time</label>
        <input type="time" id="time" name="time" required />

        <label for="reason">Reason for Appointment</label>
        <textarea id="reason" name="reason" required></textarea>

        <button type="submit" class="book-btn">Book Appointment</button>
    </form>
</section>

<footer style="position: absolute;bottom: 0" >
    <p>&copy; 2025 E-Health Care Management System. All rights reserved.</p>
</footer>
</body>
</html>