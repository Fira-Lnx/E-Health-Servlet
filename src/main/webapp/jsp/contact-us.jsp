<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Contact Us</title>
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
</head>
<body class="bg-gray-100 text-gray-800 font-sans">

<!-- Header -->
<header class="flex justify-between items-center bg-blue-700 text-white p-4 shadow-md">
    <div class="text-center">
        <h1 class="text-3xl">E-Health Care Management System</h1>
        <p class="text-sm text-blue-200">A portal for e-health care</p>
    </div>
    <nav>
        <ul class="flex space-x-4">
            <li><a href="/fetch-doctors" class="hover:underline">All Doctors</a></li>
            <li><a href="/online-book-appointment" class="hover:underline">Book Appointment</a></li>
            <li><a href="/login" class="hover:underline">Logout</a></li>
            <li><a href="/contact-us" class="hover:underline">Contact Us</a></li>
        </ul>
    </nav>
</header>

<!-- Contact Form -->
<section class="max-w-2xl mx-auto my-8 p-5 bg-white rounded-lg shadow">
    <h2 class="text-center text-2xl font-semibold mb-4">Contact Us</h2>
    <p class="text-center mb-4">If you have any questions, feedback, or need support, please reach out to us using the form below.</p>
    <form id="contactForm" action="/contact-us" method="post" class="space-y-4">
        <div>
            <label for="name" class="block font-semibold">Full Name *</label>
            <input type="text" id="name" name="name" required class="border rounded w-full p-2" />
        </div>

        <div>
            <label for="email" class="block font-semibold">Email Address *</label>
            <input type="email" id="email" name="email" required class="border rounded w-full p-2" />
        </div>

        <div>
            <label for="subject" class="block font-semibold">Subject *</label>
            <input type="text" id="subject" name="subject" required class="border rounded w-full p-2" />
        </div>

        <div>
            <label for="message" class="block font-semibold">Message *</label>
            <textarea id="message" name="message" rows="5" required class="border rounded w-full p-2"></textarea>
        </div>

        <div class="flex justify-between mt-4">
            <button type="submit" class="bg-blue-600 text-white px-4 py-2 rounded hover:bg-blue-700 transition">Send Message</button>
            <button type="reset" class="bg-gray-300 text-gray-800 px-4 py-2 rounded">Clear</button>
        </div>
    </form>

    <h3 class="mt-8 font-semibold">Other Ways to Reach Us</h3>
    <p><strong>Email:</strong> support@ehealth.com</p>
    <p><strong>Phone:</strong> +251-900-123-456</p>
    <p><strong>Address:</strong> Adama, Oromia, Ethiopia</p>
</section>



</body>
</html>