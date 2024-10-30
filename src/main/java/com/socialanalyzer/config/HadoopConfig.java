package com.socialanalyzer.config;

import org.apache.hadoop.conf.Configuration;

public class HadoopConfig {
    private Configuration configuration;

    public HadoopConfig() {
        configuration = new Configuration();
        configuration.set("fs.defaultFS", "hdfs://localhost:9000");
        // Add other Hadoop configurations as needed
    }

    public static void initializeHadoopConfig() {

    }

    public Configuration getConfiguration() {
        return configuration;
    }
}