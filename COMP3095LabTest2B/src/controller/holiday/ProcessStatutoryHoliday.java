package controller.holiday;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.holiday.ModelHoliday;

@WebServlet("/ProcessStatutoryHoliday")
public class ProcessStatutoryHoliday extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProcessStatutoryHoliday() {

    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatch;
		HttpSession session = request.getSession();
		ModelHoliday h = new ModelHoliday();
		
		String month = request.getParameter("month");
		String year = request.getParameter("year");
		String yearMatch = h.matchAb(year,month);
	
		session.setAttribute("holiday", month + " in "+ year);
		session.setAttribute("result", yearMatch);
		

		dispatch = request.getRequestDispatcher("holiday.jsp");
		dispatch.forward(request, response);
	}

}
