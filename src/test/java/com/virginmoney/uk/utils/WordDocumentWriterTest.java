package com.virginmoney.uk.utils;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.io.OutputStream;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;

@ExtendWith(MockitoExtension.class)
public class WordDocumentWriterTest {
    //    @Test
//    void testFileContainsAParagraph() {
//        FileWriter fileWriter = new FileWriter("src/test/resources/outputTest.docx");
//        String text = "Hello World.\n";
//
//        Assertions.assertEquals(text, fileWriter.populateDoc(text));
//    }
    @Mock
    DocumentFactory documentFactory;
    @Mock
    XWPFDocument doc;
    @Mock
    XWPFParagraph paragraph;
    @Mock
    XWPFRun run;
    @Mock
    OutputStream out;

    @Test
//    @MockitoSettings(strictness = Strictness.LENIENT)
    void testTextReturnsHello() {
        String path = "src/test/resources/outputTest.docx";
        WordDocumentWriter wordDocumentWriter = new WordDocumentWriter(path, documentFactory);
        String text = "Hello\n";

        Mockito.when(documentFactory.createDoc()).thenReturn(any(XWPFDocument.class));
        Mockito.when(documentFactory.createParagraph(doc)).thenReturn(any(XWPFParagraph.class));
        Mockito.when(documentFactory.createRun(paragraph)).thenReturn(any(XWPFRun.class));
        Mockito.when(documentFactory.writeDocument(doc, out)).thenReturn(true);

        Assertions.assertEquals(text, wordDocumentWriter.populateDoc((text)));

        Mockito.verify(documentFactory).createDoc();
        Mockito.verify(documentFactory).createParagraph(any(XWPFDocument.class));
        Mockito.verify(documentFactory).createRun(any(XWPFParagraph.class));
        Mockito.verify(documentFactory).writeDocument(any(XWPFDocument.class), any(OutputStream.class));
    }
}