package com.socialanalyzer.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.socialanalyzer.model.Post;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonParser {
    private final ObjectMapper objectMapper;

    public JsonParser() {
        this.objectMapper = new ObjectMapper();
    }

    public List<Post> parseJsonFile(String filePath) {
        try {
            return objectMapper.readValue(new File(filePath), objectMapper.getTypeFactory().constructCollectionType(List.class, Post.class));
        } catch (IOException e) {
            System.err.println("Error parsing JSON file: " + e.getMessage());
            return null;
        }
    }
}
