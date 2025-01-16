<div align="center">
    <h1>🏥 Hospital Management System</h1>
    <p><strong>A web application to manage hospital operations efficiently for users, doctors, and administrators.</strong></p>
</div>

<hr>

<h2>📖 Project Features</h2>
<p><i>⚙️</i> Built with <strong>Spring MVC, Spring JPA, and Spring Boot</strong>.</p>
<p><i>🎨</i> Frontend designed using <strong>HTML, CSS, JavaScript, and Bootstrap</strong>.</p>
<p><i>💾</i> Database powered by <strong>MySQL</strong>.</p>
<p><i>🔒</i> Role-based access for <strong>Users, Doctors, and Admins</strong>.</p>

<hr>

<h2>👤 User Functionalities</h2>
<p><i>📅</i> Add appointments.</p>
<p><i>🧾</i> View patient details.</p>
<p><i>🔑</i> Change their password.</p>

<h2>🔑 Admin Functionalities</h2>
<p><i>➕</i> Add, <i>✏️</i> Edit, <i>👁️</i> View, and <i>❌</i> Remove doctors.</p>
<p><i>➕</i> Add specialists.</p>
<p><i>📋</i> View patient details.</p>
<p><i>📊</i> View overall statistics (doctors, appointments, specialists, users).</p>

<h2>🩺 Doctor Functionalities</h2>
<p><i>👁️</i> View patient details.</p>
<p><i>✏️</i> Edit their profile.</p>
<p><i>💊</i> Provide prescriptions.</p>
<p><i>📊</i> View counts of doctors and patients.</p>

<hr>

<h2>📸 Project Screenshots</h2>
<p>Below are some attractive screenshots of the application:</p>

<!-- Image Gallery -->
<div>
    <h3>🏠 Index Page</h3>
    <img src="index.png" alt="Index Page" width="70%">
</div>

<div>
    <h3>🔑 User Login Page</h3>
    <img src="userlogin.png" alt="User Login Page" width="70%">
</div>

<div>
    <h3>📝 User Registration Page</h3>
    <img src="registration.png" alt="User Registration Page" width="70%">
</div>

<div>
    <h3>👤 User Home Page</h3>
    <img src="userhomepage.png" alt="User Home Page" width="70%">
</div>

<div>
    <h3>📅 Appointment Page</h3>
    <img src="appointmentpage.png" alt="Appointment Page" width="70%">
</div>

<div>
    <h3>📋 Appointment List Page</h3>
    <img src="appointmentslist.png" alt="Appointment List Page" width="70%">
</div>

<div>
    <h3>🔑 Change Password Page</h3>
    <img src="changepassword.png" alt="Change Password Page" width="70%">
</div>

<div>
    <h3>🚪 User Logout Page</h3>
    <img src="userlogout.png" alt="User Logout Page" width="70%">
</div>

<div>
    <h3>👨‍⚖️ Admin Login Page</h3>
    <img src="adminlogin.png" alt="Admin Login Page" width="70%">
</div>

<div>
    <h3>🏠 Admin Home Page</h3>
    <img src="adminhomepage.png" alt="Admin Home Page" width="70%">
</div>

<div>
    <h3>🩺 Admin Doctor Dashboard</h3>
    <img src="admindoctorsdashboard.png" alt="Admin Doctor Dashboard" width="70%">
</div>

<div>
    <h3>🖊️ Update Doctor Information</h3>
    <img src="updatedoctor.png" alt="Update Doctor Page" width="70%">
</div>

<div>
    <h3>❌ Remove Doctor Page</h3>
    <img src="removedoctor.png" alt="Remove Doctor Page" width="70%">
</div>

<div>
    <h3>👩‍⚕️ Doctor Page</h3>
    <img src="allpatientdetails.png" alt="All Patient Details" width="70%">
</div>

<div>
    <h3>🚪 Admin Logout Page</h3>
    <img src="adminlogout.png" alt="Admin Logout Page" width="70%">
</div>

<div>
    <h3>👨‍⚕️ Doctor Login Page</h3>
    <img src="doctorlogin.png" alt="Doctor Login Page" width="70%">
</div>

<div>
    <h3>🏠 Doctor Home Page</h3>
    <img src="doctorhomepage.png" alt="Doctor Home Page" width="70%">
</div>

<div>
    <h3>👩‍⚕️ Patient Details Page</h3>
    <img src="patientdetails.png" alt="Patient Details Page" width="70%">
</div>

<div>
    <h3>📝 Doctor Comment Page</h3>
    <img src="doctorcomment.png" alt="Doctor Comment Page" width="70%">
</div>

<div>
    <h3>🚪 Doctor Logout Page</h3>
    <img src="doctorlogout.png" alt="Doctor Logout Page" width="70%">
</div>

<hr>

<h2>🚀 Getting Started</h2>

<h3>🛠️ Prerequisites</h3>
<p><i>☕</i> Java 8 or above</p>
<p><i>⚙️</i> Spring Boot</p>
<p><i>💾</i> MySQL</p>
<p><i>🔧</i> Maven</p>

<h3>⚡ Steps to Run</h3>
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
<p><i>👨‍⚕️</i> Total Doctors</p>
<p><i>📅</i> Total Appointments</p>
<p><i>💼</i> Total Specialists</p>
<p><i>👥</i> Total Users</p>

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
<div align="center">
    <h2>🎉 Thank You for Using the Hospital Management System!</h2>
    <p>We hope this application helps streamline your experience, whether you're a user scheduling appointments, a doctor managing patients, or an administrator overseeing the operations.</p>
    <div>  
        <h3><i>💖</i>Stay Safe, Stay Healthy!<i>💖</i></h3>  
    </div>
</div>
