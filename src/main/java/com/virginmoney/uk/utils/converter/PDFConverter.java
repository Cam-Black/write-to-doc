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

    public PDFConverter(Document docToConvert) {
        super();
        DOC = docToConvert;
    }


    public void convertWordToPDF(String output) throws IOException {
        OutputStream out = Files.newOutputStream(Paths.get(output));
        LOGGER.info("Converting to PDF...");
        DOC.saveToFile(out, FileFormat.PDF);
        LOGGER.info("Conversion complete.");
    }
}