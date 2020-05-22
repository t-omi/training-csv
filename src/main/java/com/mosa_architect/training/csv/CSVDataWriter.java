package com.mosa_architect.training.csv;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

import com.opencsv.CSVWriterBuilder;
import com.opencsv.ICSVWriter;

public class CSVDataWriter {
	public void CSVWrite(List<User> usrList, String createFileName) throws IOException {

		File file = new File(createFileName);
		OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(file), "Shift_JIS");
		BufferedWriter bw = new BufferedWriter(osw);
		CSVWriterBuilder builder = new CSVWriterBuilder(bw);

		builder.withSeparator(','); // カンマ区切り
		builder.withLineEnd("\r\n"); // 改行コード(CR+LF)

		try (ICSVWriter csvWriter = builder.build()) {
			
			for (User usr : usrList) {
				csvWriter.writeNext(
						new String[] { usr.getFirstName(), usr.getLastName(), usr.getMailAddress(), usr.getRemarks() },
						true);	
			}
		} finally {
			osw.close();
			bw.close();
		}
	}
}
