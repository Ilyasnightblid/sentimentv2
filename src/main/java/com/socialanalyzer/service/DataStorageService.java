package com.socialanalyzer.service;

import com.socialanalyzer.model.Post;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataStorageService {

    private static final String FILE_PATH = "src/main/resources/data/sample-posts.json";
    private final ObjectMapper objectMapper;

    public DataStorageService() {
        this.objectMapper = new ObjectMapper();
    }

    public void savePost(Post post) {
        List<Post> posts = loadPosts();
        posts.add(post);

        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(FILE_PATH), posts);
            System.out.println("Post saved to JSON file successfully.");
        } catch (IOException e) {
            System.err.println("Error saving post: " + e.getMessage());
        }
    }

    public List<Post> loadPosts() {
        List<Post> posts = new ArrayList<>();
        try {
            posts = objectMapper.readValue(new File(FILE_PATH), new TypeReference<List<Post>>() {});
        } catch (IOException e) {
            System.err.println("Error loading posts: " + e.getMessage());
        }
        return posts;
    }
}