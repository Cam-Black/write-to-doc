package com.virginmoney.uk.service;

import com.virginmoney.uk.entity.Person;
import com.virginmoney.uk.utils.worddocument.WordDocumentMaker;
import com.virginmoney.uk.utils.worddocument.WordDocumentReader;
import com.virginmoney.uk.utils.worddocument.WordDocumentWriter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class PersonToFileTest {
    private final Logger LOGGER = LogManager.getLogger();
    private final WordDocumentMaker maker = new WordDocumentMaker();


    @Test
    void helloJohnDoe() {
        List<XWPFParagraph> lines = new ArrayList<>();

        try (XWPFDocument doc = maker.newDocument()) {
            XWPFParagraph para = maker.newParagraph(doc);
            XWPFRun run = maker.newRun(para);
            run.setText("Hello ${first_name} ${last_name}. Your date of birth is ${dob}.");
            lines.add(para);
        } catch (IOException e) {
            LOGGER.error(e);
        }

        WordDocumentReader reader = mock(WordDocumentReader.class);
        WordDocumentWriter writer = mock(WordDocumentWriter.class);

        PersonToFile toFile = new PersonToFile(reader, writer);
        String expected = "Hello John Doe. Your date of birth is 2000-05-23.\n";
        Person person = new Person();
        person.setFirstName("John");
        person.setLastName("Doe");
        person.setDob(LocalDate.of(2000, 5, 23));

        when(reader.readDoc()).thenReturn(lines);
        when(writer.populateDoc(any(StringBuilder.class))).thenReturn(true);

        assertEquals(expected, toFile.replacePlaceholdersInText(person).toString());

        verify(reader).readDoc();
        verify(writer).populateDoc(any(StringBuilder.class));
    }
}