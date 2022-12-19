package com.virginmoney.uk.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.EmptyFileException;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class WordDocumentReader {
    private final Logger LOGGER = LogManager.getLogger();
    private final WordDocumentMaker MAKER;
    private final Path IN;

    public WordDocumentReader() {
        super();
        IN = Paths.get("input.docx");
        MAKER = new WordDocumentMaker();
    }

    public WordDocumentReader(String in, WordDocumentMaker maker) {
        super();
        IN = Paths.get(in);
        MAKER = maker;
    }

    public StringBuilder readDoc() {
        StringBuilder sb = new StringBuilder();
        try (XWPFDocument doc = MAKER.newDocument(IN)) {
            List<XWPFParagraph> lines = doc.getParagraphs();
            LOGGER.info("Reading file...");
            lines.forEach(el -> {
                sb.append(el.getText());
                sb.append("\n");
            });
            LOGGER.info("===========");
            LOGGER.info("FILE START");
            LOGGER.info("===========\n");
            LOGGER.info(sb);
            LOGGER.info("===========");
            LOGGER.info("FILE END");
            LOGGER.info("===========\n");
            return sb;
        } catch (NoSuchFileException nfe) {
            LOGGER.error("File not found! Please check file path and name is correct!");
        } catch (EmptyFileException efe) {
            LOGGER.error("The file is empty, no content to read");
        } catch (IOException ioe) {
            LOGGER.error(ioe);
        }
        return sb;
    }
}