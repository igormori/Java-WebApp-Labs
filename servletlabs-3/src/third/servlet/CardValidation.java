package third.servlet;

import java.util.regex.Matcher;

import java.util.regex.Pattern;

public class CardValidation {
	

		//special function to define collection of constants
		public enum CardType {

		    UNKNOWN,
		    VISA("^4[0-9]{12}(?:[0-9]{3}){0,2}$"),
		    MASTERCARD("^(?:5[1-5]|2(?!2([01]|20)|7(2[1-9]|3))[2-7])\\d{14}$"),
		    AMERICAN_EXPRESS("^3[47][0-9]{13}$");
		  
			// to identify patterns this have special function named matches that identify patterns 
			//accordly with the constants above
		    private Pattern pattern;

		    CardType() {
		        this.pattern = null;
		    }

		    CardType(String pattern) {
		        this.pattern = Pattern.compile(pattern);
		    }

		    public static CardType detect(String cardNumber) {

		        for (CardType cardType : CardType.values()) {
		            if (null == cardType.pattern) continue;
		            if (cardType.pattern.matcher(cardNumber).matches())
		            if(cardType == VISA)
		            {
		            	return cardType;
		            }
		            else if(cardType == MASTERCARD)
		            {
		            	return cardType;
		            }
		            else if(cardType == AMERICAN_EXPRESS)
		            {
		            	return cardType;
		            }

		        }

		        return UNKNOWN;
		    }

		
	
	}
	
   
   
}
