package com.virginmoney.uk.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileWriter {
    private final Logger LOGGER = LogManager.getLogger();
    private final Path OUT;

    public FileWriter() {
        super();
        OUT = Paths.get("output.docx");
    }

    public FileWriter(String out) {
        OUT = Paths.get(out);
    }

    public int populateDoc(String text) {
        int count = 0;
        try (XWPFDocument doc = new XWPFDocument();
             OutputStream out = Files.newOutputStream(OUT)) {
            LOGGER.info("Document Created.");
            String[] lines = text.split("\n");
            for (String p : lines) {
                XWPFParagraph para = doc.createParagraph();
                XWPFRun run = para.createRun();
                run.setText(p);
                count++;
            }
            LOGGER.info("Document saved.");
            doc.write(out);
            return count;
        } catch (FileNotFoundException fnfe) {
            LOGGER.error("File not found!");
        } catch (IOException ioe) {
            LOGGER.error(ioe);
        }
        return count;
    }
}