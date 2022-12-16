package com.virginmoney.uk.service;

import com.virginmoney.uk.entity.Person;
import com.virginmoney.uk.utils.FileReader;
import com.virginmoney.uk.utils.FileWriter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.anyString;

@ExtendWith(MockitoExtension.class)
public class PersonToFileTest {
    @Mock
    FileWriter fileWriter;
    @Mock
    FileReader fileReader;
    @InjectMocks
    PersonToFile toFile;

    @Test
    public void helloJohnDoe() {
        Person person = new Person("John", "Doe", LocalDate.of(2000, 5, 23));
        String text = "Hello FIRST_NAME LAST_NAME. Your date of birth is DOB.";
        String expected = "Hello John Doe. Your date of birth is 2000-05-23.";

        Mockito.when(fileReader.readDoc()).thenReturn(text);
        Mockito.when(fileWriter.populateDoc(anyString())).thenReturn(expected);

        Assertions.assertEquals(expected, toFile.replacePlaceholdersInFile(person));

        Mockito.verify(fileReader, Mockito.times(1)).readDoc();
        Mockito.verify(fileWriter, Mockito.times(1)).populateDoc(expected);
    }
}