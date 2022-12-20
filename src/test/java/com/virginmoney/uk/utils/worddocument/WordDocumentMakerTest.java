package com.virginmoney.uk.utils.worddocument;

import com.virginmoney.uk.utils.worddocument.WordDocumentMaker;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WordDocumentMakerTest {

    private final WordDocumentMaker maker = new WordDocumentMaker();
    private XWPFDocument doc;
    private XWPFParagraph para;
    XWPFRun run;
    Path in;
    Path out;

    @BeforeEach
    void setup() {
        doc = new XWPFDocument();
        para = doc.createParagraph();
        run = para.createRun();
        in = Paths.get("src/test/resources/inputTest.docx");
        out = Paths.get("src/test/resources/outputTest.docx");
    }

    @Test
    void writeDocumentTest() {
        assertTrue(maker.writeDocument(doc, out));
    }

    @Test
    void testIOExceptionInWriteDocument() throws IOException {
        doc.close();
        assertFalse(maker.writeDocument(doc, out));
    }
}
