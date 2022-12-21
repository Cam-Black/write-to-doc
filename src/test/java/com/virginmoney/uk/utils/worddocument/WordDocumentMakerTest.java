package com.virginmoney.uk.utils.worddocument;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

public class WordDocumentMakerTest {
    private final WordDocumentMaker maker = new WordDocumentMaker();
    private XWPFDocument doc;
    private Path out;

    @BeforeEach
    void setup() {
        doc = new XWPFDocument();
        out = Paths.get("src/test/resources/output.docx");
    }

    @AfterEach
    void removeTestFiles() throws IOException {
        Files.deleteIfExists(out);
    }

    @Test
    void writeDocumentTest() throws IOException {
        maker.writeDocument(doc, out);
        assertTrue(Files.isRegularFile(out));
    }

    @Test
    void testIOExceptionInWriteDocument() throws IOException {
        doc.close();
        assertThrows(IOException.class, () -> maker.writeDocument(doc, out));
    }
}