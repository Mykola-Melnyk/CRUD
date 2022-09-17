package com.academy.crudforfiledatabase;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class JsonReader {
    public static String getBody(HttpServletRequest request) {
        StringBuilder bodyBuilder = new StringBuilder();
        try (InputStream inputStream = request.getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
            char[] charBuffer = new char[128];
            int bytesRead;
            while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
                bodyBuilder.append(charBuffer, 0, bytesRead);
            }
        } catch (IOException ex) {
            System.err.println("Cannot read body!");
        }
        return bodyBuilder.toString();
    }

    public static Map<String, Object> convertJson(HttpServletRequest request) throws IOException {
        String json = JsonReader.getBody(request);
        ObjectMapper mapper = new ObjectMapper();
        return mapper
                .readValue(json, new TypeReference<HashMap<String, Object>>() {
                });
    }
}
