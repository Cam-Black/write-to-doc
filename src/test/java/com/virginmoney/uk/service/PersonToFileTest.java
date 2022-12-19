package com.virginmoney.uk.service;

import com.virginmoney.uk.entity.Person;
import com.virginmoney.uk.utils.WordDocumentReader;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class PersonToFileTest {

    @Test
    public void helloJohnDoe() {
        WordDocumentReader reader = mock(WordDocumentReader.class);
        PersonToFile toFile = new PersonToFile(reader);

        Person person = new Person();
        person.setFirstName("John");
        person.setLastName("Doe");
        person.setDob(LocalDate.of(2000, 5, 23));

        StringBuilder text = new StringBuilder("Hello ${first_name} ${last_name}. Your date of birth is ${dob}.");
        String expected = "Hello John Doe. Your date of birth is 2000-05-23.";
        when(reader.readDoc()).thenReturn(text);

        assertEquals(expected, toFile.replacePlaceholdersInText(person).toString());

        verify(reader).readDoc();
    }
}