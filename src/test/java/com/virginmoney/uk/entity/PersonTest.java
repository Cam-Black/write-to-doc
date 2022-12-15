package com.virginmoney.uk.entity;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class PersonTest {
    @Test
    void equalsAndHashCodeTest() {
        EqualsVerifier.simple().forClass(Person.class).verify();
    }

    @Test
    void testToStringNoValues() {
        Person person = new Person();
        String expected = "Person(firstName=null, lastName=null, dob=null)";
        Assertions.assertEquals(expected, person.toString());
    }
    @Test
    void testToStringWithValues() {
        Person person = new Person("John", "Doe", LocalDate.of(2000, 5, 23));
        String expected = "Person(firstName=John, lastName=Doe, dob=2000-05-23)";
        Assertions.assertEquals(expected, person.toString());
    }
}
