package com.socialanalyzer.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.socialanalyzer.model.post;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonParser {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static List<post> parsePosts(String filePath) throws IOException {
        return objectMapper.readValue(new File(filePath),
                objectMapper.getTypeFactory().constructCollectionType(List.class, post.class));
    }
}
