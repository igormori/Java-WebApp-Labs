package labtest.servlet;


import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class validation {
	
	 public static final String postal = "^(?!.*[DFIOQU])[A-VXY][0-9][A-Z] ?[0-9][A-Z][0-9]$";
	 public static final String email = "[A-Za-z0-9+_.-]+@(.+)$";
	

	public static Boolean Validation(String zip) {
		
		Pattern p = Pattern.compile(postal);
		Matcher m= p.matcher(zip);		
		if (m.matches())
		{
			return true;
		}else {
			return false;
			
		}
		
		   
	 } 

}
