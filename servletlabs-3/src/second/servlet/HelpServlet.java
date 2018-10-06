package second.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/HelpServlet")
public class HelpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public HelpServlet() {
        super();
      }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
						
						out.println("<style>\r\n" + 
								"table {\r\n" + 
								"    font-family: arial, sans-serif;\r\n" + 
								"    border-collapse: collapse;\r\n" + 
								"    width: 100%;\r\n" + 
								"}\r\n" + 
								"\r\n" + 
								"td, th {\r\n" + 
								"    border: 1px solid #dddddd;\r\n" + 
								"    text-align: left;\r\n" + 
								"    padding: 8px;\r\n" + 
								"}\r\n" + 
								"\r\n" + 
								"tr:nth-child(even) {\r\n" + 
								"    background-color: #dddddd;\r\n" + 
								"}\r\n" + 
								"</style>");
						out.println("\r\n" + 
								"<table>\r\n" + 
								"  <tr>\r\n" + 
								"    <th>Card Company</th>\r\n" + 
								"    <th>Example of card Number</th>\r\n" + 
								"  </tr>\r\n" + 
								"  <tr>\r\n" + 
								"    <td>VISA</td>\r\n" + 
								"    <td>4225061423332140</td>\r\n" + 
								"  </tr>\r\n" + 
								"  <tr>\r\n" + 
								"    <td>MASTERCARD</td>\r\n" + 
								"    <td>575720348860321</td>\r\n" + 
								"  </tr>"+
								"  <tr>\r\n" + 
								"    <td>AMARICAN EXPRESS</td>\r\n" + 
								"    <td>375720348860321</td>\r\n" + 
								"  </tr>"+
								"</table>");
						out.println("<form action=\"http://localhost:8081/servletlabs-3\" method=\"get\">\r\n" + 
								" 		<input type=\"submit\" value=\"Back\">\r\n" + 
								"		</form>");
						out.print("</body>");
						out.print("</html>");
						
	}

}
