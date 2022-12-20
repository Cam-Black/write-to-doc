package com.virginmoney.uk.utils.worddocument;

import com.virginmoney.uk.utils.worddocument.WordDocumentMaker;
import com.virginmoney.uk.utils.worddocument.WordDocumentReader;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNull;

public class WordDocumentReaderTest {
    private WordDocumentMaker maker;

    @BeforeEach
    void setup() {
        maker = new WordDocumentMaker();
    }

    @Test
    void testReadDocReturnsTextFromTestFile() {
        WordDocumentReader reader = new WordDocumentReader("src/test/resources/inputTest.docx", maker);
        String expected = "Hello, this is a test document.";

        List<XWPFParagraph> lines = reader.readDoc();
        StringBuilder textToString = new StringBuilder();
        lines.forEach(el -> textToString.append(el.getText()));
        Assertions.assertEquals(expected, textToString.toString());
    }

    @Test
    void testNoSuchFileException() {
        WordDocumentReader wordDocumentReader = new WordDocumentReader("null.docx", maker);

        assertNull(wordDocumentReader.readDoc());
    }

    @Test
    void testEmptyFileException() {
        WordDocumentReader wordDocumentReader = new WordDocumentReader("src/test/resources/empty_file_exception_test.txt", maker);

        assertNull(wordDocumentReader.readDoc());
    }
}