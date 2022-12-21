package com.virginmoney.uk.utils.converter;

import com.spire.doc.Document;
import com.spire.doc.FileFormat;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PDFConverter {
    private final Logger LOGGER = LogManager.getLogger();
    private final Document DOC;

    public PDFConverter() {
        super();
        DOC = new Document("output.docx");
    }

    public PDFConverter(Document doc) {
        super();
        DOC = doc;
    }


    public void convertWordToPDF(String output) {
        try (OutputStream out = Files.newOutputStream(Paths.get(output))) {
            LOGGER.info("Converting to PDF...");
            DOC.saveToFile(out, FileFormat.PDF);
            LOGGER.info("Conversion complete.");
        } catch (IOException e) {
            LOGGER.error(e);
            LOGGER.error("Conversion failed. Please check file paths are correct and not empty and input is .docx and output is .pdf format.");
        }
    }
}