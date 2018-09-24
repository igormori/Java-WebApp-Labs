package third.servlet;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class SearchEngine
 */
@WebServlet("/search")  // make sure the action on the form is the same
public class SearchEngine extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchEngine() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		
		String card = request.getParameter("card");
		
		CardValidation.CardType.detect(card);
		if(CardValidation.s == 4)
		{
			response.sendRedirect("http://www.visa.com");
		}
		else if(CardValidation.s == 5)
		{
			response.sendRedirect("http://www.mastercard.com");
		}
		else if(CardValidation.s == 3)
		{
			response.sendRedirect("http://www.americanexpress.com/canada");
		}
		System.out.println(CardValidation.CardType.detect(card));
			
	}
	

}







