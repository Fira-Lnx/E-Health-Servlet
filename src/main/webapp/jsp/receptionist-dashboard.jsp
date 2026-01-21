<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home - E-Health Care Management System</title>
    <!-- Link to your landing page CSS -->
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">

    <!-- Inline styles to demonstrate the requested layout -->
</head>
<body class="flex flex-col min-h-screen bg-blue-100 text-gray-800 font-sans">

<!-- Header -->
<header class="flex justify-between items-center bg-blue-700 text-white shadow-lg p-4">
    <div class="logo text-center">
        <h1 class="text-3xl font-bold">E-Health Care Management System</h1>
    </div>

    <!-- Navigation Bar on the Right -->
    <nav class="flex items-center gap-4">
        <ul class="flex space-x-7">
            <li><a href="/fetch-doctors" class="text-white hover:bg-white hover:bg-opacity-10 rounded px-2 py-1">Doctors</a></li>
            <li><a href="/fetch-patients" class="text-white hover:bg-white hover:bg-opacity-10 rounded px-2 py-1">Patients</a></li>
            <li><a href="/receptionist-book-appointment" class="text-white hover:bg-white hover:bg-opacity-10 rounded px-2 py-1">Book Appointment</a></li>
            <li><a href="/receptionist-login" class="text-white hover:bg-white hover:bg-opacity-10 rounded px-2 py-1">Logout</a></li>
        </ul>
    </nav>
</header>


<!-- About Section -->




</body>
</html>