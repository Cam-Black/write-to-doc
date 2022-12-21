package com.virginmoney.uk.utils.converter;

import com.spire.doc.Document;
import com.spire.doc.FileFormat;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PDFConverter {
    private final Logger LOGGER = LogManager.getLogger();
    private final Path DOC_IN;
    private final Path PDF_OUT;
    private final Document DOC;

    public PDFConverter() throws IOException {
        super();
        DOC_IN = Paths.get("output.docx");
        PDF_OUT = Paths.get("output.pdf");
        DOC = new Document(Files.newInputStream(DOC_IN));
    }

    public PDFConverter(String inDoc, String outPDF, Document doc) {
        super();
        DOC_IN = Paths.get(inDoc);
        PDF_OUT = Paths.get(outPDF);
        DOC = doc;
    }

    public PDFConverter(String inDoc, String outPdf) throws IOException {
        super();
        DOC_IN = Paths.get(inDoc);
        PDF_OUT = Paths.get(outPdf);
        DOC = new Document(Files.newInputStream(DOC_IN));
    }

    public boolean convertWordToPDF() {
        try (OutputStream out = Files.newOutputStream(Paths.get(PDF_OUT.toString()))) {
            LOGGER.info("Converting to PDF...");
            DOC.saveToFile(out, FileFormat.PDF);
            LOGGER.info("Conversion complete.");
            if (Files.isRegularFile(PDF_OUT)) return true;
            else throw new IOException();
        } catch (IOException e) {
            LOGGER.error(e);
            LOGGER.error("Conversion failed. Please check file paths are correct and not empty and input is .docx and output is .pdf format.");
            return false;
        }
    }
}