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
import java.util.List;

public class ObjectToFile<T> {
	private final Logger LOGGER = LogManager.getLogger();
	private final Path path;
	
	public ObjectToFile() {
		super();
		path = Path.of("output.docx");
	}
	
	public void populateAndSaveDoc(List<T> objects) {
		try (XWPFDocument doc = new XWPFDocument(); OutputStream out = Files.newOutputStream(path)) {
			LOGGER.info("Creating document...");
			XWPFParagraph para = doc.createParagraph();
			XWPFRun run = para.createRun();
			run.setText(convertObjToString(objects));
			LOGGER.info("Writing to document...");
			doc.write(out);
			LOGGER.info("Document created.");
		} catch (FileNotFoundException fnfe) {
			LOGGER.error("File not found!");
		} catch (IOException ioe) {
			LOGGER.error(ioe);
		}
	}
	
	public String convertObjToString(List<T> obj) {
		StringBuilder sb = new StringBuilder();
		obj.forEach(el -> {
			sb.append(el.toString());
			sb.append("\n");
		});
		return sb.toString();
	}
}