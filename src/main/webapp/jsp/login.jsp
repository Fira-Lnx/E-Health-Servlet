<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Login</title>
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
</head>
<body class="flex flex-col min-h-screen bg-blue-100 text-gray-800 font-sans">

<!-- Header -->
<header class="bg-blue-600 text-white text-center py-5">
    <div class="logo">
        <h1 class="text-4xl font-bold">E-Health Care Management System</h1>
        <p class="subtitle text-lg mt-1">A portal for E-health care</p>
    </div>
</header>

<!-- Login Section -->
<section class="max-w-lg mx-auto my-10 p-6 bg-white rounded-lg shadow-md">
    <h2 class="text-2xl mb-4 text-center">Login to Your Account</h2>
    <div class="flex justify-center space-x-4 mt-4">
        <a href="/patient-login" class="bg-blue-600 text-white px-4 py-2 rounded hover:bg-blue-700 transition duration-300">Patient</a>
        <a href="/receptionist-login" class="bg-blue-600 text-white px-4 py-2 rounded hover:bg-blue-700 transition duration-300">Receptionist</a>
        <a href="/doctor-login" class="bg-blue-600 text-white px-4 py-2 rounded hover:bg-blue-700 transition duration-300">Doctor</a>
        <a href="/admin-login" class="bg-blue-600 text-white px-4 py-2 rounded hover:bg-blue-700 transition duration-300">Admin</a>
    </div>
</section>



</body>
</html>