package com.virginmoney.uk.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WordDocumentMaker {
    private final Logger LOGGER = LogManager.getLogger();
    private final Path OUT;

    public WordDocumentMaker() {
        super();
        OUT = Paths.get("output.txt");
    }

    public WordDocumentMaker(String out) {
        OUT = Paths.get(out);
    }

    public XWPFDocument newDocument() {
        return new XWPFDocument();
    }

    public XWPFDocument newDocument(Path in) {
        try {
            return new XWPFDocument(Files.newInputStream(in));
        } catch (IOException e) {
            LOGGER.error(e);
            return null;
        }
    }

    public XWPFParagraph newParagraph(XWPFDocument doc) {
        return doc.createParagraph();
    }

    public XWPFRun newRun(XWPFParagraph para) {
        return para.createRun();
    }

    public boolean writeDocument(XWPFDocument document) {
        try {
            document.write(Files.newOutputStream(OUT));
            return true;
        } catch (IOException e) {
            LOGGER.error(e);
            return false;
        }
    }
}