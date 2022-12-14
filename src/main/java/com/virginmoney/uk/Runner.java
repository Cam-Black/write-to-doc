package com.virginmoney.uk;

import com.virginmoney.uk.entity.Person;
import com.virginmoney.uk.service.PersonToFile;

import java.time.LocalDate;

public class Runner {
    public static void main(String[] args) {
        PersonToFile tf = new PersonToFile("input.docx");
        Person p = new Person("John", "Doe", LocalDate.of(2000, 5, 23));
        tf.replacePlaceholdersInFile(p);
    }
}