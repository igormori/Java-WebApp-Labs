package cookie.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ReadCookie")
public class ReadCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ReadCookie() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie cookie = null;
		Cookie[] cookies = null;
		// Get an array of cookies associated with this doamain 
		cookies =  request.getCookies();
		
		// Set  response  content type 
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		String title =  "Reading cookies example ";
		String docType =
				"<!doctype html public \"-//w3c//dtd html 4.0"+
				"transitional//en\">\n";
				out.println(docType +
							"<html>\n"+
							"<head><title>" + title + "</title></head>\n"+
							"<body>\n");
				if(cookies!=null) {
					out.println("<h2> Found Cookies Name and value</h2>");
					for(int i = 0; i<cookies.length;i++) {
						cookie = cookies[i];
						out.print("Name : "+ cookie.getName()+ ", ");
						out.print("Value: " +cookie.getValue()+ "</br> ");
					}
				}else {
					out.print("<h2> No Cookies founds</h2>");
				}
				out.print("</body>");
				out.print("</html>");
				
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
