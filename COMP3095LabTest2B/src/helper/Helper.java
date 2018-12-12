package helper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Helper {
	public static boolean validateEmail(String email) {
		Pattern p = Pattern.compile("[a-zA-Z0-9]([a-zA-Z0-9])*@(gbc\\.ca)");
		Matcher m = p.matcher(email);
		return m.find();
	}
}
