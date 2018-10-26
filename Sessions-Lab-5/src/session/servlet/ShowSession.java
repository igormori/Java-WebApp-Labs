package session.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/ShowSession")
public class ShowSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ShowSession() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Create session object
				HttpSession session = request.getSession();
				
				//Get last access time of this web page
				Date creaTime = new Date(session.getCreationTime());
				
				//get last access time of this webpage
				Date lastAccessTime = new Date(session.getLastAccessedTime());
				
				String heading;
				Integer accessCount=0;
				String accessCountKey ="AccessCountKey";
				String userID = "COMP 3095 - username";
				
				//check if this is new comer on the web page.
				
				if(session.isNew()){
					heading ="welcome, " + userID;
				}
				else {
					heading ="welcome back, "+ userID;
					accessCount = (Integer)session.getAttribute(accessCountKey);
					accessCount =+1;
				}
				
				session.setAttribute(accessCountKey,accessCount);
				response.setContentType("text/html");
				PrintWriter out= response.getWriter();
				
				out.println("heading : " + heading + "</br>"+ 
				"session ID: "+ session.getId() + "</br>"+ 
				"Creation Time: " + creaTime +"</br>"+ 
				"last Time: " +lastAccessTime +"</br>"+ 
				"User id" + userID +"</br>"+ 
				"number of visits: " + accessCount +
				"value: "+ session.getAttributeNames());
			
				 
				 
				 
				
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
