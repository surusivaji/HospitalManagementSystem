<div align="center">
    <h1>🏥 Hospital Management System</h1>
    <p><strong>A web application to manage hospital operations efficiently for users, doctors, and administrators.</strong></p>
</div>

<hr>

<h2>📖 Project Features</h2>
<ul>
    <li>Built with <strong>Spring MVC, Spring JPA, and Spring Boot</strong>.</li>
    <li>Frontend designed using <strong>HTML, CSS, JavaScript, and Bootstrap</strong>.</li>
    <li>Database powered by <strong>MySQL</strong>.</li>
    <li>Role-based access for <strong>Users, Doctors, and Admins</strong>.</li>
</ul>

<hr>

<h2>👤 User Functionalities</h2>
<ul>
    <li>📅 Add appointments.</li>
    <li>🧾 View patient details.</li>
    <li>🔒 Change their password.</li>
</ul>

<h2>🔑 Admin Functionalities</h2>
<ul>
    <li>➕ Add, ✏️ Edit, 👁️ View, and ❌ Remove doctors.</li>
    <li>➕ Add specialists.</li>
    <li>📋 View patient details.</li>
    <li>📊 View overall statistics (doctors, appointments, specialists, users).</li>
</ul>

<h2>🩺 Doctor Functionalities</h2>
<ul>
    <li>👁️ View patient details.</li>
    <li>✏️ Edit their profile.</li>
    <li>💊 Provide prescriptions.</li>
    <li>📊 View counts of doctors and patients.</li>
</ul>

<hr>

<h2>📦 Project Structure</h2>
<ul>
    <li><strong>Frontend:</strong> HTML, CSS, JavaScript, and Bootstrap for responsive UI.</li>
    <li><strong>Backend:</strong> Spring Boot for backend logic, Spring MVC for handling requests.</li>
    <li><strong>Database:</strong> MySQL for secure data storage.</li>
</ul>

<hr>

<h2>🚀 Getting Started</h2>

<h3>Prerequisites</h3>
<ul>
    <li>Java 8 or above</li>
    <li>Spring Boot</li>
    <li>MySQL</li>
    <li>Maven</li>
</ul>

<h3>Steps to Run</h3>
<ol>
    <li>Clone the repository:
        <pre><code>git clone https://github.com/yourusername/hospital-management-system.git</code></pre>
    </li>
    <li>Navigate to the project directory:
        <pre><code>cd hospital-management-system</code></pre>
    </li>
    <li>Configure the database in <code>application.properties</code>:
        <pre><code>
spring.datasource.url=jdbc:mysql://localhost:3306/hospital_db
spring.datasource.username=your_username
spring.datasource.password=your_password
        </code></pre>
    </li>
    <li>Run the application:
        <pre><code>mvn spring-boot:run</code></pre>
    </li>
    <li>Open your browser and navigate to:
        <pre><code>http://localhost:8080</code></pre>
    </li>
</ol>

<hr>

<h2>📊 Statistics</h2>
<ul>
    <li>Total Doctors</li>
    <li>Total Appointments</li>
    <li>Total Specialists</li>
    <li>Total Users</li>
</ul>

<hr>

<h2>🔍 How It Works</h2>
<p>The Hospital Management System operates seamlessly to handle various roles and their respective functionalities. Here's how it works:</p>

<h3>For Users</h3>
<ol>
    <li><strong>Registration:</strong> New users register with their details to access the system.</li>
    <li><strong>Login:</strong> Users log in with their credentials.</li>
    <li><strong>Book Appointments:</strong> Users can schedule appointments with available doctors.</li>
    <li><strong>View Details:</strong> Users can view their appointment history and other relevant data.</li>
    <li><strong>Change Password:</strong> Users can update their passwords securely.</li>
</ol>

<h3>For Doctors</h3>
<ol>
    <li><strong>Login:</strong> Doctors log in to access their profiles.</li>
    <li><strong>View Patients:</strong> Doctors can view the details of patients assigned to them.</li>
    <li><strong>Prescriptions:</strong> Doctors can provide and update prescriptions for patients.</li>
    <li><strong>Manage Profile:</strong> Doctors can update their profile details if needed.</li>
</ol>

<h3>For Admins</h3>
<ol>
    <li><strong>Login:</strong> Admins log in with their credentials.</li>
    <li><strong>Manage Doctors:</strong> Admins can add, edit, view, and remove doctors from the system.</li>
    <li><strong>Manage Specialists:</strong> Admins can add or edit specialist categories.</li>
    <li><strong>View Statistics:</strong> Admins have access to a dashboard showing overall hospital statistics.</li>
</ol>
<hr>

<h2>💡 Future Enhancements</h2>
<ul>
    <li>Notification system for upcoming appointments.</li>
    <li>Email integration for password recovery.</li>
    <li>Analytics dashboard for hospital performance insights.</li>
</ul>

<hr>

<h2>🤝 Contributing</h2>
<p>Contributions are welcome! Please fork the repository and submit a pull request.</p>

<hr>

<h2>🏷️ License</h2>
<p>This project is licensed under the <a href="LICENSE">MIT License</a>.</p>

<hr>

<h2>👨‍💻 Developed By</h2>
<p><strong>Suru Sivaji</strong></p>
<p>Connect with me on <a href="https://linkedin.com/in/your-linkedin">LinkedIn</a> or check out my other projects on <a href="https://github.com/yourusername">GitHub</a>.</p>

