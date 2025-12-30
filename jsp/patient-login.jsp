<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Receptionist Login</title>
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
</head>
<body class="flex flex-col min-h-screen bg-blue-100 text-gray-800 font-sans">

<!-- Header -->
<header class="bg-blue-600 text-white text-center py-5">
    <div class="logo">
        <h1 class="text-4xl font-bold">E-Health Care Management System</h1>
        <p class="subtitle text-lg mt-1">A portal for e-health care</p>
    </div>
</header>

<!-- Patient Login Form -->
<section class="max-w-lg mx-auto my-10 p-6 bg-white rounded-lg shadow-md">
    <h2 class="text-2xl mb-4 text-center">Patients Login Form</h2>
    <form action="/patient-login" method="post">
        <div class="mb-4">
            <label for="firstName" class="block mb-1">First Name*</label>
            <input type="text" id="firstName" name="firstName" required class="border border-gray-300 rounded px-3 py-2 w-full" />
        </div>
        <div class="mb-4">
            <label for="password" class="block mb-1">Password*</label>
            <input type="password" id="password" name="password" required class="border border-gray-300 rounded px-3 py-2 w-full" />
        </div>

        <div class="flex justify-between">
            <button type="submit" class="bg-blue-600 text-white px-4 py-2 rounded hover:bg-blue-700 transition duration-300">Login</button>
            <button type="reset" class="bg-gray-300 text-gray-800 px-4 py-2 rounded hover:bg-gray-400 transition duration-300">Cancel</button>
        </div>
    </form>
</section>

<!-- Footer -->
<footer class="bg-blue-600 text-white text-center py-2 mt-10">
    <p>&copy; 2025 E-Health Care Management System. All rights reserved.</p>
</footer>

</body>
</html>