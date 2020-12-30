package com.example.demo.core.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONUtils {

    public static boolean isValidJsonString(String json){

        ObjectMapper om = new ObjectMapper();
        boolean result = true;
        try {
            om.readTree(json);
        } catch (JsonProcessingException e) {
            result = false;
        }
        return result;
    }
}
