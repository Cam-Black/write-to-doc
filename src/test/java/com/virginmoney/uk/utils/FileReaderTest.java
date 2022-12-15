package com.virginmoney.uk.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FileReaderTest {
    @Test
    void testReadDocReturnsTextFromTestFile() {
        FileReader fileReader = new FileReader("src/test/resources/inputTest.docx");
        String expected = "Hello, this is a test document.\n";

        Assertions.assertEquals(expected, fileReader.readDoc());
    }

    @Test
    void testNoSuchFileException() {
        FileReader fileReader = new FileReader("null.docx");

        Assertions.assertNull(fileReader.readDoc());
    }

    @Test
    void testEmptyFileException() {
        FileReader fileReader = new FileReader("src/test/resources/empty_file_exception_test.txt");

        Assertions.assertNull(fileReader.readDoc());
    }
}