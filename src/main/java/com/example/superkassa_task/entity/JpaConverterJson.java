package com.example.superkassa_task.entity;

import com.example.superkassa_task.exception.IncorrectRequestDataException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class JpaConverterJson implements AttributeConverter<Current, String> {

    private final static ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(Current current) {
        try {
            return objectMapper.writeValueAsString(current);
        } catch (JsonProcessingException e) {
            throw new IncorrectRequestDataException();
        }
    }

    @Override
    public Current convertToEntityAttribute(String current) {
        try {
            return objectMapper.readValue(current, Current.class);
        } catch (JsonProcessingException e) {
            throw new IncorrectRequestDataException();
        }
    }
}
