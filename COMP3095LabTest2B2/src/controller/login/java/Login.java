package controller.login.java;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.login.ModelLogin;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public Login() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		HttpSession session = request.getSession();
		
		String password = request.getParameter("passowrd");
		String email = request.getParameter("email");
		int attempts = session.getAttribute("attempts")!=null?Integer.parseInt(session.getAttribute("attempts").toString()):0;
		
		
		RequestDispatcher dispatch;
		ModelLogin login = new ModelLogin();
		
		
		if(!login.login(email, password)) {
			attempts++;
			if(attempts<3) {
				session.setAttribute("attempts", attempts);
				session.setAttribute("badLogin", true);
				dispatch = request.getRequestDispatcher("loginAttempts.jsp");
				
			}
			
			dispatch = request.getRequestDispatcher("index.jsp");
		}
		else {
			session.removeAttribute("badLogin");
			dispatch = request.getRequestDispatcher("WEB-INF/PostOfficeForm.jsp");
		}
		dispatch.forward(request, response);
	}

}
