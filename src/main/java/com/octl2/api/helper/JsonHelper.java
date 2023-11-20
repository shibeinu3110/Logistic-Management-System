package com.octl2.api.helper;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JsonHelper {

    public static String toJson(Object obj) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            return objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException ex) {
            log.info("Fail toJson with errMsg = {}", ex.getMessage());
            return "{}";
        }
    }
}
