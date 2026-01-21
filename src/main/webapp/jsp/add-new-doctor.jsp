<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add New Doctor</title>
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
</head>
<body class="bg-gray-100">

<section class="max-w-lg mx-auto my-10 p-6 bg-white rounded-lg shadow-md">
    <h1 class="text-3xl font-semibold text-center mb-5">Add New Doctor</h1>

    <%
        String errorMessage = (String) request.getAttribute("errorMessage");
        String message = (String) request.getAttribute("message");

        if (errorMessage != null && !errorMessage.isEmpty()) {
    %>
    <div class="mb-4 text-red-600"><%= errorMessage %></div>
    <%
        }

        if (message != null && !message.isEmpty()) {
    %>
    <div class="mb-4 text-green-600"><%= message %></div>
    <%
        }
    %>

    <form action="/add-new-doctor" method="post" class="space-y-4">
        <div>
            <label for="name" class="block font-semibold">Name:</label>
            <input type="text" name="name" required class="border border-gray-300 rounded w-full p-2" />
        </div>

        <div>
            <label for="email" class="block font-semibold">Email:</label>
            <input type="email" name="email" required class="border border-gray-300 rounded w-full p-2" />
        </div>

        <div>
            <label for="password" class="block font-semibold">Password:</label>
            <input type="password" name="password" required class="border border-gray-300 rounded w-full p-2" />
        </div>

        <div>
            <label for="qualification" class="block font-semibold">Qualification:</label>
            <input type="text" name="qualification" required class="border border-gray-300 rounded w-full p-2" />
        </div>

        <div>
            <label for="specialization" class="block font-semibold">Specialization:</label>
            <input type="text" name="specialization" required class="border border-gray-300 rounded w-full p-2" />
        </div>

        <div>
            <label for="contact" class="block font-semibold">Contact:</label>
            <input type="text" name="contact" required class="border border-gray-300 rounded w-full p-2" />
        </div>

        <div>
            <label for="address" class="block font-semibold">Address:</label>
            <textarea name="address" required class="border border-gray-300 rounded w-full p-2" rows="4"></textarea>
        </div>

        <div class="flex justify-center">
            <input type="submit" value="Add Doctor" class="bg-blue-600 text-white px-4 py-2 rounded hover:bg-blue-700 transition duration-300" />
        </div>
    </form>
</section>

</body>
</html>