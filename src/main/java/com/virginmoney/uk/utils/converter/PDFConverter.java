package com.virginmoney.uk.utils.converter;

import com.spire.doc.Document;
import com.spire.doc.FileFormat;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PDFConverter {
    private static final Logger LOGGER = LogManager.getLogger();

    public static void convertWordToPDF(String in, String out) {
        Document doc = new Document(in);
        LOGGER.info("Converting to PDF...");
        doc.saveToFile(out, FileFormat.PDF);
        LOGGER.info("Conversion complete.");
    }
}