package com.virginmoney.uk.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class FileWriterTest {
    @Test
    void testFileContainsAParagraph() {
        FileWriter fileWriter = new FileWriter("src/test/resources/output.docx");
        String text = "Hello World.\n";

        Assertions.assertEquals(text, fileWriter.populateDoc(text));
    }
}