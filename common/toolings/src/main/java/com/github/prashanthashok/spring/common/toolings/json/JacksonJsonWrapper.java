package com.github.prashanthashok.spring.common.toolings.json;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.Module;


import static org.apache.commons.lang.StringUtils.isNotBlank;

public class JacksonJsonWrapper implements JsonWrapper {


    public static ObjectMapper createNewObjectMapper(){
        return new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT)
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true)
                .setSerializationInclusion(JsonInclude.Include.NON_NULL)
                .configure(JsonParser.Feature.ALLOW_COMMENTS, true);
    }

    private final ObjectMapper objectMapper = createNewObjectMapper();

    @Override
    public String toJson(Object o) {
        try {
            return o != null ? objectMapper.writeValueAsString(o) : null;
        } catch(JsonProcessingException ex) {
            throw new JsonWrapperException(ex);
        }
    }

    @Override
    public <T> T toObject(String json, Class<T> type) {
        try {
            return isNotBlank(json) ? objectMapper.readValue(json, type) : null;
        } catch(JsonProcessingException ex){
            throw new JsonWrapperException(ex);
        }
    }
}
