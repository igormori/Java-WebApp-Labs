package allServlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Tab4
 */
@WebServlet("/Tab4")
public class Tab4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Tab4() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		//session getting
		HttpSession session = request.getSession();		
		String sessionname=(String)session.getAttribute("username");


		//getheader
		helperClasses.HtmlEls htm=new helperClasses.HtmlEls();
		String header=htm.header("Welcome, "+sessionname, "Logout","Tab4");
		String footer=htm.footer();
		
		if(sessionname!=null)
		{
			pw.println(header+
					"\n" + 
					
					
					"<div class=\"row container\">\n" + 
					"<div class=\"col-xs-12 col-md-12\"><h1 class=\"text-center\" >Tab4</h1></div>\n" + 
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
