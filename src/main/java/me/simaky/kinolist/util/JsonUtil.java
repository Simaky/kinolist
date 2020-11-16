package me.simaky.kinolist.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

public class JsonUtil {
    private final static ObjectMapper objectMapper = new ObjectMapper();

    @SneakyThrows
    public static String toJson(Object object) {
        return objectMapper.writeValueAsString(object);
    }
}
