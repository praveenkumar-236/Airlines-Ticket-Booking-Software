package com.tgi.springAirlines.Utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorUtil {
	public static boolean EmailIsValid(String emailAddress) {
		String regex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z" + "A-Z]{2,7}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(emailAddress);
		return matcher.matches();
	}
	public static boolean PhoneNumberIsValid(String phoneNumber) {
		String regex="^(\\+91[\\-\\s]?)?[0]?(91)?[789]\\d{9}$";
	                   
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(phoneNumber);
		return matcher.matches();
		
	}

}
