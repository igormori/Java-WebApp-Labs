package model.login;

import java.util.HashMap;
import java.util.Map;

import controller.helper.Help;

public class ModelLogin {
	
	public boolean login(String email, String passwd) {
		
		Map<String, String> users = new HashMap<String, String>();
		users.put("student@gbc.ca", "labtest2");
	
		
		if(Help.validateEmail(email)){		
			if(users.get(email)!=null && users.get(email).equals(passwd))
				return true;
		}
		return false;
	}

}
