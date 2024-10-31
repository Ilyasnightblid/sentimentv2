package com.socialanalyzer.config;

import org.apache.spark.sql.SparkSession;

public class SparkConfig {
    private final SparkSession sparkSession;

    public SparkConfig() {
        sparkSession = SparkSession.builder()
                .appName("Social Sentiment Analysis")
                .master("local[*]")  // Use local for testing
                .getOrCreate();
    }

    public SparkSession getSparkSession() {
        return sparkSession;
    }
}
