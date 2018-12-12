package mvc.servlet.jsp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Controller() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int num = Integer.parseInt(request.getParameter("value"));
		String method = request.getParameter("method");
		
		
		Model m = new Model();
		
		RequestDispatcher dispatcher;
		HttpSession session = request.getSession();
		
		if(method.equals("square")) {
			session.setAttribute("square", m.square(num));
			dispatcher = request.getRequestDispatcher("square.jsp");
		}
		else if(method.equals("factorial")) {
			session.setAttribute("factorial", m.factorial(num));
			dispatcher = request.getRequestDispatcher("factorial.jsp");
		}
		else {
			session.setAttribute("random", m.random(num));
			dispatcher =request.getRequestDispatcher("random.jsp");
			
		}
		dispatcher.forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
