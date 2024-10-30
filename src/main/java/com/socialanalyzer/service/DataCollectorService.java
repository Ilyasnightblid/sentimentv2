package com.socialanalyzer.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Paths;
#hdfs#
public class DataCollectorService{

    public static void main(String[] args) {
        // Replace "data.json" with your actual file name
        String filePath = loadFilePath("data.json");
        // Use the file path to load your JSON data
    }

    public static String loadFilePath(String fileName) {
        URI uri;
        try {
            uri = new URI("/data/sample-posts.json");

        } catch (URISyntaxException e) {
            throw new RuntimeException("Error finding file path", e);
        }
        return Paths.get(uri).toString();
    }
}

