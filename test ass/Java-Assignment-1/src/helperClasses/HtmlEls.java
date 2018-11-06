/*********************************************************************************
* Project: < COMP 3095 – Java Web Application Development>
* Assignment: < Assignment -1 >
* Author(s): < Igor Mori, Md Farhad Hossain , Yash  Thanki, Arifur Rahman >
* Student Number: < 101045762, 101056010, 101093832, 100883999>
* Date: 10/28/2018
* Description: <This java class has the header and footer of the pages to be displayed accordingly with values passed in which servlets   >
*********************************************************************************/
package helperClasses;

public class HtmlEls {
	public String header(String sessionname,String logStatus, String title)

	{
		String Action="";
		if(logStatus=="Logout")
		{
			Action="Logout";
		}
		else
		{
			Action="Authenticate";
		}
		return "<!DOCTYPE html>\n" + 
				"<html>\n" + 
				"<head>\n" + 
				"<meta charset=\"UTF-8\">\n" + 
				"<title>"+title+"</title>\n" + 
				"<link rel=\"stylesheet\" href=\"bootstrap/css/bootstrap.min.css\">\n" + 
				"<link rel=\"stylesheet\" href=\"style.css\">\n" + 
				"\n" + 
				"<script src='https://www.google.com/recaptcha/api.js'></script>\n" + 
				"</head>\n" + 
				"\n" + 
				"<body>\n" + 
				"\n" + 
				" <nav class=\"navbar navbar-default\">\n" + 
				"  <div class=\"container-fluid\">\n" + 
				"    <!-- Brand and toggle get grouped for better mobile display -->\n" + 
				"    <div class=\"navbar-header\">\n" + 
				"      <button type=\"button\" class=\"navbar-toggle collapsed\" data-toggle=\"collapse\" data-target=\"#bs-example-navbar-collapse-1\" aria-expanded=\"false\">\n" + 
				"        <span class=\"sr-only\">Toggle navigation</span>\n" + 
				"        <span class=\"icon-bar\"></span>\n" + 
				"        <span class=\"icon-bar\"></span>\n" + 
				"        <span class=\"icon-bar\"></span>\n" + 
				"      </button>\n" + 
				"      <a class=\"navbar-brand\" href=\"#\"> Asignment 1</a>\n" + 
				"    </div>\n" + 
				"\n" + 
				"    <!-- Collect the nav links, forms, and other content for toggling -->\n" + 
				"    <div class=\"collapse navbar-collapse\" id=\"bs-example-navbar-collapse-1\">\n" + 
				"      <ul class=\"nav navbar-nav\">\n" + 

				"        <li><a href=\"Tab1\">Tab1</a></li>\n" + 
				"        <li><a href=\"Tab2\">Tab2</a></li>\n" + 
				"        <li><a href=\"Tab3\">Tab3</a></li>\n" + 
				"        <li><a href=\"Tab4\">Tab4</a></li>\n" + 
				"\n" + 
				"      </ul>\n" + 
				"      <form class=\"navbar-form navbar-left\">\n" + 
				"        <div class=\"form-group\">\n" + 
				"          <input type=\"text\" class=\"form-control\" placeholder=\"Search\">\n" + 
				"        </div>\n" + 
				"        <button type=\"submit\" class=\"btn btn-default\">Submit</button>\n" + 
				"      </form>\n" + 
				
				"      <ul class=\"nav navbar-nav navbar-right\">\n" + 
				"<li></br>"+sessionname+"</li>"+
				
				"        <li>"+
				"      <form method=\"post\" action="+Action+" class=\"navbar-form navbar-right\">\n" + 
				"        <div class=\"form-group\">\n" + 
				"        <button type=\"submit\" name=\"Logout\" class=\"btn btn-default\">"+logStatus+"</button>\n" + 
				"      </form>\n" +
				"</li>\n" + 
				"      </ul>\n" + 
				"    </div>\n" + 
				"  </div>\n" + 
				"</nav>\n" + 
				"\n" + 
				"\n";


	}
	
	public String footer()
	{
		
		return "<div id=\"footer\">\n" + 
	"\n" + 
	"	  <!-- Copyright -->\n" + 
	"	  <div class=\"footer-copyright text-center py-3\">© 2018 Copyright:\n" +  
	"	  </div>\n" + 
	"	  <!-- Copyright -->\n" + 
	"\n" + 
	"	</div>";

	
	}


}
