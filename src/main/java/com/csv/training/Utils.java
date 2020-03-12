package com.csv.training;

import java.util.regex.Pattern;

public class Utils {

	public static boolean isMatch(String keyword, User obj) {

		String row = obj.getFirstName() + obj.getLastName() + obj.getMailAddress() + obj.getPhoneNumber();
		Pattern pattern = Pattern.compile("^(?=.*" + keyword +").*$");
		return pattern.matcher(row).matches();
	}
}
