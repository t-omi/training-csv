package com.csv.training;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.opencsv.bean.CsvToBeanBuilder;

public class SearchCSVData {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws FileNotFoundException, IOException {

		FileReader fileReader = null;
		
		System.out.print("検索ワードを入力：");
		Scanner scan = new Scanner(System.in);
		String keyword = scan.next();

		fileReader = new FileReader("src/main/resources/user_info.csv");
		List<User> dataObjList = new CsvToBeanBuilder<User>(fileReader).withType(User.class).build().parse();
		for (User obj : dataObjList) {
			if (Utils.isMatch(keyword, obj)) {
				System.out.println(obj.getFirstName() + " " + obj.getLastName());
			}
		}
		fileReader.close();
	}
}
