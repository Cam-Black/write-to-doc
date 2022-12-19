package com.virginmoney.uk.service;

import com.virginmoney.uk.entity.Person;
import com.virginmoney.uk.utils.PersonPlaceholders;
import com.virginmoney.uk.utils.WordDocumentReader;
import org.apache.commons.text.StringSubstitutor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

public class PersonToFile {
    private final Logger LOGGER = LogManager.getLogger();
    private final WordDocumentReader READER;

    public PersonToFile() {
        super();
        READER = new WordDocumentReader();
    }

    public PersonToFile(WordDocumentReader reader) {
        super();
        READER = reader;
    }

    public StringBuilder replacePlaceholdersInText(Person person) {
        PersonPlaceholders placeholders = new PersonPlaceholders();
        StringBuilder text = READER.readDoc();
        Map<String, String> toReplace = placeholders.getPlaceholders(person);
        StringSubstitutor sub = new StringSubstitutor(toReplace);
        text.replace(0, text.length(), sub.replace(text));
        LOGGER.info(text);
        return text;
    }
}