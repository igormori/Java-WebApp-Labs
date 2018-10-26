package allServlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Enumeration;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import helperClasses.PasswordUtils;
import helperClasses.User;
@WebServlet("/Registration_authenticate")
public class Registration_authenticate extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Registration_authenticate() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		pw.println("<h1>insert</h1>");
		
		
		//get the database values
		String conf_pass=request.getParameter("confirmpassword");
		String agree_chbox=request.getParameter("remember");
		
		String myHash ="1234";
		
		
		
		
		
		//instantiate a new user Object
		helperClasses.User newUserObject = new User(request.getParameter("firstname"),request.getParameter("lastname"),request.getParameter("email"),
				request.getParameter("email"),request.getParameter("address"),request.getParameter("password"));
		
		// <----- password encryption ------>
		 // Generate Salt. The generated value can be stored in DB. 
        String salt = PasswordUtils.getSalt(30);
        // Protect user's password. The generated value can be stored in DB.
        String mySecurePassword = PasswordUtils.generateSecurePassword(newUserObject.getPassword(), salt);
        
		
		//first we have to check if any form field is empty
		
		//create instance of helper class
		helperClasses.InputFieldValidator inputValidator=new helperClasses.InputFieldValidator();
		helperClasses.RegexValidation regVal=new helperClasses.RegexValidation();
		helperClasses.DatabaseAccess dbac=new helperClasses.DatabaseAccess();
		
		
		if(inputValidator.isEmpty(newUserObject.getRole())||inputValidator.isEmpty(newUserObject.getLastname())||inputValidator.isEmpty(newUserObject.getEmail())
				||inputValidator.isEmpty(newUserObject.getAddress())||inputValidator.isEmpty(newUserObject.getPassword())||inputValidator.isEmpty(conf_pass))
		{

				response.sendRedirect("Registration?validity=empty");

		}
		else if(agree_chbox==null)
		{
			response.sendRedirect("Registration?validity=notagree");
		}

		else
		{
			if(!regVal.firstorlast(newUserObject.getFirstname())||!regVal.firstorlast(newUserObject.getLastname())||!regVal.email(newUserObject.getEmail())
					|| !regVal.password(newUserObject.getPassword()))
			{
				response.sendRedirect("Registration?validity=reginvalid");
				
			}
			else
			{
				if(!newUserObject.getPassword().equals(conf_pass))
				{
					response.sendRedirect("Registration?validity=passnotequal");
				}
				
				else
				{
					
					try 
					{
						Connection conn=dbac.connectDataBase();
						
					      System.out.println("Connected");
					      java.sql.Statement stmt=conn.createStatement();
					      ResultSet res=stmt.executeQuery("select * from USERS");
					        while(res.next())
					         {
					        	if(res.getString("email").equals(newUserObject.getEmail()))
					        	{
					        		response.sendRedirect("Registration?validity=duplicate");
							        conn.close();
					        	}
					        

				   
					        }
							  String sql = "insert into USERS (firstname,lastname,email,role,username, address, password,salt) "
							      		+ "values('" + newUserObject.getFirstname() + "','" + newUserObject.getLastname() + "','" + newUserObject.getEmail() +
							      		"','" + newUserObject.getRole() + "','" + newUserObject.getUsername() +"','" + newUserObject.getAddress() +"','" + mySecurePassword +"','" +salt + "')";
							      
							      stmt.executeUpdate(sql);
							      
							    
							      response.sendRedirect("Registration?validity=success");
							      conn.close();						  
					      
					} 
					catch (Exception e) 
					{
						pw.println(e.getMessage());
					}
					
					
				}
			}

			
		}
		

				
	}

}
