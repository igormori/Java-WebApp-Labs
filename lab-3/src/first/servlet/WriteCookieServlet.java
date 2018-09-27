package first.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/WriteCookieServlet")
public class WriteCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public WriteCookieServlet() {
        super();
   }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		//Create the cookies for the first  and last name, using
		//cookie name  = new cookie ("key", "value")
		Cookie firstName  = new Cookie("first",request.getParameter("firstName"));
		Cookie lastName  = new Cookie("last",request.getParameter("lastName"));
		
		// set the expires date
		firstName.setMaxAge(60*60*24);
		lastName.setMaxAge(60*60*24);
		
		//add both cookies in the response header.
		response.addCookie(firstName);
		response.addCookie(lastName);
		
		//Set Response content type
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		
		
		
		
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
