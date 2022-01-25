package com.example.project_agriculture.util;

import com.example.project_agriculture.constant.ErrorCode;
import com.example.project_agriculture.exception.ApplicationException;
import com.example.project_agriculture.request.AbstractRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;

@Slf4j
public class ObjectMapperUtils {

    private static ObjectMapper objectMapper = new ObjectMapper();

    public static <T extends AbstractRequest> T mapperStrJsonToRequest(String requestJson, Class<T> request){
        try {
            return objectMapper.readValue(requestJson, request);
        } catch (Exception ex) {
            throw new ApplicationException(ErrorCode.UNKNOWN_ERROR.getValue());
        }
    }

    public static <T extends Object> HashMap<String, String> convertObjectToHashMap(T object) {
        try {
            return objectMapper.convertValue(object, HashMap.class);
        } catch (Exception ex) {
            throw new ApplicationException(ErrorCode.CONVERT_MAP.getValue());
        }
    }
}
