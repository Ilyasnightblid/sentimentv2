package com.socialanalyzer.util;

public class SentimentUtils {

    public static String getSentimentLabel(double score) {
        if (score > 0.5) return "Positive";
        else if (score < -0.5) return "Negative";
        else return "Neutral";
    }
}

