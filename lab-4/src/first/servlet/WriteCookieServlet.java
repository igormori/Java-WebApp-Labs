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

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//Create the cookies for the first  and last name, using
				//cookie name  = new cookie ("key", "value")
				Cookie firstName  = new Cookie("first",request.getParameter("firstName"));
				Cookie lastName  = new Cookie("last",request.getParameter("lastName"));
				Cookie count = new Cookie("count",request.getParameter("userCount"));
				
				// set the expires date
				firstName.setMaxAge(60*60*24);
				lastName.setMaxAge(60*60*24);
				count.setMaxAge(60*60*24);
				
				//add both cookies in the response header.
				response.addCookie(firstName);
				response.addCookie(lastName);
				response.addCookie(count);
				
				
				//Set Response content type
				response.setContentType("text/html");
				
				PrintWriter out = response.getWriter();
				String title ="Setting Cookies example";
				String docType =
				"<!doctype html public \"-//w3c//dtd html 4.0"+
				"transitional//en\">\n";
				out.println(docType +
							"<html>\n"+
							"<head><title>" + title + "</title></head>\n"+
							"<body bgcolor=\"#f0f0f0\">\n"+
							"<h1 align=\"center\">"+ title +"</h1>\n"+
							"<ul>\n"+
							" <li><b>Last Name </b>:"
							+ request.getParameter("firstName")+"\n"+
							" <li><b>Last Name </b>:"
							+request.getParameter("lastName")+ "\n"+
							"</ul>\n"+
							"<body</html>");

	}

}
