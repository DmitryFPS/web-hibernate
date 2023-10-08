package ru.orlov.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletInputStream;
import java.io.IOException;

/**
 * Для парсинга из строк в json
 */
public class JsonUtil {

    /**
     * Парсим данные из потока в Json объект
     */
    public static JsonNode convertStringToJson(final ServletInputStream stream) {
        try {
            final ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readTree(stream);
        } catch (final IOException exc) {
            return null;
        }
    }
}