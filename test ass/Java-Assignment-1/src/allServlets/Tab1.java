/*********************************************************************************
* Project: < COMP 3095 � Java Web Application Development>
* Assignment: < Assignment -1 >
* Author(s): < Igor Mori, Md Farhad Hossain , Yash  Thanki, Arifur Rahman >
* Student Number: < 101045762, 101056010, 101093832, 100883999>
* Date: 10/28/2018
* Description: <This Servlet will display the Htmls from the HtmlEls.java class also the TAB1 contents >
*********************************************************************************/
package allServlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/Tab1")
public class Tab1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Tab1() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		//session getting
		HttpSession session = request.getSession();		
		String sessionname=(String)session.getAttribute("username");

		//getheader
		helperClasses.HtmlEls htm=new helperClasses.HtmlEls();
		String header=htm.header("Welcome, "+sessionname, "Logout","Tab1");
		String footer=htm.footer();
		if(sessionname!=null)
		{
			pw.println(header+
					"\n" + 
					
					
					"<div class=\"row container\">\n" + 
					"<div class=\"col-xs-12 col-md-12\"><h1 class=\"text-center\" >Tab1</h1></div>\n" + 
					"</div>"+
					
					
					
					"<div class=\"mt-5 row container\">\n" + 
					"<div class=\"col-xs-1 col-md-2\"></div>\n" + 
					
					"<div class=\"col-xs-10 col-md-8\">"+
					
					"<img src=\"underconstruction.png\" alt=\"Smiley face\">"+

					"</div>\n" + 
					
					"<div class=\"col-xs-1 col-md-2\"></div>\n" + 
					"</div>\n" + 
					

					"\n" + 
					"<script src=\"bootstrap/js/bootstrap.min.js\"> </script>\n" +
					footer+
					"</body>\n" + 
					"</html>");
		}
		else

			{
				response.sendRedirect("Login?validity=logout");
				
			}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
