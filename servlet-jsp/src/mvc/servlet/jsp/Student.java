package mvc.servlet.jsp;

public class Student {
	
	private String[] students = {"Igor", "Farhad", "Yash"};
	
	public boolean checkStudents(String name) {
		
		for (String s: students) {           
			if(name.equals(s)) {
				return true;
			}
			
	    }
		return false;
	
		
	}
	
}
