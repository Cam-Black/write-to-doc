package com.virginmoney.uk.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WordDocumentWriter {
    private final Logger LOGGER = LogManager.getLogger();
    private final Path OUT;
    private final WordDocumentMaker MAKER;

    public WordDocumentWriter() {
        super();
        OUT = Paths.get("output.docx");
        MAKER = new WordDocumentMaker();
    }

    public WordDocumentWriter(String out, WordDocumentMaker maker) {
        OUT = Paths.get(out);
        MAKER = maker;
    }

    public boolean populateDoc(StringBuilder text) {
        try (XWPFDocument doc = MAKER.newDocument()) {
            String[] lines = text.toString().split("\n");
            for (String line : lines) {
                XWPFParagraph para = MAKER.newParagraph(doc);
                XWPFRun run = MAKER.newRun(para);
                run.setText(line);
            }
            MAKER.writeDocument(doc, OUT);
            return true;
        } catch (IOException ioe) {
            LOGGER.error(ioe);
            return false;
        }
    }
}