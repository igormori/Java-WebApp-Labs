/*********************************************************************************
* Project: < COMP 3095 – Java Web Application Development>
* Assignment: < Assignment -1 >
* Author(s): < Igor Mori, Md Farhad Hossain , Yash  Thanki, Arifur Rahman >
* Student Number: < 101045762, 101056010, 101093832, 100883999>
* Date: 10/28/2018
* Description: <This Servlet will generate the Htmls with all the fields to create a user. Also it will display error massage accordingly 
* 				with the registration_ authenticate response  >
*********************************************************************************/

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

@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Registration() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String validity="";
		//just to avoid nullpointer exception  from server
		Enumeration e = request.getParameterNames();
		if(e.hasMoreElements())
		{
			validity=request.getParameter("validity");
		}

		
		//error message
		String fnamemsg="";
		String lnamemsg="";
		String emailmsg="";
		String passmsg="";
		String emptymsg="";
		String passnoteq="";
		String duplicate="";
		String chkagree="";

		helperClasses.InputFieldValidator inputValidator=new helperClasses.InputFieldValidator();
		
		
		if(inputValidator.isFieldValuesAreEqual(validity, "empty")) {
			emptymsg="Field cannot be empty";
		}
		else if(inputValidator.isFieldValuesAreEqual(validity, "reginvalid"))
		{
			fnamemsg="Both first and last names must contain only alphabets.";
			emailmsg="e-mail address must be of valid email form/structure (ie. example@demo.com)";
			passmsg="Password must be 6-12 characters in length and must contain\n" + 
					"contain at least 1 uppercase letter\n" + 
					"contain at least 1 special character";
			
		}
		else if(inputValidator.isFieldValuesAreEqual(validity, "passnotequal"))
		{
			passnoteq="Passwords are not equal";
		}
		else if(inputValidator.isFieldValuesAreEqual(validity, "duplicate"))
		{
			duplicate="User already exist!!!!";
		}
		else if(inputValidator.isFieldValuesAreEqual(validity, "notagree"))
		{
			chkagree="Must agree with the terms and conditions";
		}
		//getheader
		helperClasses.HtmlEls htm=new helperClasses.HtmlEls();
		String header=htm.header("","Login","Registration");
		String footer=htm.footer();
		HttpSession session=request.getSession();
		if(session.getAttribute("username")==null)
		{
			if(!inputValidator.isFieldValuesAreEqual(validity, "success"))
			{
				pw.println(header+
						"\n" + 
						"	<div class=\"row container\">\n" + 
						"		<div class=\"col-xs-1 col-md-2\"></div>\n" + 
						"		<div class=\"col-xs-10 col-md-8 \">\n" + 
						"			<h1 class=\"text-center\">Registration Page</h1>\n" + 
						"\n" + 
						"		</div>\n" + 
						"		<div class=\"col-xs-1 col-md-2\"></div>\n" + 
						"	</div>\n" + 

						"\n" + 
						"\n" + 
						"	<div class=\"row container\">\n" + 
						"		<div class=\"col-xs-2 col-md-3\"></div>\n" + 
						"<div class=\"col-xs-8 col-md-6\">" + 
						
						"<ul class=\" list-group\">\n" + 
						"  <li class=\"text-danger\">"+emptymsg+"</li>\n" + 
						"  <li class=\"text-danger\">"+fnamemsg+"</li>\n" + 
						"  <li class=\"text-danger\">"+lnamemsg+"</li>\n" +
						"  <li class=\"text-danger\">"+emailmsg+"</li>\n" +
						"  <li class=\"text-danger\">"+passmsg+"</li>\n" +
						"  <li class=\"text-danger\">"+passnoteq+"</li>\n" +
						"  <li class=\"text-danger\">"+duplicate+"</li>\n" +
						"<li class=\"text-danger\">"+chkagree+"</li>\n" +
						"</ul>"+
						
						"</div>"+
						"		<div class=\"col-xs-2 col-md-3\"></div>\n" + 
						
						"</div>"+
						"	<div class=\"row container\">\n" + 
						"		<div class=\"col-xs-1 col-md-2\"></div>\n" + 
						"		<div class=\"col-xs-10 col-md-8\">\n" + 
						"\n" + 
						"			<form method=\"post\" action=\"Registration_authenticate\">\n" + 
						"				<div class=\"form-group\">\n" + 
						"					<label>First Name *</label> <input type=\"text\" class=\"form-control\"\n" + 
						"						name=\"firstname\" placeholder=\"First Name\">\n" + 
						"\n" + 
						"				</div>\n" + 
						"				<div class=\"form-group\">\n" + 
						"					<label>Last Name *</label> <input type=\"text\" class=\"form-control\"\n" + 
						"						name=\"lastname\" placeholder=\"Last Name\">\n" + 
						"\n" + 
						"				</div>\n" + 
						"				<div class=\"form-group\">\n" + 
						"					<label>Email *</label> <input type=\"text\" class=\"form-control\"\n" + 
						"						name=\"email\" placeholder=\"Email address\">\n" + 
						"\n" + 
						"				</div>\n" + 
						"				<div class=\"form-group\">\n" + 
						"					<label>Address *</label> <input type=\"text\" class=\"form-control\"\n" + 
						"						name=\"address\" placeholder=\"Address\">\n" + 
						"\n" + 
						"				</div>\n" + 
						"				<div class=\"form-group\">\n" + 
						"				<label>Password *</label> \n" + 
						"					<input type=\"password\" class=\"form-control\" name=\"password\"\n" + 
						"						placeholder=\"Password\">\n" + 
						"				</div>\n" + 
						"				<div class=\"form-group\">\n" + 
						"				<label>Confirm Password*</label> \n" + 
						"					<input type=\"password\" class=\"form-control\" name=\"confirmpassword\"\n" + 
						"						placeholder=\"Type password again\">\n" + 
						"				</div>\n" + 
						"				<div class=\"checkbox\">\n" + 
						"					<label><input type=\"checkbox\" name=\"remember\"> I\n" + 
						"						agree to the <a href=\"#\">terms and condition</a></label>\n" + 
						"				</div>\n" + 
						"\n" + 
						"				<div class=\"btn-toolbar\" role=\"toolbar\"\n" + 
						"					aria-label=\"Toolbar with button groups\">\n" + 
						"\n" + 
						"\n" + 
						"					<div class=\"btn-group\" role=\"group\" aria-label=\"Second group\">\n" + 
						"						<button type=\"submit\" name=\"register\" class=\"btn btn-primary\">Register</button>\n" + 
						"					</div>\n" + 
						"					<div class=\"btn-group mr-2\" role=\"group\" aria-label=\"First group\">\n" + 
						"				    <a href=\"Login\"><input type=\"button\" value=\"Cancel\" name=\"cancel\" class=\"btn btn-primary\" /></a>\n" + 
						"					</div>\n" + 
						"				</div>\n" + 
						"\n" + 
						"			</form>\n" + 
						"\n" + 
						"		</div>\n" + 
						"		<div class=\"col-xs-1 col-md-2\"></div>\n" + 
						"	</div>\n" + 
						"\n" + 
						"\n" + 
						"\n" + 
						"\n" + 
						"	<script src=\"bootstrap/js/bootstrap.min.js\">\n" + 
						"		\n" + 
						"	</script>\n" +
						footer+
						"</body>\n" + 
						"</html>");
				
			}
			
			else
			{
				pw.println(header+
						"\n" + 
						"	<div class=\"row container\">\n" + 
						"		<div class=\"col-xs-1 col-md-2\"></div>\n" + 
						"		<div class=\"col-xs-10 col-md-8 \">\n" + 
						"			<h1 class=\"text-center\">Registration Successfull</h1>\n" + 
						"\n" + 
						"		</div>\n" + 
						"		<div class=\"col-xs-1 col-md-2\"></div>\n" + 
						"	</div>\n" + 

						"\n" + 

						"	<script src=\"bootstrap/js/bootstrap.min.js\">\n" + 
						"		\n" + 
						"	</script>\n" + 
						footer+
						"</body>\n" + 
						"</html>");
				
			}
		}
		else
		{
			response.sendRedirect("Dashboard");
		}
			
			
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
				
	}

}
