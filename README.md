# Student Management System

A menu-driven Student Management System developed using **Java, JDBC, and MySQL** to perform CRUD (Create, Read, Update, Delete) operations on student records.

## Technologies Used
- Java 17
- JDBC (Java Database Connectivity)
- MySQL
- Maven
- Eclipse IDE
- Git and GitHub

## Features
- Insert student records
- Update student names using student ID
- Delete student records using student ID
- Retrieve all student records
- Perform multiple operations in one program execution
- Use `PreparedStatement` for parameterized SQL queries
- Use try-with-resources to manage database resources

## Database Setup
1. Open MySQL Workbench.
2. Create the database:

   ```sql
   CREATE DATABASE kenuit_db;
   ```

3. Create the student table:

   ```sql
   USE kenuit_db;

   CREATE TABLE Student (
       Id INT PRIMARY KEY,
       Name VARCHAR(100) NOT NULL
   );
   ```

4. Configure your local MySQL connection settings in `JDBCTest.java`. Do not publish your actual database password.

## How to Run
1. Install Java and MySQL.
2. Import the project into Eclipse as an existing Maven project.
3. Configure the database connection credentials locally.
4. Ensure the MySQL JDBC driver dependency is configured in `pom.xml`.
5. Run `JDBCTest.java`.
6. Choose an operation from the console menu.

## Learning Outcomes
- Java database connectivity
- SQL CRUD operations
- `PreparedStatement` and `ResultSet`
- Exception handling
- Try-with-resources
- Menu-driven Java application development

## Author
Java Developer Fresher | ECE Graduate
