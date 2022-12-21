package com.virginmoney.uk.utils.converter;

import com.spire.doc.Document;
import com.spire.doc.FileFormat;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

public class PDFConverter {
    private static final Logger LOGGER = LogManager.getLogger();

    public static boolean convertWordToPDF(String in, String out) {
        File f = new File(out);
        Document doc = new Document(in);
        LOGGER.info("Converting to PDF...");
        doc.saveToFile(out, FileFormat.PDF);
        if (f.isFile()) {
            LOGGER.info("Conversion complete.");
            return true;
        }
        return false;
    }
}