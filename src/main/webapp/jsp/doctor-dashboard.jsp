<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home - E-Health Care Management System</title>
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
</head>
<body class="flex flex-col min-h-screen bg-blue-100 text-gray-800 font-sans">

<!-- Header -->
<header class="bg-blue-600 text-white">
    <section class="text-center py-5">
        <div class="logo">
            <h1 class="text-4xl font-bold">E-Health Care Management System</h1>
            <p class="subtitle text-lg mt-1">A portal for e-health care</p>
        </div>
    </section>
    <!-- Navigation Bar -->
    <nav class="flex justify-center items-center py-2">
        <ul class="flex space-x-7">
            <li><a href="/fetch-appointments" class="text-white hover:bg-white hover:bg-opacity-10 rounded px-3 py-2 transition">Appointments</a></li>
            <li><a href="/fetch-patients" class="text-white hover:bg-white hover:bg-opacity-10 rounded px-3 py-2 transition">Patients</a></li>
            <li><a href="/change-doctor-password" class="text-white hover:bg-white hover:bg-opacity-10 rounded px-3 py-2 transition">Change Password</a></li>
            <li><a href="/login" class="text-white hover:bg-white hover:bg-opacity-10 rounded px-3 py-2 transition">Logout</a></li>
        </ul>
    </nav>
</header>



</body>
</html>