package model.login;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import helper.*;
import java.util.Map;
import java.util.HashMap;

public class LoginModel {
	
	public boolean Checklogin(String email, String passwd) {
		Map<String, String> users = new HashMap<String, String>();
		users.put("login@gbc.ca", "labtest2");
		
		if(Helper.validateEmail(email))
		{		
			
			if(users.get(email)!=null && users.get(email).equals(passwd))
				return true;
		}
		return false;
	}
	
}
