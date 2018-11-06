/*********************************************************************************
* Project: < COMP 3095 – Java Web Application Development>
* Assignment: < Assignment -1 >
* Author(s): < Igor Mori, Md Farhad Hossain , Yash  Thanki, Arifur Rahman >
* Student Number: < 101045762, 101056010, 101093832, 100883999>
* Date: 10/28/2018
* Description: <This Servlet will redirect the page to the login page after the user click logout on the dashboard throught Htmls form >
*********************************************************************************/
package allServlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public Logout() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session=request.getSession(false);
			response.sendRedirect("Login");
			session.invalidate();

	}

}
