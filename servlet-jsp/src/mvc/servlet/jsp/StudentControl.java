package mvc.servlet.jsp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
	
@WebServlet("/StudentControl")
public class StudentControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public StudentControl() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String student1 = request.getParameter("studentName");
		
		Student s = new Student();
		
		
		RequestDispatcher dispatcher;
		HttpSession session = request.getSession();
		
		if(s.checkStudents(student1)) {
			session.setAttribute("student", "Present");
			dispatcher = request.getRequestDispatcher("student.jsp");
		}
		else {
			session.setAttribute("student", "Absent");
			dispatcher = request.getRequestDispatcher("student.jsp");
		}
	
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
