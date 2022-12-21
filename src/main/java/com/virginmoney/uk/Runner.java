package com.virginmoney.uk;

import com.spire.doc.Document;
import com.virginmoney.uk.entity.Person;
import com.virginmoney.uk.service.PersonToFile;
import com.virginmoney.uk.utils.converter.PDFConverter;

import java.io.IOException;
import java.time.LocalDate;

public class Runner {
    public static void main(String[] args) throws IOException {
        PersonToFile toFile = new PersonToFile();
        Person john = new Person("John", "Doe", LocalDate.of(1982, 12, 13));
        toFile.replacePlaceholdersInText(john);
        Document doc = new Document("output.docx");
        PDFConverter converter = new PDFConverter(doc);
        converter.convertWordToPDF("output.pdf");
    }
}