package com.socialanalyzer.service;

import com.socialanalyzer.model.Post;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DataCollectorService {

    public static void main(String[] args) {
        // Replace with your actual CSV file name
        String filePath = loadFilePath("data/dataset.csv");
        List<Post> posts = loadPostsFromCSV(filePath);

        // Print posts for demonstration
        for (Post post : posts) {
            System.out.println("Post ID: " + post.getId() + ", Content: " + post.getContent() + ", User ID: " + post.getUserId());
        }
    }

    public static String loadFilePath(String fileName) {
        URI uri;
        try {
            uri = new URI(fileName);
        } catch (URISyntaxException e) {
            throw new RuntimeException("Error finding file path", e);
        }
        return Paths.get(uri).toString();
    }

    public static List<Post> loadPostsFromCSV(String filePath) {
        List<Post> posts = new ArrayList<>();
        String line;
        String delimiter = ","; // Adjust based on your CSV structure

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // Skip the header line
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(delimiter);
                if (values.length >= 3) {
                    String id = values[0];
                    String content = values[1];
                    String userId = values[2];
                    posts.add(new Post(id, content, userId));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading CSV file", e);
        }

        return posts;
    }
}
