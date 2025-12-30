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

<!-- About Section -->
<section class="max-w-3xl mx-auto my-10 p-6 bg-white rounded-lg shadow-md">
    <h2 class="text-2xl text-blue-600 mb-4">About E-Health Care Management System</h2>
    <p class="mb-4">
        Our system helps patients and administrators manage appointments, access medical records,
        and communicate efficiently. Built for simplicity and security, it empowers healthcare through technology.
    </p>
    <p class="mb-4">
        E-Health Care Management System software has the capacity to help plan, organize, and manage resource pools
        and develop resource estimates. Depending on the sophistication of the software, it can manage estimation
        and planning, scheduling, cost control, and budget management, resource allocation, collaboration software,
        communication, decision-making, quality management, and documentation or administration systems.
        Today, numerous PC and browser-based project management software solutions exist, and they are finding
        their way into almost every type of business.
    </p>
    <p class="mb-4">
        The origins of project management software are rooted in the 1950s when Dupont Chemical collaborated
        with mainframe computer maker Remington Rand (Univac) to devise the Critical Path Method of network
        scheduling (CPM). This method was tested in 1958 with the construction of a major new chemical plant.
        In parallel, the US Navy working together with Lockheed Aerospace devised the automated Project Evaluation
        Review Technique (PERT) for the Polaris Missile program that ran on the IBM mainframe. Mainframe and mini
        computers dominated the project management software arena until the early 1980s when PC computers began
        to proliferate across business and government circles alike.
    </p>
    <p>
        Project planning software can be expected to provide information to various stakeholders and can be used
        to measure and justify the level of effort required to complete the project(s). Typical requirements might include:
    </p>
</section>

<!-- Footer -->
<footer class="bg-blue-700 text-white text-center py-4 shadow-lg">
    <p>&copy; 2025 E-Health Care Management System. All rights reserved.</p>
</footer>

</body>
</html>