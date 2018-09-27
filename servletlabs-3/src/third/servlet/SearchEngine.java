package third.servlet;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/search")  // make sure the action on the form is the same
public class SearchEngine extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public SearchEngine() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		
		String card = request.getParameter("card");
		
		
		String s = CardValidation.CardType.detect(card).toString();
		
		if(s == "VISA")
		{
			response.sendRedirect("http://www.visa.com");
		}
		else if(s == "MASTERCARD")
		{
			response.sendRedirect("http://www.mastercard.com");
		}
		else if(s == "AMERICAN_EXPRESS")
		{
			response.sendRedirect("http://www.americanexpress.com/canada");
		}else  {
			response.sendRedirect("creditCard.html"); // this is send me to a other html form on my project
		}
		
	}
	

}







