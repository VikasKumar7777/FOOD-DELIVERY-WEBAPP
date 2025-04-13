# DeliByte - Food Delivery App

DeliByte is a food delivery application built using Java Servlets, JSP (JavaServer Pages), and MySQL. The app allows users to browse a menu of food items, place orders, and track the status of their orders. Admins can manage the menu, view orders, and perform other administrative tasks.

## Features

- **User Features:**
  - User Registration and Login
  - Browse the Food Menu
  - Add Items to Cart
  - Place Orders
  - View Order History

- **Admin Features:**
  - Admin Login
  - Add, Update, and Delete Menu Items
  - View and Manage Orders
  - Update Order Status

## Tech Stack

- **Frontend:**
  - JavaServer Pages (JSP)
  - HTML, CSS, JavaScript

- **Backend:**
  - Java Servlets
  - JDBC for Database Connection

- **Database:**
  - MySQL

## Installation

To set up the DeliByte project on your local machine, follow the steps below:

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Apache Tomcat (or any servlet container)
- MySQL database server

### Steps

1. **Clone the Repository:**

   ```bash
   git clone https://github.com/your-username/delibyte.git
   ```

2. **Set up the Database:**
   - Create a MySQL database named `delibyte`:
   
     ```sql
     CREATE DATABASE delibyte;
     ```

   - Import the database schema from `delibyte_schema.sql` (if provided) or create your own tables based on the app's requirements.
   
   - Example table creation:
   
     ```sql
     CREATE TABLE users (
         id INT AUTO_INCREMENT PRIMARY KEY,
         username VARCHAR(50) NOT NULL,
         password VARCHAR(255) NOT NULL,
         role ENUM('user', 'admin') NOT NULL
     );
     
     CREATE TABLE menu_items (
         id INT AUTO_INCREMENT PRIMARY KEY,
         name VARCHAR(100),
         description TEXT,
         price DECIMAL(10, 2)
     );

     CREATE TABLE orders (
         id INT AUTO_INCREMENT PRIMARY KEY,
         user_id INT,
         status ENUM('pending', 'in progress', 'completed'),
         order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
         FOREIGN KEY (user_id) REFERENCES users(id)
     );
     ```

3. **Configure Database Connection:**
   - Open the `web.xml` or relevant configuration file to set your database connection details (hostname, username, password).

4. **Deploy to Tomcat:**
   - Build the project and deploy the `WAR` file to your Apache Tomcat server (or any other servlet container).
   
5. **Run the Application:**
   - Once the server is running, navigate to `http://localhost:8080/delibyte` in your web browser to access the app.

## Usage

### User Flow:

1. **Sign up/Login:**
   - New users can create an account, while returning users can log in.

2. **Browse the Menu:**
   - Users can view available food items, see descriptions and prices.

3. **Add to Cart:**
   - Users can select items and add them to their cart.

4. **Place Order:**
   - After reviewing the cart, users can place an order. They will receive an order confirmation.

5. **View Order History:**
   - Users can view the status of previous orders and track their progress.

### Admin Flow:

1. **Admin Login:**
   - Admins can log in using their credentials to access the admin dashboard.

2. **Manage Menu:**
   - Admins can add, update, or delete food items from the menu.

3. **Manage Orders:**
   - Admins can view all customer orders and update their status (e.g., pending, in progress, completed).

## Directory Structure

```
/delibyte
├── /src
│   ├── /model          # Java classes for database models
│   ├── /controller     # Servlet classes for handling requests
│   ├── /view           # JSP pages for user interface
│   └── /utils          # Utility classes (e.g., database connection)
├── /web
│   ├── /WEB-INF        # Configuration files (web.xml, etc.)
│   ├── /lib            # External libraries (JARs)
├── /resources          # Static files (CSS, JS, images)
└── README.md           # This file
```

## Contributing

If you want to contribute to the development of DeliByte, feel free to fork the repository, make changes, and create a pull request. Please ensure your changes align with the coding standards used in the project.
