package com.virginmoney.uk.template;

import java.time.LocalDate;

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
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public LocalDate getDob() {
		return dob;
	}
	
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	
	@Override
	public String toString() {
		return "Person [" +
				"first name: " + this.getFirstName() +
				", last name: " + this.getLastName() +
				", age=" + this.getDob() +
				"]";
	}
}
