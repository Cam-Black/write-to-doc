package com.virginmoney.uk.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import javax.print.Doc;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WordDocumentWriter {
    private final Logger LOGGER = LogManager.getLogger();
    private final Path OUT;
    private final DocumentFactory DOC;

    public WordDocumentWriter() {
        super();
        OUT = Paths.get("output.docx");
        DOC = new DocumentFactory();
    }

    public WordDocumentWriter(String out, DocumentFactory documentFactory) {
        OUT = Paths.get(out);
        DOC = documentFactory;
    }

    public String populateDoc(String text) {
        try (XWPFDocument doc = DOC.createDoc();
             OutputStream out = Files.newOutputStream(OUT)) {
            StringBuilder sb = new StringBuilder();
            LOGGER.info("Document Created.");
            String[] lines = text.split("\n");
            for (String line : lines) {
                XWPFParagraph para = DOC.createParagraph(doc);
                XWPFRun run = DOC.createRun(para);
                run.setText(line);
                sb.append(line);
                sb.append("\n");
            }
            LOGGER.info("Document saved.");
            DOC.writeDocument(doc, out);
            return sb.toString();
        } catch (IOException ioe) {
            LOGGER.error(ioe);
        }
        return null;
    }
}