package com.virginmoney.uk.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WordDocumentReaderTest {
    @Test
    void testReadDocReturnsTextFromTestFile() {
        WordDocumentReader wordDocumentReader = new WordDocumentReader("src/test/resources/inputTest.docx");
        String expected = "Hello, this is a test document.\n";

        Assertions.assertEquals(expected, wordDocumentReader.readDoc());
    }

    @Test
    void testNoSuchFileException() {
        WordDocumentReader wordDocumentReader = new WordDocumentReader("null.docx");

        Assertions.assertNull(wordDocumentReader.readDoc());
    }

    @Test
    void testEmptyFileException() {
        WordDocumentReader wordDocumentReader = new WordDocumentReader("src/test/resources/empty_file_exception_test.txt");

        Assertions.assertNull(wordDocumentReader.readDoc());
    }
}