package com.virginmoney.uk.writer;

import com.virginmoney.uk.template.Person;
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

public class PersonToFile implements TemplateToFileMethods<Person> {
	private final Logger LOGGER = LogManager.getLogger();
	private final Path path;
	
	public PersonToFile() {
		super();
		path = Path.of("output.docx");
	}
	
	@Override
	public XWPFDocument createDoc() {
		return new XWPFDocument();
	}
	
	@Override
	public void populateAndSaveDoc(List<Person> people) {
		try (XWPFDocument doc = this.createDoc(); OutputStream out = Files.newOutputStream(path)) {
			XWPFParagraph para = doc.createParagraph();
			XWPFRun run = para.createRun();
			run.setText(convertObjToString(people));
			doc.write(out);
		} catch (FileNotFoundException fnfe) {
			LOGGER.error("File not found!");
		} catch (IOException ioe) {
			LOGGER.error(ioe);
		}
	}
	
	@Override
	public String convertObjToString(List<Person> obj) {
		StringBuilder sb = new StringBuilder();
		obj.forEach(el -> {
			sb.append(el.toString());
			sb.append("\n");
		});
		return sb.toString();
	}
}