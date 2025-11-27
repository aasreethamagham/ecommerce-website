# ecommerce-website
A simple Spring Boot + Thymeleaf eCommerce web application with product management, admin panel, cart system, and user authentication. Built as a learning project using Java, Spring MVC, Spring Security, and HTML/CSS.
🛒 Ecommerce Website (Spring Boot + Thymeleaf)

A fully functional Ecommerce Web Application built using Spring Boot, Thymeleaf, Spring Security, and Bootstrap.
This project includes user login, signup, product browsing, shopping cart, and admin product management.

📌 Features
👤 User Features

Create an account (Signup)

Login/Logout

Browse products

View product details

Add products to cart

Increase / decrease product quantity

Remove products from cart

Checkout confirmation page

🔐 Authentication

Spring Security based login system

Password encryption

Restricted admin routes

🛠️ Admin Features

Admin login

Add new products

Edit existing products (optional)

Delete products (optional)

Manage product catalog

🏗️ Tech Stack Used
Layer	Technology
Backend	Spring Boot, Spring MVC, Spring Security
Frontend	Thymeleaf, HTML5, CSS, Bootstrap 5
Build Tool	Maven
Language	Java 17+
Server	Embedded Tomcat 9
Database (Optional)	In-memory product list (can be extended to MySQL)
📂 Project Structure
ecommerce-website/
 ├── src/
 │   ├── main/
 │   │   ├── java/com/example/ecommerce/
 │   │   │   ├── model/
 │   │   │   ├── service/
 │   │   │   ├── web/ (Controllers)
 │   │   │   └── EcommerceWebApplication.java
 │   │   ├── resources/
 │   │   │   ├── templates/
 │   │   │   │   ├── login.html
 │   │   │   │   ├── signup.html
 │   │   │   │   ├── products.html
 │   │   │   │   ├── admin.html
 │   │   │   │   ├── admin-add.html
 │   │   │   │   ├── cart.html
 │   │   │   │   └── confirmation.html
 │   │   │   └── static/
 │   │   │       └── images/
 │   │   └── application.properties
 ├── pom.xml
 └── README.md

▶️ How to Run the Project
1. Requirements

Java 17 or later

Maven installed

IDE (VS Code / IntelliJ / Eclipse)

2. Steps
# navigate to project folder
cd ecommerce-website

# run project
mvn spring-boot:run

3. Access Website

Open browser and go to:

🔗 http://localhost:8081

🔑 Default Login Credentials (if enabled)
Admin
username: admin
password: admin123

User

Signup through /signup page.

📸 Screenshots (Optional)

You can add images later like:

![Homepage](screenshots/home.png)

🚀 Future Enhancements

Integrate MySQL database

Online payment gateway

Product categories & filters

Order history

User profile dashboard

🤝 Contributing

Pull Requests are welcome!
You may fork the project and improve design or add new features.

📄 License

This project is open-source and available under the MIT License.
