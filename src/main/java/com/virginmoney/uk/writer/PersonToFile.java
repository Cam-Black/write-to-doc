package com.virginmoney.uk.writer;

import com.virginmoney.uk.template.Person;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.EmptyFileException;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class PersonToFile extends ObjectToFile<Person> {
    private final Logger LOGGER = LogManager.getLogger();
    private final Path IN;
    private final Path OUT;

    public PersonToFile(Path in, Path out) {
        super();
        IN = in;
        OUT = out;
    }

    public void replacePlaceholdersInFile(Person person) {
        try (XWPFDocument doc = new XWPFDocument(Files.newInputStream(IN));
             OutputStream out = Files.newOutputStream(OUT)) {
            List<XWPFParagraph> p = doc.getParagraphs();
            p.forEach(el -> {
                List<XWPFRun> runs = el.getRuns();
                runs.forEach(el2 -> {
                    String text = el2.getText(0);
                    if (text != null && text.contains("FIRST_NAME")) {
                        text = text.replace("FIRST_NAME", person.getFirstName());
                        el2.setText(text, 0);
                    }
                    if (text != null && text.contains("LAST_NAME")) {
                        text = text.replace("LAST_NAME", person.getLastName());
                        el2.setText(text, 0);
                    }
                    if (text != null && text.contains("DOB")) {
                        text = text.replace("DOB", person.getDob().toString());
                        el2.setText(text, 0);
                    }
                    LOGGER.info(el2);
                });
            });
            doc.write(out);
        } catch (FileNotFoundException e) {
            LOGGER.error("File Not Found");
        } catch (IOException e) {
            LOGGER.error(e);
        } catch (EmptyFileException e) {
            LOGGER.error("The file is empty! Cannot be read!");
        }
    }
}