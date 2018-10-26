package helperClasses;

public class InputFieldValidator {
	
	public boolean isEmpty(String filedValue)
	{
		if(filedValue.equals(""))
		{
			return true;
		}
		return false;
	}
	public boolean isFieldValuesAreEqual(String value1, String value2)
	{
		if(value1.equals(value2))
		{
			return true;
		}
		return false;
	}

}
