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
<header class="bg-blue-600 text-white">
    <section class="text-center py-5">
        <div class="logo">
            <h1 class="text-4xl font-bold">E-Health Care Management System</h1>
            <p class="subtitle text-lg mt-1">A portal for e-health care</p>
        </div>
    </section>

    <!-- Navigation Bar -->
    <nav class="bg-blue-500">
        <ul class="flex justify-center space-x-4 py-3">
            <li><a href="/fetch-doctors" class="text-white hover:underline">Doctors</a></li>
            <li><a href="/fetch-patients" class="text-white hover:underline">Patients</a></li>
            <li><a href="/fetch-receptionist" class="text-white hover:underline">Receptionist</a></li>
            <li><a href="/fetch-appointments" class="text-white hover:underline">Appointments</a></li>
            <li><a href="/add-new-doctor" class="text-white hover:underline">+ New Doctor</a></li>
            <li><a href="/change-admin-password" class="text-white hover:underline">Change Password</a></li>
            <li><a href="/login" class="text-white hover:underline">Logout</a></li>
        </ul>
    </nav>
</header>
</body>
</html>