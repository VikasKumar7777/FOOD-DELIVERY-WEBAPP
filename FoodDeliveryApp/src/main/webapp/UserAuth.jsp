<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap" rel="stylesheet">
    <title>DeliByte - Login/Signup</title>
    <style>
        /* Reset and Base Styles */
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: "Poppins", sans-serif;
            background-color: #FFF8E7;
            min-height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
            padding: 16px;
        }

        /* Container Styles */
        .container {
            max-width: 1000px;
            width: 100%;
            margin: 0 auto;
            display: flex;
            background: white;
            border-radius: 24px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            overflow: hidden;
        }

        /* Image Section */
        .auth-image {
            flex: 1;
            background-color: #E6F7F1;
            padding: 40px;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            text-align: center;
        }

        .auth-image img {
            max-width: 80%;
            height: 330px;
            margin-bottom: 24px;
            border-radius: 12px 0 0 12px;
        }

        .auth-image h2 {
            color: #00A082;
            margin-bottom: 16px;
            font-size: 1.8rem;
        }
        
		.auth-image h2 span {
            color: black;
        }

        .auth-image p {
            color: #4b5563;
            font-size: 1rem;
        }

        /* Form Section */
        .auth-form {
            flex: 1;
            padding: 40px;
            background: white;
        }

        .logo {
            display: flex;
            align-items: center;
            gap: 8px;
            margin-bottom: 32px;
        }

        .logo h1 {
            font-size: 1.8rem;
            color: #00A082;
        }

        /* Form Elements */
        .form-group {
            margin-bottom: 20px;
        }

        .form-group label {
            display: block;
            margin-bottom: 8px;
            color: #374151;
            font-weight: 500;
        }

        .form-group input {
            width: 100%;
            padding: 12px;
            border: 1px solid #e5e7eb;
            border-radius: 8px;
            font-size: 1rem;
            transition: border-color 0.2s;
        }

        .form-group input:focus {
            outline: none;
            border-color: #00A082;
        }

        .remember-forgot {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 24px;
        }

        .remember-me {
            display: flex;
            align-items: center;
            gap: 8px;
        }

        .forgot-password {
            color: #00A082;
            text-decoration: none;
            font-size: 0.9rem;
        }

        .auth-button {
            width: 100%;
            padding: 12px;
            background-color: #00A082;
            color: white;
            border: none;
            border-radius: 8px;
            font-size: 1rem;
            font-weight: 500;
            cursor: pointer;
            transition: background-color 0.2s;
        }

        .auth-button:hover {
            background-color: #008068;
        }

        .auth-switch {
            margin-top: 24px;
            text-align: center;
            color: #6b7280;
        }

        .auth-switch a {
            color: #00A082;
            text-decoration: none;
            font-weight: 500;
        }

        /* Form Tabs */
        .form-tabs {
            display: flex;
            margin-bottom: 32px;
            border-bottom: 2px solid #e5e7eb;
        }

        .tab {
            flex: 1;
            padding: 12px;
            text-align: center;
            cursor: pointer;
            color: #6b7280;
            font-weight: 500;
            transition: all 0.2s;
        }

        .tab.active {
            color: #00A082;
            border-bottom: 2px solid #00A082;
            margin-bottom: -2px;
        }

        /* Error Message */
        .error-message {
            color: #dc2626;
            font-size: 0.9rem;
            margin-top: 4px;
        }

        /* Success Message */
        .success-message {
            color: #00A082;
            font-size: 0.9rem;
            margin-top: 4px;
        }

        /* Responsive Design */
        @media screen and (max-width: 768px) {
            .container {
                flex-direction: column;
            }

            .auth-image {
                padding: 24px;
            }

            .auth-form {
                padding: 24px;
            }

            .auth-image h2 {
                font-size: 1.5rem;
            }
        }

        @media screen and (max-width: 480px) {
            .form-tabs {
                flex-direction: column;
                border-bottom: none;
            }

            .tab {
                border: 1px solid #e5e7eb;
                margin-bottom: 8px;
                border-radius: 8px;
            }

            .tab.active {
                border-color: #00A082;
                margin-bottom: 8px;
            }

            .remember-forgot {
                flex-direction: column;
                gap: 12px;
                align-items: flex-start;
            }
            
            .auth-image img{
            	display:none;
            }
            
            .auth-form .logo h1{
            	display:none;
            }
            
			.auth-button {
            	border-radius: 18px;
            	height:45px;
      		}
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="auth-image">
            <img src="https://res.cloudinary.com/drc2ky0yw/image/upload/v1731738944/download_1_qtb1up.jpg" alt="Food delivery illustration">
            <h2>Welcome to<span> DeliByte</span></h2>
            <p>Your favorite restaurants, delivered to your doorstep</p>
        </div>

        <div class="auth-form">
            <div class="logo">
                <h1>DeliByte</h1>
            </div>

            <div class="form-tabs">
                <div class="tab active" onclick="switchTab('login')">Login</div>
                <div class="tab" onclick="switchTab('signup')">Sign Up</div>
            </div>

            <!-- Login Form -->
            <form id="loginForm" action="UserLogin" method="post">
                <div class="form-group">
                    <label for="email">Email</label>
                    <input type="email" id="email" name="Email" required>
                </div>

                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" id="password" name="Password" required>
                </div>

                <div class="remember-forgot">
                    <label class="remember-me">
                        <input type="checkbox" name="remember">
                        Remember me
                    </label>
                    <a href="#" class="forgot-password">Forgot password?</a>
                </div>

                <button type="submit" class="auth-button">Login</button>
            </form>

            <!-- Signup Form (hidden by default) -->
            <form id="signupForm" action="UserRegister" method="post" style="display: none;">
                <div class="form-group">
                    <label for="fullName">UserName</label>
                    <input type="text" id="fullName" name="username" required>
                </div>
                
				<div class="form-group">
                    <label for="mobilenumber">Mobile Number</label>
                    <input type="number" id="signupEmail" name="mobilenumber" required>
                </div>

                <div class="form-group">
                    <label for="signupEmail">Email</label>
                    <input type="email" id="signupEmail" name="Email" required>
                </div>

                <div class="form-group">
                    <label for="signupPassword">Password</label>
                    <input type="password" id="signupPassword" name="Password" required>
                </div>

                <div class="form-group">
                    <label for="confirmPassword">Confirm Password</label>
                    <input type="password" id="confirmPassword" name="confirmPassword" required>
                </div>

                <button type="submit" class="auth-button">Create Account</button>
            </form>
        </div>
    </div>

    <script>
        function switchTab(tab) {
            const loginForm = document.getElementById('loginForm');
            const signupForm = document.getElementById('signupForm');
            const tabs = document.querySelectorAll('.tab');

            tabs.forEach(t => t.classList.remove('active'));
            
            if (tab === 'login') {
                loginForm.style.display = 'block';
                signupForm.style.display = 'none';
                tabs[0].classList.add('active');
            } else {
                loginForm.style.display = 'none';
                signupForm.style.display = 'block';
                tabs[1].classList.add('active');
            }
        }

        // Form validation
        document.getElementById('signupForm').addEventListener('submit', function(e) {
            const password = document.getElementById('signupPassword').value;
            const confirmPassword = document.getElementById('confirmPassword').value;

            if (password !== confirmPassword) {
                e.preventDefault();
                alert('Passwords do not match!');
            }
        });
    </script>
</body>
</html>