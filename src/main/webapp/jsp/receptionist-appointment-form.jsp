<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>All Appointments</title>
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
</head>
<body class="bg-gray-100 text-gray-800 font-sans">

<!-- Header -->
<header class="flex justify-between items-center bg-blue-700 text-white p-4 shadow-md">
    <div class="text-center">
        <h1 class="text-3xl">E-Health Care Management System</h1>
        <p class="text-sm text-blue-200">A portal for e-health care</p>
    </div>
    <nav>
        <ul class="flex space-x-4">
            <li><a href="patient-dashboard.jsp" class="hover:underline">Home</a></li>
            <li><a href="fetch-doctors" class="hover:underline">All Doctors</a></li>
            <li><a href="fetch-patients" class="hover:underline">All Patients</a></li>
            <li><a href="receptionist-book-appointment" class="text-blue-300">Book Appointment</a></li>
            <li><a href="login.jsp" class="hover:underline">Logout</a></li>
            <li><a href="contact-us" class="hover:underline">Contact Us</a></li>
        </ul>
    </nav>
</header>

<!-- Appointment Booking Form -->
<section class="max-w-2xl mx-auto my-8 p-5 bg-white rounded-lg shadow">
    <h2 class="text-center text-2xl font-semibold mb-4">Book an Appointment</h2>
    <% if (request.getAttribute("errorMessage") != null) { %>
    <p class="text-red-600 text-center mb-4"><%= request.getAttribute("errorMessage") %></p>
    <% } %>
    <form id="appointmentForm" action="/receptionist-book-appointment" method="post" class="space-y-4">
        <div>
            <label for="doctor" class="block font-semibold">Enter doctor</label>
            <input type="text" id="doctor" name="doctor"/>
        </div>

        <div>
            <label for="date" class="block font-semibold">Date</label>
            <input type="date" id="date" name="date" required class="border rounded w-full p-2" />
        </div>

        <div>
            <label for="time" class="block font-semibold">Time</label>
            <input type="time" id="time" name="time" required class="border rounded w-full p-2" />
        </div>

        <div>
            <label for="reason" class="block font-semibold">Reason for Appointment</label>
            <textarea id="reason" name="reason" required class="border rounded w-full p-2" rows="3"></textarea>
        </div>

        <button type="submit" class="w-full bg-blue-600 text-white p-2 rounded hover:bg-blue-700 transition">Book Appointment</button>
    </form>
</section>



</body>
</html>