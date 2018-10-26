package allServlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Login() {
        super();

    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String validity="";
		String errorMsg="";
		//to avoid exception
		Enumeration e = request.getParameterNames();
		if(e.hasMoreElements())
		{
			validity=request.getParameter("validity");
		}
		

		if(validity.equals("empty"))
			{
				errorMsg="Field cannot be empty";
			}
		else if (validity.equals("notmatched"))
			{
				errorMsg="Invalid username or password";
			}


		//getheader
		helperClasses.HtmlEls htm=new helperClasses.HtmlEls();
		String header=htm.header("","Login", "Login");
		String footer=htm.footer();
		HttpSession session=request.getSession();
		if(session.getAttribute("username")==null)
		{
			pw.println(header+
					"\n" + 
					"<div class=\"row container\">\n" + 
					"	<div class=\"col-xs-1 col-md-2\"></div>\n" + 
					"  		<div class=\"col-xs-10 col-md-8 \">\n" + 
					"  			<h1 class=\"text-center\">Login</h1>\n" + 
					"  \n" + 
					"  		</div>\n" + 
					"  	<div class=\"col-xs-1 col-md-2\"></div>\n" + 
					"</div> \n" + 
					"\n" + 
					"\n" + 
					"	<div class=\"row container\">\n" + 
					"		<div class=\"col-xs-2 col-md-3\"></div>\n" + 
					"<div class=\"col-xs-8 col-md-6\">" + 
					
					"<ul class=\" list-group\">\n" + 
					"  <li class=\"text-danger\">"+errorMsg+"</li>\n" + 

					"</ul>"+
					
					"</div>"+
					"		<div class=\"col-xs-2 col-md-3\"></div>\n" + 
					
					"</div>"+
					"<div class=\"row container\">\n" + 
					"<div class=\"col-xs-1 col-md-2\"></div>\n" + 
					"  <div class=\"col-xs-10 col-md-8\">\n" + 
					"  \n" + 
					"  <form method=\"post\" action=\"Authenticate\">\n" + 
					"  <div class=\"form-group\">\n" + 
					"    <input type=\"text\" class=\"form-control\" name=\"username\" aria-describedby=\"emailHelp\" placeholder=\"Enter email\">\n" + 
					"    <small id=\"emailHelp\" class=\"form-text text-muted\">We'll never share your email with anyone else.</small>\n" + 
					"  </div>\n" + 
					"  <div class=\"form-group\">\n" + 
					"    <input type=\"password\" class=\"form-control\" name=\"password\" placeholder=\"Password\">\n" + 
					"  </div>\n" + 
					"<!--    \n" + 
					"   secret key : 6Ld73nUUAAAAAIMkk0qDNqF4JrcMmVTQNgPhBCZw\n" + 
					"   site-key: 6Ld73nUUAAAAAMpILK26nMmPcWMEo-lU3fDg9IFp -->\n" + 
					"   \n" + 
					"<div class=\"g-recaptcha\" data-sitekey=\"6Ld73nUUAAAAAMpILK26nMmPcWMEo-lU3fDg9IFp\"></div>\n" + 
					 
					"\n" +
					"<br/>" +

					"<div class=\"btn-toolbar\" role=\"toolbar\" aria-label=\"Toolbar with button groups\">\n" + 
					"\n" + 
					"  	<div class=\"btn-group mr-2\" role=\"group\" aria-label=\"First group\">\n" + 
					"      	<button type=\"submit\" name=\"login\" class=\"btn btn-primary\">Login</button>\n" + 
					"  	</div>\n" + 
					"  	<div class=\"btn-group\" role=\"group\" aria-label=\"Second group\">\n" + 
					"   	 <a href=\"Registration\"><button type=\"button\" name=\"register\" class=\"btn btn-primary\">Register</button></a>\n" + 
					"  	</div>\n" + 
					"</div>\n" + 
					"   \n" + 
					"<br/>" +
					"   <div >\n" + 
					"   <a href=\"#\">Forgot your Password?</a>\n" + 
					"   </div>\n" + 
					"</form>\n" + 
					"  \n" + 
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
			response.sendRedirect("Dashboard");
		}

	}


}
