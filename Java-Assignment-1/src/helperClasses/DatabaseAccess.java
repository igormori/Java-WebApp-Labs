package helperClasses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;


public class DatabaseAccess {
	private String username = "admin";;
	private String password = "admin";
	private String database = "COMP3095";
	  private Connection connect = null;
	  
	  public Connection connectDataBase() throws Exception {
		  try {
	      // This will load the MySQL driver, each DB has its own driver
	      Class.forName("com.mysql.jdbc.Driver");
	      // Setup the connection with the DB
	      connect = DriverManager
		          .getConnection("jdbc:mysql://localhost:3306/COMP3095?serverTimezone=UTC",username,password);

		  }
		  catch(Exception e) {
			  System.out.println(e.getMessage());
		  }
	      return connect;

	  }

}