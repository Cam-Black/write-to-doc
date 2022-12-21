package com.virginmoney.uk;

import com.virginmoney.uk.entity.Person;
import com.virginmoney.uk.service.PersonToFile;
import com.virginmoney.uk.utils.converter.PDFConverter;

import java.time.LocalDate;

public class Runner {
    public static void main(String[] args) {
        PersonToFile toFile = new PersonToFile();
        Person john = new Person("John", "Doe", LocalDate.of(1982, 12, 13));
        toFile.replacePlaceholdersInText(john);
        PDFConverter.convertWordToPDF("output.docx", "output.pdf");
    }
}