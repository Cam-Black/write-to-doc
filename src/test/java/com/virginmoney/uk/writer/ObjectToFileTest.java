package com.virginmoney.uk.writer;

import com.virginmoney.uk.template.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ObjectToFileTest {
    private final ObjectToFile<Person> OTF = new ObjectToFile<>();

    @Test
    public void convertObjToStringTest() {
        //arrange
        Person person = new Person("John", "Doe", LocalDate.of(2000, 5, 23));
        String expected = "Person(firstName=John, lastName=Doe, dob=2000-05-23)\n";

        //act
        String actual = OTF.convertObjToString(person);

        //assert
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void populateAndSaveDocHasOneParagraph() {
        //arrange
        List<Person> people = new ArrayList<>();
        Person person = new Person("John", "Doe", LocalDate.of(2000, 5, 23));
        people.add(person);
        int expected = 1;

        //act
        int actual = OTF.populateAndSaveDoc(people);

        //assert
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void populateAndSaveDocHasThreeParagraphs() {
        List<Person> people = new ArrayList<>();
        Person personOne = new Person();
        Person persontTwo = new Person();
        Person personThree = new Person();
        people.add(personOne);
        people.add(persontTwo);
        people.add(personThree);
        int expected = 3;

        //act
        int actual = OTF.populateAndSaveDoc(people);

        //assert
        Assertions.assertEquals(expected, actual);
    }
}