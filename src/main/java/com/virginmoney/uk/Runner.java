package com.virginmoney.uk;

import com.virginmoney.uk.template.Person;
import com.virginmoney.uk.writer.PersonToFile;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Runner {
	public static void main(String[] args) {
		PersonToFile toFile = new PersonToFile();
		List<Person> people = new ArrayList<>();
		Person one = new Person("John", "Doe", LocalDate.of(2000, 5, 11));
		Person two = new Person("Jane", "Doe", LocalDate.of(2020, 7, 16));
		people.add(one);
		people.add(two);
		toFile.populateAndSaveDoc(people);
	}
}
