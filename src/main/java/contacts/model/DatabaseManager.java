package contacts.model;

import java.sql.*;
import jakarta.servlet.http.HttpSession;

public class DatabaseManager {
	/*
	 * private static final String URL = "jdbc:mysql://localhost:3306/rubrica";
	 * private static final String USER = "rubrica";
	 * private static final String PASSWORD = "rubrica";
	 */

	public static Connection getConnection(HttpSession session) throws SQLException {
	    String host = (String) session.getAttribute("dbHost");
	    String port = (String) session.getAttribute("dbPort");
	    String database = (String) session.getAttribute("dbName");
	    String user = (String) session.getAttribute("dbUser");
	    String password = (String) session.getAttribute("dbPassword");
	    
	    // Fallback to default if not set
	    if (host == null) host = "localhost";
	    if (port == null) port = "3306";
	    if (database == null) database = "rubrica";
	    if (user == null) user = "rubrica";
	    if (password == null) password = "rubrica";
	    
	    String url = "jdbc:mysql://" + host + ":" + port + "/" + database;
	    
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    }
	    return DriverManager.getConnection(url, user, password);
	}
}