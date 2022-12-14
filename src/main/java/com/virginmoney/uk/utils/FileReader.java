package com.virginmoney.uk.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileReader {
    private final Logger LOGGER = LogManager.getLogger();
    private final Path IN;

    public FileReader() {
        super();
        IN = Paths.get("input.docx");
    }

    public FileReader(String in) {
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
        } catch (FileNotFoundException fnfe) {
            LOGGER.error("File not found! Please check file name is correct!");
        } catch (IOException ioe) {
            LOGGER.error(ioe);
        }
        return null;
    }
}