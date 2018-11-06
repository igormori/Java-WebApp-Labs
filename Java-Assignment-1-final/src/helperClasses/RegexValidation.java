/*********************************************************************************
* Project: < COMP 3095 – Java Web Application Development>
* Assignment: < Assignment -1 >
* Author(s): < Igor Mori, Md Farhad Hossain , Yash  Thanki, Arifur Rahman >
* Student Number: < 101045762, 101056010, 101093832, 100883999>
* Date: 10/28/2018
* Description: <This java class will check if the email, password, and first name have the right format >
*********************************************************************************/
package helperClasses;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexValidation {
	
	public final String regFirstorlastname ="^[A-Za-z]+$";
	public final String regEmail ="^\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
	public final String regPassword="(?=^.{6,12}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$";

	public  boolean firstorlast(String inpfield)
	{

			Pattern p = Pattern.compile(regFirstorlastname);
			Matcher m = p.matcher(inpfield);
			if(m.matches()) {
				return true;
			}
			else
			{
				return false;
			}
			

		
	}
	public boolean email(String inpfield)
	{
		
		Pattern p = Pattern.compile(regEmail);
		Matcher m = p.matcher(inpfield);
		if(m.matches()) {
			return true;
		}
		else
		{
			return false;
		}

	}
	
	public boolean password(String inpfield)
	{
		
		Pattern p = Pattern.compile(regPassword);
		Matcher m = p.matcher(inpfield);
		if(m.matches()) {
			return true;
		}
		else
		{
			return false;
		}

	}

}
