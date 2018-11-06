/*********************************************************************************
* Project: < COMP 3095 – Java Web Application Development>
* Assignment: < Assignment -1 >
* Author(s): < Igor Mori, Md Farhad Hossain , Yash  Thanki, Arifur Rahman >
* Student Number: < 101045762, 101056010, 101093832, 100883999>
* Date: 10/28/2018
* Description: <This java class will create the data base connection to be used when needed. >
*********************************************************************************/
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