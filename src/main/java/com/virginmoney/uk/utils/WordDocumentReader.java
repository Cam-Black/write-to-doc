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
    private final Path IN;

    public WordDocumentReader() {
        super();
        IN = Paths.get("input.docx");
    }

    public WordDocumentReader(String in) {
        super();
        IN = Paths.get(in);
    }

    public String readDoc() {
        try (XWPFDocument doc = new XWPFDocument(Files.newInputStream(IN))) {
            List<XWPFParagraph> lines = doc.getParagraphs();
            StringBuilder sb = new StringBuilder();
            LOGGER.info("Reading file...");
            lines.forEach(el -> {
                sb.append(el.getText());
                sb.append("\n");
            });
            LOGGER.info("===========");
            LOGGER.info("FILE START");
            LOGGER.info("===========");
            LOGGER.info(sb);
            LOGGER.info("===========");
            LOGGER.info("FILE END");
            LOGGER.info("===========\n");
            return sb.toString();
        } catch (NoSuchFileException nfe) {
            LOGGER.error("File not found! Please check file path and name is correct!");
        } catch (EmptyFileException efe) {
            LOGGER.error("The file is empty, no content to read");
        } catch (IOException ioe) {
            LOGGER.error(ioe);
        }
        return null;
    }
}