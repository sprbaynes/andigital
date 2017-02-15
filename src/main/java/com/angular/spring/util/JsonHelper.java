package com.angular.spring.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;

public class JsonHelper {

    private static final Logger log = LoggerFactory.getLogger(JsonHelper.class);

    private static ObjectMapper mapper = new ObjectMapper();

    public static <T> T mapJsonToClass(String jsonStr, Class<T> valueType )
    {
        T valueObj = null;
        try {
            valueObj = mapper.readValue(jsonStr, valueType);
            log.trace("Successfully mapped json to class {}, from jsonStr:{}", valueType.getCanonicalName(), jsonStr);
        }
        catch(Exception exc)
        {
            log.error("Error mapping json to class {}, from jsonStr: {}", valueType.getCanonicalName(), jsonStr);
        }

        return valueObj;
    }

    public static <T> T mapURLResourceToClass(URL url, Class<T> valueType )
    {
        T valueObj = null;
        try {
            valueObj = mapper.readValue(url, valueType);
            log.trace("Successfully mapped URL json resource to class {}, from jsonStr:{}", url.getPath(),
                    valueType.getCanonicalName());
        }
        catch(Exception exc)
        {
            log.error("Error mapping URL json resource to class {}, from jsonStr: {}", url.getPath(),
                    valueType.getCanonicalName(), exc);
        }

        return valueObj;
    }

    public static String convertObjToJson(Object obj)
    {
        String objJson = null;

        try {
            objJson = mapper.writeValueAsString(obj);
            log.trace("Successfully converted class {}, to json", obj.getClass().getCanonicalName());
        }
        catch(JsonProcessingException exc)
        {
            log.error("Error converting object errors to JSON", obj);
        }

        return objJson;
    }
}