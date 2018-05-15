package com.test.zx.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;

/**
 * @author Taylor
 * @version 1.0
 */
public final class JsonUtil {
    private static final Log LOGGER = LogFactory.getLog(JsonUtil.class);

    private JsonUtil() {

    }

    public static <T> String objectToJson(T obj) throws ServiceException {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            LOGGER.error(e);
            throw new ServiceException("1000", e.getMessage());
        }
    }

    public static JsonNode strToJsonObject(String data) throws ServiceException {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readTree(data);
        } catch (IOException e) {
            LOGGER.error(e);
            throw new ServiceException("1000", e.getMessage());
        }
    }

    public static ObjectNode createObjectNode() {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.createObjectNode();
    }

    public static ArrayNode createArrayNode() {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.createArrayNode();
    }

    public static <T> T strToObject(String data, Class<T> valueType) throws ServiceException {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(data, valueType);
        } catch (IOException e) {
            LOGGER.error(e);
            throw new ServiceException("1000", e.getMessage());
        }
    }
}

