<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Change Password</title>
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
</head>
<body>
<section class="max-w-lg mx-auto my-10 p-6 bg-white rounded-lg shadow-md">
    <form action="${pageContext.request.contextPath}/change-admin-password" method="post">
        <h2 class="text-2xl mb-4 text-center">Change Password</h2>
        <div class="mb-4">
            <label for="email" class="block mb-1">First Name*</label>
            <input type="text" id="email" name="name" required class="border border-gray-300 rounded px-3 py-2 w-full" />
        </div>
        <div class="mb-4">
            <label for="oldPassword" class="block mb-1">Old Password*</label>
            <input type="password" id="password" name="oldPassword" required class="border border-gray-300 rounded px-3 py-2 w-full" />
        </div>
        <div class="mb-4">
            <label for="newPassword" class="block mb-1">New Password*</label>
            <input type="password" id="password" name="newPassword" required class="border border-gray-300 rounded px-3 py-2 w-full" />
        </div>

        <div class="flex justify-between">
            <button type="submit" class="bg-blue-600 text-white px-4 py-2 rounded hover:bg-blue-700 transition duration-300">Submit</button>
            <button type="reset" class="bg-gray-300 text-gray-800 px-4 py-2 rounded hover:bg-gray-400 transition duration-300">Cancel</button>
        </div></form>
</section>
<%
    String message = (String) request.getAttribute("message");
    String error = (String) request.getAttribute("error");

    if (message != null && !message.isEmpty()) {
%>
<p><%= message %></p>
<%
    }

    if (error != null && !error.isEmpty()) {
%>
<p><%= error %></p>
<%
    }
%>
</section>
</body>
</html>