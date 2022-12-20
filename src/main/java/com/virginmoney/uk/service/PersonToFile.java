package com.virginmoney.uk.service;

import com.virginmoney.uk.entity.Person;
import com.virginmoney.uk.utils.PersonPlaceholders;
import com.virginmoney.uk.utils.worddocument.WordDocumentReader;
import com.virginmoney.uk.utils.worddocument.WordDocumentWriter;
import org.apache.commons.text.StringSubstitutor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

public class PersonToFile {
    private final Logger LOGGER = LogManager.getLogger();
    private final WordDocumentReader READER;
    public final WordDocumentWriter WRITER;

    public PersonToFile() {
        super();
        READER = new WordDocumentReader();
        WRITER = new WordDocumentWriter();
    }

    public PersonToFile(WordDocumentReader reader, WordDocumentWriter writer) {
        super();
        READER = reader;
        WRITER = writer;
    }

    public StringBuilder replacePlaceholdersInText(Person person) {
        PersonPlaceholders placeholders = new PersonPlaceholders();
        StringBuilder text = new StringBuilder();
        READER.readDoc().forEach(el -> {
            text.append(el.getText());
            text.append("\n");
        });
        Map<String, String> toReplace = placeholders.getPlaceholders(person);
        StringSubstitutor sub = new StringSubstitutor(toReplace);
        text.replace(0, text.length(), sub.replace(text));
        LOGGER.info(text);
        WRITER.populateDoc(text);
        return text;
    }
}