
# Java JDBC – Employee Database App

This is a simple Java-based CRUD (Create, Read, Update, Delete) application that connects to a **MySQL** database using **JDBC**. It allows you to manage employee records through a console-based menu system.

---

## 📦 Features

* ✅ Add new employees
* 📄 View all employee records
* 🔁 Update existing employee information
* ❌ Delete employees by ID
* 🔍 Search employee by ID
* 💾 External `config.properties` to manage DB credentials securely


---
```aiignore
Java-JDBC-Employee-Database-App/
│
├── src/
│   └── com/
│       └── lohithpuvvala/
│           └── employeedb/
│               ├── DBConnection.java         # Handles MySQL connection via config.properties
│               ├── Employee.java             # Model class for Employee entity
│               ├── EmployeeDAO.java          # Data Access Object for all DB operations
│               └── Main.java                 # Main application with menu-driven UI
│
├── config.properties                         # Database credentials (excluded from Git)
├── README.md                                 # Project overview and usage guide
├── .gitignore                                # Ignore compiled files and sensitive data
└── out/                                      # Compiled bytecode output (auto-generated)


```
---

## 🔧 Database Setup

1. **Start MySQL Server** (make sure it’s running locally on `localhost:3306`)
2. **Create a database** and table (do this only once):

   ```sql
   CREATE DATABASE employeedb;

   USE employeedb;

   CREATE TABLE employees (
       id INT AUTO_INCREMENT PRIMARY KEY,
       name VARCHAR(100) NOT NULL,
       role VARCHAR(100) NOT NULL
   );
   ```

---

## 🔐 `config.properties` Setup

Create a file called `config.properties` in the **project root**:(a example_config.properties file is include add your username and password and rename the file to config.properties).

```properties
db.url=jdbc:mysql://localhost:3306/employeedb
db.username=your_mysql_username
db.password=your_mysql_password
```

> ✅ **Important**: This file is added to `.gitignore` to protect sensitive credentials please use the example_config.properties file.


---

## 🚀 How to Run

1. Clone the repository:

   ```bash
   git clone https://github.com/yourusername/Java-JDBC-Employee-Database-App.git
   cd Java-JDBC-Employee-Database-App
   ```

2. Make sure your MySQL server is running.

3. Create and configure the `config.properties` file as shown above.

4. Compile and run the application:

   **Using IntelliJ or VS Code:**

    * Open the project.
    * Run the `Main.java` class.



---

## 📋 Menu Options

```
1. Add Employee.
2. List All Employees.
3. Search Employee by ID.
3. Update Employee.
4. Delete Employee.
5. Exit.
```

---

## ✅ Best Practices Followed

* Secure credential handling via `config.properties`
* JDBC best practices with `PreparedStatement` to prevent SQL injection
* Exception handling and edge case checks
* Organized code using MVC-like separation (`DAO`, `Model`, `DB Connection`, `Main UI`)

---

## 👨‍💻 Author

Made by **Lohith Puvvala**
Feel free to contribute or raise issues!

---