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
