package RelationalDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Database connection class.  
 * 
 * Reference: 
 * Cay S. Horstmann. Big Java, 4th Edition, John Wiley & Sons. Feb, 2010 - Chapter 21 Relational Databases
 * 
 * @author Emil Tan
 */
public class DBConn {
	private String url; 
	private String username; 
	private String password; 

	private Connection conn; 

	public DBConn(String dbUrl, String dbUser, String dbPass) throws SQLException {
		url = dbUrl; 
		username = dbUser; 
		password = dbPass;

		conn = DriverManager.getConnection(url, username, password); 
	}

	public Connection getConn() {
		return conn; 
	}
}
