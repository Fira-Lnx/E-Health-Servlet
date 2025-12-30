<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Patient Registration</title>
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
</head>
<body class="bg-blue-100 text-gray-800 font-sans leading-relaxed">

<!-- Header -->
<header class="flex justify-between bg-blue-700 text-white shadow">
    <div class="text-center p-4">
        <h1 class="text-3xl">E-Health Care Management System</h1>
        <p class="text-sm text-blue-200">A portal for e-health care</p>
    </div>
</header>

<!-- Registration Form -->
<section class="max-w-2xl mx-auto my-8 p-5 bg-white rounded-lg shadow">
    <h2 class="text-center text-xl font-semibold mb-4">Patient Registration Form</h2>
    <form id="registerForm" action="/patient-register" method="post">

        <!-- Personal Details -->
        <h3 class="font-semibold mt-4">Personal Details</h3>
        <label for="name" class="block mt-2">Name*</label>
        <input type="text" id="name" name="name" required class="border rounded w-full p-2" />

        <label for="mobile" class="block mt-2">Mobile*</label>
        <input type="tel" id="mobile" name="mobile" required class="border rounded w-full p-2" />

        <label for="email" class="block mt-2">Email*</label>
        <input type="email" id="email" name="email" required class="border rounded w-full p-2" />

        <label for="password" class="block mt-2">Password*</label>
        <input type="password" id="password" name="password" required class="border rounded w-full p-2" />

        <label for="confirmPassword" class="block mt-2">Confirm Password*</label>
        <input type="password" id="confirmPassword" name="confirmPassword" required class="border rounded w-full p-2" />

        <!-- Address Details -->
        <h3 class="font-semibold mt-4">Address Details</h3>
        <label for="pincode" class="block mt-2">Pincode*</label>
        <input type="text" id="pincode" name="pincode" required class="border rounded w-full p-2" />

        <label for="city" class="block mt-2">City*</label>
        <input type="text" id="city" name="city" required class="border rounded w-full p-2" />

        <label for="state" class="block mt-2">State*</label>
        <select id="state" name="state" required class="border rounded w-full p-2">
            <option value="">Please Select</option>
            <option value="Oromia">Oromia</option>
            <option value="Addis Ababa">Addis Ababa</option>
            <option value="Amhara">Amhara</option>
            <option value="SNNPR">SNNPR</option>
            <option value="Tigray">Tigray</option>
        </select>

        <label for="address" class="block mt-2">Address*</label>
        <textarea id="address" name="address" rows="3" required class="border rounded w-full p-2"></textarea>

        <div class="flex justify-between mt-4">
            <button type="submit" class="bg-blue-600 text-white px-4 py-2 rounded">Save Patient</button>
            <button type="reset" class="bg-gray-300 text-gray-800 px-4 py-2 rounded">Reset Form</button>
        </div>
    </form>
</section>

<!-- Footer -->
<footer class="bg-blue-700 text-white text-center p-4 mt-8 shadow">
    <p>&copy; 2025 E-Health Care Management System. All rights reserved.</p>
</footer>

</body>
</html>