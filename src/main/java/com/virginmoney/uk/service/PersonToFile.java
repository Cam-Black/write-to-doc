package com.virginmoney.uk.service;

import com.virginmoney.uk.entity.Person;
import com.virginmoney.uk.utils.FileReader;
import com.virginmoney.uk.utils.FileWriter;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PersonToFile implements ServiceMethods<Person> {

    private final FileWriter FILE_WRITER;
    private final FileReader FILE_READER;

    public PersonToFile() {
        super();
        FILE_WRITER = new FileWriter();
        FILE_READER = new FileReader();
    }

    @Override
    public String replacePlaceholdersInFile(Person person) {
        String firstName = "FIRST_NAME";
        String lastName = "LAST_NAME";
        String dob = "DOB";
        String text = FILE_READER.readDoc();
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
        FILE_WRITER.populateDoc(text);
        return text;
    }
}