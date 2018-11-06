/*********************************************************************************
* Project: < COMP 3095 – Java Web Application Development>
* Assignment: < Assignment -1 >
* Author(s): < Igor Mori, Md Farhad Hossain , Yash  Thanki, Arifur Rahman >
* Student Number: < 101045762, 101056010, 101093832, 100883999>
* Date: 10/28/2018
* Description: <This java class will check if the fields are equals or if or empty >
*********************************************************************************/

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
