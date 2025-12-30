<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Home - E-Health Care Management System</title>
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
</head>
<body class="flex flex-col min-h-screen bg-blue-100 text-gray-800 font-sans">

<!-- Header -->
<header class="flex justify-between items-center bg-blue-700 text-white shadow-lg p-4">
    <div class="logo text-center">
        <h1 class="text-3xl font-bold">E-Health Care Management System</h1>
    </div>

    <!-- Navigation Bar -->
    <nav class="flex items-center gap-4">
        <ul class="flex space-x-7">
            <li><a href="/fetch-doctors" class="text-white hover:bg-white hover:bg-opacity-10 rounded px-2 py-1">All Doctors</a></li>
            <li><a href="/online-book-appointment" class="text-white hover:bg-white hover:bg-opacity-10 rounded px-2 py-1">Book Appointment</a></li>
            <li><a href="/patient-login" class="text-white hover:bg-white hover:bg-opacity-10 rounded px-2 py-1">Logout</a></li>
            <li><a href="/contact-us" class="text-white hover:bg-white hover:bg-opacity-10 rounded px-2 py-1">Contact Us</a></li>
        </ul>
    </nav>
</header>

<!-- Hero Section -->
<section class="text-center py-6">
    <img src="../images/telemedicine-ehealth-health-care-patient-health-c8ea02e4e6d52740a70ca9544cfe6623.png" alt="Telemedicine" class="mx-auto" />
</section>



<!-- Footer -->
<footer class="bg-blue-700 text-white text-center py-4 mt-10 shadow-lg">
    <p>&copy; 2025 E-Health Care Management System. All rights reserved.</p>
</footer>

</body>
</html>