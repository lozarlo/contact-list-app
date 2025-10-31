# Phonebook - Contacts Manager

Web application in Java/JSP for managing a phonebook with MySQL persistence.

## Requirements
- Java 11
- JSP (JavaServer Pages)
- Servlets
- MySQL 8.x
- JDBC
- Bootstrap 5.3
- Tomcat 10.x

## Features
- ✅ CRUD (Create, Read, Update, Delete)
- ✅ Data persistence in MySQL database
- ✅ Dynamic database configuration
- ✅ Login system
- ✅ Client-side form validation
- ✅ MVC architecture

## Database Structure
```sql
-- Create database and switch to it
CREATE DATABASE rubrica;
USE rubrica;

-- Create contacts table
CREATE TABLE lista_contatti (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    cognome VARCHAR(100) NOT NULL,
    indirizzo VARCHAR(255),
    telefono VARCHAR(20) NOT NULL,
    eta INT NOT NULL
);

-- Create user and grant privileges
CREATE USER 'rubrica'@'localhost' IDENTIFIED BY 'rubrica';
GRANT ALL PRIVILEGES ON rubrica.* TO 'rubrica'@'localhost';
FLUSH PRIVILEGES;
```
## Installation

### Prerequisites
- JDK 11+
- Apache Tomcat 10.x
- MySQL 8.x
- Eclipse IDE (optional)

### Database Setup
1. Install MySQL
2. Execute the script `schema_database.sql`
3. Make sure the user `rubrica` is created with password `rubrica`

### Deployment
1. Import the project into Eclipse as a "Dynamic Web Project"
2. Add MySQL Connector jar to the `WEB-INF/lib/` folder
3. Configure Tomcat in Eclipse
4. Run on Server

Alternatively:
1. Export as a WAR file
2. Copy to `tomcat/webapps/`
3. Start Tomcat
4. Access `http://localhost:8080/contacts-app/`

## Usage
1. **DB Configuration**: enter host, port, database name, username, and password
2. **Login**: default credentials `admin/admin`
3. **Manage Contacts**: add, edit, delete contacts
