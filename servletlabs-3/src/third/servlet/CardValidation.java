package third.servlet;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CardValidation {
	
	public static int calculate(String card)
	{
		int number=0;
	
		String[] array =card.split("");
	
		String regex = "^(?:(?<visa>4[0-9]{12}(?:[0-9]{3})?)|" +
		        "(?<mastercard>5[1-5][0-9]{14})|" +
		        "(?<discover>6(?:011|5[0-9]{2})[0-9]{12})|" +
		        "(?<amex>3[47][0-9]{13})|" +
		        "(?<diners>3(?:0[0-5]|[68][0-9])?[0-9]{11})|" +
		        "(?<jcb>(?:2131|1800|35[0-9]{3})[0-9]{11}))$";
		
		Pattern pattern = Pattern.compile(regex);
		
		for (String cards : array )
		{
		    //Match the card
		    Matcher matcher = pattern.matcher(cards);
		
		    if(matcher.matches()) {
		        //If card is valid then verify which group it belong
		    	matcher.group("mastercard")
		       return number =1;
		    }
		}
		
		return number;
	
	}
	
   
   
}
