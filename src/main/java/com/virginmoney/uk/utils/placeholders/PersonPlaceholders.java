package com.virginmoney.uk.utils.placeholders;

import com.virginmoney.uk.entity.Person;

import java.util.HashMap;
import java.util.Map;

public class PersonPlaceholders implements Placeholders<Person, String, String> {
    @Override
    public Map<String, String> getPlaceholders(Person person) {
        Map<String, String> valueMap = new HashMap<>();
        valueMap.put("first_name", person.getFirstName());
        valueMap.put("last_name", person.getLastName());
        valueMap.put("dob", person.getDob().toString());
        return valueMap;
    }
}