package com.virginmoney.uk.writer;

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
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ObjectToFile<T> {
    private final Logger LOGGER = LogManager.getLogger();
    private final Path path;

    public ObjectToFile() {
        super();
        path = Paths.get("output.docx");
    }

    public int populateAndSaveDoc(List<T> objects) {
        AtomicInteger paraCount = new AtomicInteger();
        try (XWPFDocument doc = new XWPFDocument(); OutputStream out = Files.newOutputStream(path)) {
            LOGGER.info("Document Created");
            objects.forEach(el -> {
                LOGGER.info("Writing to document...");
                XWPFParagraph para = doc.createParagraph();
                XWPFRun run = para.createRun();
                run.setText(convertObjToString(el));
                paraCount.getAndIncrement();
            });
            doc.write(out);
            LOGGER.info("Document saved.");
            return paraCount.get();
        } catch (FileNotFoundException fnfe) {
            LOGGER.error("File not found!");
        } catch (IOException ioe) {
            LOGGER.error(ioe);
        }
        return 0;
    }

    public String convertObjToString(T obj) {
        StringBuilder sb = new StringBuilder();
        sb.append(obj.toString());
        sb.append("\n");
        return sb.toString();
    }
}