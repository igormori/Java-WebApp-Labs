package cookie.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DeleteCookie")
public class DeleteCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public DeleteCookie() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//< ------------------------------  Cookies variables --------------------------------->
		Cookie[] cookies = null;		
		Cookie cookie =null;
		
		// function to get the cookies
		cookies =  request.getCookies();
		 
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("Deleted Cookies");
		//< ------------------------------  loop throught cookies to get values --------------------------------->
		for(int i = 0; i<cookies.length;i++) {
			cookie = cookies[i];
			Cookie delete = new Cookie(cookie.getName(),""); // set a new cookie to be the new cookie
			cookie.setMaxAge(0); // set the date to 0
			response.addCookie(delete); // add the new cookie
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
