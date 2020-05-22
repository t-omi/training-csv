package com.mosa_architect.training.csv;

import java.util.List;
import java.util.regex.Pattern;

public class TrainingCSVUtils {

	public static boolean contains(String keyword, User usr) {
		String row = usr.getFirstName() + usr.getLastName() + usr.getMailAddress() + usr.getPhoneNumber()
				+ usr.getAddress() + usr.getRemarks();
		return row.contains(keyword);
	}

	public static boolean UserCSVValidation(List<User> userList) {
		for (User usr : userList) {
			if (!TrainingCSVUtils.isMailAddress(usr.getMailAddress())
					|| !TrainingCSVUtils.isPhoneNumber(usr.getPhoneNumber())) {
				System.out.print("CSVフォーマットが適切ではありません。");
				return false;
			}
		}
		return true;
	}

	public static boolean isMailAddress(String mailAddress) {
		Pattern pattern = Pattern.compile("^.*@.*\\..*$"); //*@*.*となっているかチェック
		return !mailAddress.isEmpty() && pattern.matcher(mailAddress).matches();
	}

	public static boolean isPhoneNumber(String phoneNumber) {
		Pattern pattern = Pattern.compile("^[0-9]*$"); // 数字のみで構成されているかチェック
		return !phoneNumber.isEmpty() && pattern.matcher(phoneNumber).matches();
	}
}
