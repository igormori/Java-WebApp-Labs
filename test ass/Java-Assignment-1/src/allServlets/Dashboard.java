/*********************************************************************************
* Project: < COMP 3095 – Java Web Application Development>
* Assignment: < Assignment -1 >
* Author(s): < Igor Mori, Md Farhad Hossain , Yash  Thanki, Arifur Rahman >
* Student Number: < 101045762, 101056010, 101093832, 100883999>
* Date: 10/28/2018
* Description: <This Servlet will get the HTMLs and include the dash board code with futures Enhancement  >
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

@WebServlet("/Dashboard")
public class Dashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Dashboard() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		//session getting
		HttpSession session = request.getSession();		
		String sessionname=(String)session.getAttribute("username");
		helperClasses.HtmlEls htm=new helperClasses.HtmlEls();
		String header=htm.header("Welcome, "+sessionname, "Logout","Dashboard");
		String footer=htm.footer();

				
				
				if(sessionname!=null)
		{
			System.out.println(sessionname+"df");
			pw.println(header+
					
					"<div class=\"row container\">\n" + 
					"<div class=\"col-xs-12 col-md-12\"><h1 class=\"text-center\" >Dashboard</h1></div>\n" + 
					"</div>"+
					
					
					
					"<div class=\"mt-5 row container\">\n" + 
					"<div class=\"col-xs-1 col-md-2\"></div>\n" + 
					
					
					"  <div class=\"col-xs-10 col-md-8\">\n" + 	
					
					
					
                    "<div class=\"row container\">\n" +
                    
                    
                    
                    "<div id=\"left-panel\" class=\"col-xs-2 col-md-3\">Future Enhancement</div>\n" +
                    
                    
                    
					"<div class=\"col-xs-10 col-md-9\">"+
					
					
					
                    "<div class=\"row\">\n" +
                    "<div class=\" right-panel col-xs-12 col-md-12\">Future Enhancement</div>\n" +
					"</div>\n" +
                    
                    "<div class=\"row\">\n" +
                    "<div class=\" right-panel col-xs-12 col-md-12\">Future Enhancement</div>\n" +
                    
                    "</div>\n" +
                    
                    
					
					"</div>\n" +
					
					
					
					
					"</div>"+
					
					
					
					"  </div>\n" + 
					
					

					
					"  <div class=\"col-xs-1 col-md-2\"></div>\n" + 					
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
