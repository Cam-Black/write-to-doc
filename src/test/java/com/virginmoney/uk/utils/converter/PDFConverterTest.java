package com.virginmoney.uk.utils.converter;

import com.spire.doc.Document;
import com.spire.doc.FileFormat;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class PDFConverterTest {
    PDFConverter converter;
    String outPdf = "src/test/resources/outputTest.pdf";
    String inDoc = "src/test/resources/inputTest.docx";

    @AfterEach
    void removeTestFiles() throws IOException {
        Files.deleteIfExists(Paths.get(outPdf));
    }

    @Test
    void testPDFCreated() {
        assertTrue(PDFConverter.convertWordToPDF("src/test/resources/inputTest.docx", "src/test/resources/outputTest.pdf"));
    }
}