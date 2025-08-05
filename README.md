# Bank Management System (Java + MySQL)
This is a simple console-based Bank Management System developed in Java using MySQL for backend data storage. It allows users to perform basic banking operations such as creating accounts, depositing and withdrawing money, checking balances, and deleting accounts. The system uses JDBC for database connectivity and demonstrates core concepts of database-driven Java applications.

💡 Features
Create a new bank account with an initial balance

Deposit and withdraw funds from existing accounts

View current balance of any account

Delete an account permanently

Persistent storage using MySQL database

🛠 Technologies Used
Java, MySQL, JDBC

🗂 Project Structure
pgsql
Copy
Edit
BankManagementSystem/
├── BankManagementSystem.java   # Java application code
└── db.sql                      # MySQL database schema
🧪 How to Run
Set up the MySQL database:

Open your MySQL client and run the script in db.sql to create the database and table.

Update DB credentials:

In BankManagementSystem.java, replace yourpassword with your actual MySQL root password.

Compile and Run the Java program:

bash
Copy
Edit
javac BankManagementSystem.java
java BankManagementSystem
📄 License
This project is open-source and available for educational use.
