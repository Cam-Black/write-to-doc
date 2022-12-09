package com.virginmoney.uk.template;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@EqualsAndHashCode
@Getter
@Setter
@ToString
public class Person {
	
	private String firstName;
	private String lastName;
	private LocalDate dob;
	
	public Person() {
	}
	
	public Person(String firstName, String lastName, LocalDate dob) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
	}
}