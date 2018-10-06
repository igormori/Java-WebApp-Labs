package labtest.servlet;


//Igor Mori
//101045762

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/COMP3095LabTest1B")
public class COMP3095LabTest1B extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public COMP3095LabTest1B() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paswd = request.getParameter("password");
		String user = request.getParameter("username");
		
		if(user.equals("GBC") && paswd.equals("p@ssword") ) {
			response.sendRedirect("form.html");
		}else {
			
			response.sendRedirect("invalidLogin.html");
			
		}
	

		
	
		
	}

}
