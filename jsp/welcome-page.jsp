<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Welcome</title>
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
    <style>
        :root {
            --blue-700: #0077cc;
            --blue-600: #0a84d2;
            --blue-100: #e6f2ff;
            --white: #ffffff;
            --text-dark: #2c3e50;
        }
    </style>
</head>
<body class="flex flex-col min-h-screen bg-blue-100 text-gray-800 font-sans">

<!-- Header -->
<header class="flex justify-between items-center bg-blue-700 text-white shadow-lg p-5">
    <div class="logo">
        <h1 class="text-3xl font-bold">E-Health Care Management System</h1>
        <p class="text-sm text-blue-300">A portal for e-health care</p>
    </div>
    <div class="flex gap-2">
        <button class="bg-blue-100 text-black px-4 py-2 rounded hover:bg-blue-200 transition duration-150">
            <a href="/patient-register">Register</a>
        </button>
        <button class="bg-blue-100 text-black px-4 py-2 rounded hover:bg-blue-200 transition duration-150">
            <a href="/login">Login</a>
        </button>
    </div>
</header>

<!-- Main Content -->
<main class="flex-grow flex justify-center items-center my-5">
    <img src="../images/telemedicine-ehealth-health-care-patient-health-c8ea02e4e6d52740a70ca9544cfe6623.png"  class="max-w-[90%] h-auto">
</main>

<!-- Footer -->
<footer class="bg-blue-700 text-white text-center py-4 shadow-lg">
    <p>&copy; 2025 E-Health Care Management System. All rights reserved.</p>
</footer>

</body>
</html>