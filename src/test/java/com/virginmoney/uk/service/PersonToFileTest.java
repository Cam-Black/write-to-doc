package com.virginmoney.uk.service;

import com.virginmoney.uk.entity.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PersonToFileTest {
    @Mock
    PersonToFile toFile;

    @Test
    public void helloJohnDoe() {
        Person person = new Person();
        String text = "Hello John Doe. Your date of birth is 2000-05-23.";

        Mockito.when(toFile.replacePlaceholdersInFile(person)).thenReturn(text);

        Assertions.assertEquals(text, toFile.replacePlaceholdersInFile(person));
        Mockito.verify(toFile, Mockito.times(1)).replacePlaceholdersInFile(person);
    }
}