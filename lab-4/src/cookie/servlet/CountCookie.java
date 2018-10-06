package cookie.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CountCookie")
public class CountCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
		
    public CountCookie() {
        super();
        }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie cookie = null;
		Cookie[] cookies = null;
		int count =0;

		cookies =  request.getCookies();
		if(cookies != null) {
			for(int i = 0; i<cookies.length;i++) {
				cookie = cookies[i];
				if(cookie.getName().equals("count")) {
					response.setContentType("text/html");
					PrintWriter out = response.getWriter();
					String countStr =cookie.getValue();  //countSTr equal the value on cookie
					count = Integer.parseInt(countStr); // make it int to calculate		
					count++;							// add 1 on it
					String finalCount =Integer.toString(count); //again to string to setValue
					cookie.setValue(finalCount);		// setValue()
					response.addCookie(cookie);
					out.write(finalCount +" visits");//print value
					break;
				}
				
			}
			
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
