package com.mosa_architect.training.csv;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

import com.opencsv.bean.CsvToBeanBuilder;

public class CSVDataFinder {
	public static void main(String[] args) throws FileNotFoundException, IOException {

		ResourceBundle rb = ResourceBundle.getBundle("training-csv");
		String filePath = rb.getString("user_csv_resource_path");

		try (FileReader fileReader = new FileReader(filePath); Scanner scan = new Scanner(System.in)) {

			System.out.print("検索ワードを入力：");
			String keyword = scan.next();

			List<User> userList = new CsvToBeanBuilder<User>(fileReader).withType(User.class).build().parse();
			for (User usr : userList) {
				if (TrainingCSVUtils.contains(keyword, usr)) {
					System.out.printf("%1$s %2$s%n", usr.getFirstName(), usr.getLastName());
				}
			}
		}
	}
}
