package RelationalDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * An ATM Class.  
 * 
 * Reference: 
 * Cay S. Horstmann. Big Java, 4th Edition, John Wiley & Sons. Feb, 2010 - Chapter 21 Relational Databases
 * 
 * @author Emil Tan
 */
public class ATM {
	private DBConn dbConn; 
	private boolean authorised;

	private int id; 
	private int checkingAcctID; 

	public ATM(String dbUrl, String dbUser, String dbPass, int custId, String custPIN) {
		try {
			dbConn = new DBConn(dbUrl, dbUser, dbPass);

			PreparedStatement statement = dbConn.getConn().prepareStatement("SELECT * FROM CustomerAccount WHERE Cust_ID = ?");
			statement.setInt(1, custId);

			ResultSet result = statement.executeQuery(); 
			if(result.next() && custPIN.equals(result.getString("PIN"))) {
				authorised = true; 
			} else {
				authorised = false; 
				throw new IllegalAccessError("Incorrect Customer ID and PIN combination"); 
			}
			id = result.getInt("Cust_ID");
			checkingAcctID = result.getInt("Checking_Acct_ID"); 
		} catch (SQLException e) {
			System.out.println("Error: Unable to connect to database " + dbUrl);
		}
	}

	public void getInfo() throws SQLException {
		PreparedStatement statement = dbConn.getConn().prepareStatement("SELECT * FROM Customer WHERE Cust_ID = ?");
		statement.setInt(1, id); 
		ResultSet result = statement.executeQuery(); 
		result.next(); 
		System.out.println("Name: " + result.getString("Cust_Name"));
		System.out.println("Address: " + result.getString("Cust_Addr"));

		statement = dbConn.getConn().prepareStatement("SELECT Balance FROM Account WHERE Acct_ID = ?");
		statement.setInt(1, checkingAcctID); 
		result = statement.executeQuery(); 
		result.next(); 
		System.out.println("Checking Account Balance: " + result.getDouble("Balance"));
	}

	public void deposit(double amount) throws SQLException {
		PreparedStatement statement = dbConn.getConn().prepareStatement("UPDATE Account SET Balance = Balance + ? WHERE Acct_ID = ?");
		statement.setDouble(1, amount);
		statement.setInt(2, checkingAcctID); 
		statement.executeUpdate();
	}
	
	public void withdraw(double amount) throws SQLException {
		PreparedStatement statement = dbConn.getConn().prepareStatement("UPDATE Account SET Balance = Balance - ? WHERE Acct_ID = ?");
		statement.setDouble(1, amount);
		statement.setInt(2, checkingAcctID); 
		statement.executeUpdate();
	}

	public boolean getAuthorised() {
		return authorised; 
	}
}
