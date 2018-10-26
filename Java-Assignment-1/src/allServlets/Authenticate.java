package allServlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import helperClasses.PasswordUtils;
import helperClasses.User;
@WebServlet("/Authenticate")
public class Authenticate extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Authenticate() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("Login");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		helperClasses.User userObject = new User(request.getParameter("username"),request.getParameter("password"));
		
		if(userObject.getEmail()==null||userObject.getPassword()==null)
		{
			userObject.setEmail("");
			userObject.setPassword("");

		}
		
		
		helperClasses.InputFieldValidator fieldval=new helperClasses.InputFieldValidator();
		helperClasses.DatabaseAccess dbac=new helperClasses.DatabaseAccess();
		
		if(fieldval.isEmpty(userObject.getEmail()) || fieldval.isEmpty(userObject.getPassword()))
		{
			response.sendRedirect("Login?validity=empty");
		}
		else
		{
			try {
				//data base access
				Connection connect=dbac.connectDataBase();				
			      System.out.println("Connected");
			      java.sql.Statement stmt=connect.createStatement();
			      ResultSet res=stmt.executeQuery("select * from USERS where email='" + userObject.getEmail() + "'");
			      
			      if(!res.next())
			      {
			    	  response.sendRedirect("Login?validity=notmatched");
			      }
			      else
			      {
			    	   
			    	      helperClasses.User dataBaseUser = new User(res.getString("email"),res.getString("password"),res.getString("firstname"));
					      String salt =res.getString("salt");
					      String role = res.getString("role");

					      
					      if(role.equals("admin")) {
					
					    	  if(fieldval.isFieldValuesAreEqual(dataBaseUser.getEmail(), userObject.getEmail()) && 
										fieldval.isFieldValuesAreEqual(dataBaseUser.getPassword(), userObject.getPassword()))
								{
									HttpSession session=request.getSession();
									session.setAttribute("username", dataBaseUser.getFirstname());
									response.sendRedirect("Dashboard");
									
								}
								else
								{
									response.sendRedirect("Login?validity=notmatched");
								}
					    	  
					      }else {
					    	  ///password reverse encryption
						      boolean passwordMatch = PasswordUtils.verifyUserPassword(userObject.getPassword(),dataBaseUser.getPassword(), salt);
						      
								if(fieldval.isFieldValuesAreEqual(dataBaseUser.getEmail(),userObject.getEmail()) && 
										passwordMatch)
								{
									HttpSession session=request.getSession();
									
									session.setAttribute("username", dataBaseUser.getFirstname());
									response.sendRedirect("Dashboard");
									
								}
								
								else
								{
									response.sendRedirect("Login?validity=notmatched");
								}
					    	  
					      }
					      
  
			      }
			        
			} 
			catch (Exception e) 
			{
				System.out.println(e.getMessage());
			}
			
		}
	}

}
