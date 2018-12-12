package mvc.servlet.jsp;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/DispatchServlet")
public class DispatchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public DispatchServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		
		RequestDispatcher dispatcher;
		//Create session object
		HttpSession session = request.getSession();
		
		//Get last access time of this web page
		Date creaTime = new Date(session.getCreationTime());
		
		//get last access time of this webpage
		Date lastAccessTime = new Date(session.getLastAccessedTime());
		
		Integer accessCount=0;
		
		//check if this is new comer on the web page.
		
		if(session.isNew()){
			session.setAttribute("name","Hi,welcome!" );
			dispatcher = request.getRequestDispatcher("welcome.jsp");
		}
		else {			
			session.setAttribute("name","Hello,welcome back!" );
			dispatcher = request.getRequestDispatcher("welcomeback.jsp");
		}
		dispatcher.forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
