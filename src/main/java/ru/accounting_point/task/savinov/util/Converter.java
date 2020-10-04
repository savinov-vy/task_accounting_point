package ru.accounting_point.task.savinov.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.accounting_point.task.savinov.entities.JsonData;

import java.io.File;
import java.io.IOException;

public class Converter {

    public static JsonData toJavaObject(String strJSON) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(strJSON, JsonData.class);
    }

}
