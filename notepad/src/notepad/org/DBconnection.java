package notepad.org;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;

	public class DBconnection {

	
	    private static final String URL = "jdbc:mysql://localhost:3306/notesdb";
	    private static final String USER = "root";
	    private static final String PASSWORD = "misab@727";

	    public static Connection getConnection() throws ClassNotFoundException, SQLException {
	    	
	        Class.forName("com.mysql.cj.jdbc.Driver");

	      
	        return DriverManager.getConnection(URL, USER, PASSWORD);
	    }
	
	}


