package com.virginmoney.uk.utils.converter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PDFConverterTest {

    @Test
    void testPDFCreated() {
        assertTrue(PDFConverter.convertWordToPDF("src/test/resources/inputTest.docx", "src/test/resources/outputTest.pdf"));
    }
}