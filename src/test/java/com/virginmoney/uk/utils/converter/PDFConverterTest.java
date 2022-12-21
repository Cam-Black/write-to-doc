package com.virginmoney.uk.utils.converter;

import com.spire.doc.Document;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PDFConverterTest {
    PDFConverter converter;
    String inDoc = "src/test/resources/inputTest.docx";
    String outPdf = "src/test/resources/output.pdf";

    @AfterEach
    void removeTestFiles() throws IOException {
        Files.deleteIfExists(Paths.get(outPdf));
    }

    @Test
    void testPDFCreated() throws IOException {
        Document doc = new Document(inDoc);
        converter = new PDFConverter(doc);
        converter.convertWordToPDF(outPdf);
        assertTrue(Files.isRegularFile(Paths.get(outPdf)));
    }
}