package com.mosa_architect.training.csv;

import com.opencsv.bean.CsvBindByName;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

	@CsvBindByName(column = "first_name")
	private String firstName;

	@CsvBindByName(column = "last_name")
	private String lastName;

	@CsvBindByName(column = "phone_number")
	private String phoneNumber;

	@CsvBindByName(column = "mail_address")
	private String mailAddress;
	
	@CsvBindByName(column = "address")
	private String address;
	
	@CsvBindByName(column = "remarks")
	private String remarks;

}
