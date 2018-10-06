package labtest.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/form")
public class form extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public form() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String  zip = request.getParameter("zip");
		String  email = request.getParameter("Email");
		String  address = request.getParameter("address");
		String  city = request.getParameter("city");
		String  fName = request.getParameter("firstName");
		String  lName = request.getParameter("lastName");
		String  item1 = request.getParameter("item1");
		String item2 = request.getParameter("item2");
		String item3 = request.getParameter("item3");
		String  Qphone = request.getParameter("Qphone");
		int QphoneInt = Integer.parseInt(Qphone);
		double price =0;
		
		
		if(validation.Validation(zip) == true && validation.Validation(zip) == true)
		{
		
			response.setContentType("text/html");
			PrintWriter write = response.getWriter();
			write.println("name: "+ fName + lName);
			write.println("more: "+ email + city + address);
			if(item1.equals("iPhoneX"))
			{
				price =1000;
				price = price * QphoneInt;
				String priceStr = Double.toString(price);
				write.println("name: "+item1+ "$"+ priceStr);
				
			}
			if(item1.equals("iPhone8+"))
			{
				price =800;
				price = price * QphoneInt;
				String priceStr = Double.toString(price);
				write.println("name: "+item1+ "$"+ priceStr);
				
			}
			if(item1.equals("Xiaomi"))
			{
				price =750;
				price = price * QphoneInt;
				String priceStr = Double.toString(price);
				write.println("name: "+item1+ "$"+ priceStr);
				
			}
		
			
			
		}
		
		
	}
		
}
