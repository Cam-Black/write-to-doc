package com.virginmoney.uk.utils.worddocument;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WordDocumentMaker {

    public WordDocumentMaker() {
        super();
    }

    public XWPFDocument newDocument() {
        return new XWPFDocument();
    }

    public XWPFDocument newDocument(Path in) throws IOException {
        return new XWPFDocument(Files.newInputStream(in));
    }

    public XWPFParagraph newParagraph(XWPFDocument doc) {
        return doc.createParagraph();
    }

    public XWPFRun newRun(XWPFParagraph para) {
        return para.createRun();
    }

    public void writeDocument(XWPFDocument document, Path out) throws IOException {
            document.write(Files.newOutputStream(out));
    }
}