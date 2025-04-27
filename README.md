# Banking Management System

### Overview:
The Banking Management System is a RESTful backend application built to simulate core banking operations such as creating an account, viewing account details, depositing money, withdrawing funds, and checking balances.
It offers a simple, well-structured API to manage user banking operations securely and efficiently.
The project is designed primarily for learning backend API development, testing API endpoints, and practicing structured coding and database operations — following clean coding principles and industry-like REST standards.

### Purpose:
->To simulate basic banking operations via RESTful APIs.  
->To practice backend service design, API structuring, and database interaction.  
->To demonstrate skills in Spring Boot, REST APIs, and Java backend development.  

### Technologies Used:
->Java 8+  
->Spring Boot (Spring MVC, Spring Data JPA)  
->MySQL (Database to store user account details)  
->Postman or cURL (for API testing)  
->Maven (for build and dependency management)  

### Features:
->Create new bank accounts.  
->Deposit funds into existing accounts.  
->Withdraw funds with validation (sufficient balance).  
->View account details by account ID.  
->Delete accounts.  
->List all available accounts.  
->Structured error handling for invalid operations.  

### How to Run the Project Locally:
1. Clone the Repository  
   `git clone https://github.com/Ramesh-Odde/BankingManagementSystem.git`  
   `cd BankingManagementSystem`  
2. Set Up the Database  
   ->Make sure MySQL server is running.  
   ->Create a database named bankdb. ` CREATE DATABASE bankdb;`  
   ->Update your application.properties file if needed (for username/password settings).  
   Example:  
   `spring.datasource.url=jdbc:mysql://localhost:3306/bankdb`  
   `spring.datasource.username=root`
   `spring.datasource.password=your_password`
   `spring.jpa.hibernate.ddl-auto=update`  
4. Build and Run the Application    
   server will run at ` http://localhost:8080/`
### API Endpoints and Testing using Postman
--> Create a New Account  `/account/create/` supply `account_holder_name` and `account_balance` using body field in postman.  
--> Get All Accounts `/account/all`  
--> Get Account by account number `/account/{account_number}`  
--> Deposite money into the account `/account/{account_number}/{amount}`  
--> Withdraw amount from account `/account/{account_number}/{amount}`  
--> Delete account `/account/delete/{account_number}`  

### Additional points  
Validation: API will throw a proper error response if you try to withdraw more money than the available balance.  
Error Handling: Custom exception handlers are provided for cases like "Account Not Found".  
Database Persistence: All changes (deposit, withdraw, create, delete) are automatically persisted into the MySQL database.  

### Contributions
This project is primarily built for self-learning and showcasing backend API skills. Contributions to improve features (like transaction history, authentication, etc.) are welcome.

### Contact
If you have any questions or suggestions regarding the project, feel free to connect:  
📧 Email: ramesh.odde95@gmail.com  
🔗 LinkedIn: https://www.linkedin.com/in/ramesh-odde
