
package first.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * Servlet implementation class HelloWorld
 */
@WebServlet("/HelloWorld")
public class HelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloWorld() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.println("");
		pw.println("");
		pw.println("");
		pw.println("<h1>Hello World</h1>");
		pw.println("");
		
		String result = "";
		// factor  the number
		String number = request.getParameter("number");
		int intNumber = Integer.parseInt(number);		
		int i,fact=1;  
		 for(i=1;i<=intNumber;i++){    
		      fact=fact*i;    
		 }    
		result = Integer.toString(fact);	
		PrintWriter pw2 = response.getWriter();
		pw2.println("<h2>");
		pw2.println("My number is: "+ number + "</br>");
		pw2.println("My factorial number is: "+ result);
		pw2.println("</h2>");
		pw2.println("");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.println("<h2>");
		pw.println("Username: "+userName);
		pw.println("</h2><h2>");
		pw.println("Inputed password: "+password);
		pw.println("</h2>");
		pw.println("");
		doGet(request, response);
	}

}



