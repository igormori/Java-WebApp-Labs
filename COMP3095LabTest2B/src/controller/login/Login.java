package controller.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.login.LoginModel;
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
		
		
		String email = request.getParameter("email");
		String passowrd = request.getParameter("passwd");
		int attempts = session.getAttribute("attempts")!=null?Integer.parseInt(session.getAttribute("attempts").toString()):0;
		
		
		LoginModel login = new LoginModel();
		RequestDispatcher dispatch;
		
		if(!login.Checklogin(email, passowrd)) {
			attempts++;
			if(attempts<3) {
				session.setAttribute("attempts", attempts);
				session.setAttribute("errorLogin", true);
			}
			
			dispatch = request.getRequestDispatcher("login.jsp");
		}
		else {
			session.removeAttribute("errorLogin");
			dispatch = request.getRequestDispatcher("holiday.jsp");
		}
		dispatch.forward(request, response);
	}

}
