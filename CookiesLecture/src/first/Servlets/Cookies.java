package first.Servlets;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Cookies
 */
@WebServlet("/Cookies")
public class Cookies extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cookies() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		
		
		
		//<  -------------------------  check if the cookie exist ---------------------->
		
		Cookie[] cookies = request.getCookies();
		
		//<  -------------------if it exists get it and display  ---------------------->
		if(cookies !=null) {
			for(Cookie cookie:cookies)
			{
				// if the name entered is the same as the value in the cookie
				if(firstName.equals(cookie.getValue())) {
					
					
					PrintWriter pw = response.getWriter();
					pw.println("<h1><b>");
					pw.println("We are happy to see you here again! " + cookie.getName());
					pw.println("</h1></b><h2>");
					pw.println("User Last Name: "+firstName);
					pw.println("</br>User Last Name: "+lastName);
					pw.println("</br>User Last Name: "+email);
					pw.println("</h2>");
					pw.println("");
					break;
				
				}
				// if the name entered is different than the name on cookie
				else {
					
					PrintWriter pw = response.getWriter();
					pw.println("<h1><b>");
					pw.println("Welcome back: " + cookie.getName());
					pw.println("</h1></b><h2>");
					pw.println("User Firs Name: "+firstName);
					pw.println("</br>User Last Name: "+lastName);
					pw.println("</br>User Email: "+email);
					pw.println("</h2>");
					pw.println("");
					break;
					
				}
			}
		}
		
		//<  ---------------------if does not exist create it ---------------------->
		else {
			
			Cookie firstNameC = new Cookie("first",firstName);
			Cookie lastNameC = new Cookie("last",lastName);
			//set cookie name 
			response.addCookie(firstNameC); 
			response.addCookie(lastNameC); 
			//set cookie time
			firstNameC.setMaxAge(60*60*24*7);
			lastNameC.setMaxAge(60*60*24*7);
			PrintWriter pw = response.getWriter();
			pw.println("<h1><b>");
			pw.println("Welcome new visitor" + firstName);
			pw.println("</h1></b><h2>");
			pw.println("User Last Name: "+firstName);
			pw.println("</br>User Last Name: "+lastName);
			pw.println("</br>User Last Name: "+email);
			pw.println("</h2>");
			pw.println("");
			
			
		}
		
	
		
	}

}
