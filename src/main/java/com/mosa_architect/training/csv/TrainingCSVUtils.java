package com.mosa_architect.training.csv;

public class TrainingCSVUtils {

	public static boolean contains(String keyword, User usr) {

		String row = usr.getFirstName() + usr.getLastName() + usr.getMailAddress() + usr.getPhoneNumber();
		return row.contains(keyword);
	}
}
