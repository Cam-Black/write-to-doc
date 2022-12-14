package com.virginmoney.uk.service;

import com.virginmoney.uk.entity.Person;
import com.virginmoney.uk.utils.FileReader;
import com.virginmoney.uk.utils.FileWriter;

public class PersonToFile implements ServiceMethods<Person> {

    @Override
    public String replacePlaceholdersInFile(Person person) {
        String firstName = "FIRST_NAME";
        String lastName = "LAST_NAME";
        String dob = "DOB";
        String text = FileReader.readDoc();
        assert text != null;
        if (text.contains(firstName)) {
            text = text.replace(firstName, person.getFirstName());
        }
        if (text.contains(lastName)) {
            text = text.replace(lastName, person.getLastName());
        }
        if (text.contains(dob)) {
            text = text.replace(dob, person.getDob().toString());
        }
        FileWriter.populateDoc(text);
        return text;
    }
}