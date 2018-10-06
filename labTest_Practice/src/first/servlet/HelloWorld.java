package first.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/HelloWorld")
public class HelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public HelloWorld() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String help = request.getParameter("help");
		response.setContentType("text/html");
		PrintWriter write = response.getWriter();
		write.println("got it!"+ help);
		
		if(help.equals("help")) {
			response.sendRedirect("https://www.google.com/");
		}
		
			
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paswd = request.getParameter("password");
		String user = request.getParameter("username");
		
		response.setContentType("text/html");
		PrintWriter write = response.getWriter();
		write.println("got it!"+ paswd + user);
		
	}

}
