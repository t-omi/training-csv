package com.mosa_architect.training.csv;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

import com.opencsv.bean.CsvToBeanBuilder;

public class CSVDataFinder {
	public static void main(String[] args) throws FileNotFoundException, IOException {

		ResourceBundle rb = ResourceBundle.getBundle("training-csv");
		String filePath = rb.getString("user2_csv_resource_path");
		String createFileName = rb.getString("create_user2_csv_filename");
		
		Boolean csvOutputMode = true;

		try (FileReader fileReader = new FileReader(filePath); Scanner scan = new Scanner(System.in)) {

			List<User> userList = new CsvToBeanBuilder<User>(fileReader).withType(User.class).build().parse();

			if (TrainingCSVUtils.UserCSVValidation(userList)) { // CSVファイル入力内容バリデーション
				System.out.print("検索ワードを入力：");
				String keyword = scan.next();

				List<User> usrWrite = new ArrayList<User>(); // CSVDataWriterに渡す用

				for (User usr : userList) {
					if (TrainingCSVUtils.contains(keyword, usr)) {
						System.out.printf("%1$s %2$s %3$s %4$s%n", usr.getFirstName(), usr.getLastName(),
								usr.getMailAddress(), usr.getRemarks());
						usrWrite.add(usr);
					}
				}
				if (csvOutputMode) {
					CSVDataWriter csvDataWriter = new CSVDataWriter();
					csvDataWriter.CSVWrite(usrWrite, createFileName);
				}
			}
		}
	}
}
