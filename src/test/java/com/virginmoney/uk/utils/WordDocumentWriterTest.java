package com.virginmoney.uk.utils;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class WordDocumentWriterTest {

    @Mock
    WordDocumentMaker maker;

    @Test
    void testPopulateDocWithHelloWorld() {
        XWPFDocument doc = mock(XWPFDocument.class);
        XWPFParagraph para = mock(XWPFParagraph.class);
        XWPFRun run = mock(XWPFRun.class);

        String strOut = "output_test.docx";
        Path out = Paths.get(strOut);
        WordDocumentWriter writer = new WordDocumentWriter(strOut, maker);
        StringBuilder text = new StringBuilder("Hello World");

        when(maker.newDocument()).thenReturn(doc);
        when(maker.newParagraph(doc)).thenReturn(para);
        when(maker.newRun(para)).thenReturn(run);
        when(maker.writeDocument(doc, out)).thenReturn(true);

        assertTrue(writer.populateDoc(text));

        verify(maker).newDocument();
        verify(maker).newParagraph(doc);
        verify(maker).newRun(para);
        verify(maker).writeDocument(doc, out);
    }

    @Test
    void testIOException() throws IOException {
        XWPFDocument doc = mock(XWPFDocument.class);
        XWPFParagraph para = mock(XWPFParagraph.class);
        XWPFRun run = mock(XWPFRun.class);
        doc.close();

        String strOut = "output_test.docx";
        Path out = Paths.get(strOut);
        WordDocumentWriter writer = new WordDocumentWriter(strOut, maker);
        StringBuilder text = new StringBuilder("Hello World");

        when(maker.newDocument()).thenReturn(doc);
        when(maker.newParagraph(doc)).thenReturn(para);
        when(maker.newRun(para)).thenReturn(run);
        given(maker.writeDocument(doc, out)).willAnswer(invocationOnMock -> {
            throw new IOException();
        });

        assertFalse(writer.populateDoc(text));

        verify(maker).newDocument();
        verify(maker).newParagraph(doc);
        verify(maker).newRun(para);
        verify(maker).writeDocument(doc, out);
    }
}