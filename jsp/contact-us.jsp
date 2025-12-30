<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Contact Us</title>
    <link rel="stylesheet" href="../style/contact.css" />
    <link rel="stylesheet" href="../style/forms.css"/>
    <link rel="stylesheet" href="../style/index.css"/>
</head>
<body>
<!-- Header -->
<header class="header">
    <div class="logo">
        <h1>E-Health Care Management System</h1>
        <p class="subtitle">A portal for e-health care</p>
    </div>
    <nav class="main-nav">
        <ul>
            <li><a href="/fetch-doctors">All Doctors</a></li>
            <li><a href="/online-book-appointment">Book Appointment</a></li>
            <li><a href="/login">Logout</a></li>
            <li><a href="/contact-us">Contact Us</a></li>
            <!-- Search Bar inside the nav list -->
            <li>
            </li>
        </ul>
    </nav>
</header>

<!-- Contact Form -->
<section class="form-section">
    <h2>Contact Us</h2>
    <p>If you have any questions, feedback, or need support, please reach out to us using the form below.</p>
    <form id="contactForm" action="/contact-us" method="post">
        <label for="name">Full Name *</label>
        <input type="text" id="name" name="name" required />

        <label for="email">Email Address *</label>
        <input type="email" id="email" name="email" required />

        <label for="message">Message *</label>
        <textarea id="message" name="message" rows="5" required></textarea>

        <label for="subject">Subject *</label>
        <input type="text" id="subject" name="subject" required />


        <div class="form-buttons">
            <button type="submit" class="book-btn">Send Message</button>
            <button type="reset" class="book-btn" style="background-color: #ccc; color: #333;">Clear</button>
        </div>
    </form>

    <h3 style="margin-top: 40px;">Other Ways to Reach Us</h3>
    <p><strong>Email:</strong> support@ehealth.com</p>
    <p><strong>Phone:</strong> +251-900-123-456</p>
    <p><strong>Address:</strong> Adama, Oromia, Ethiopia</p>
</section>

<!-- Footer -->
<footer style="position: relative;bottom: 0" >
    <p>&copy; 2025 E-Health Care Management System. All rights reserved.</p>
</footer>
</body>
</html>