package com.socialanalyzer.model;

public class SentimentResult {
    private String postId;
    private String sentiment;
    private double score;
    private java.util.Date date; // Nouvel attribut

    // Getters and Setters
    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getSentiment() {
        return sentiment;
    }

    public void setSentiment(String sentiment) {
        this.sentiment = sentiment;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public java.util.Date getDate() { // Getter for date
        return date;
    }

    public void setDate(java.util.Date date) { // Setter for date
        this.date = date;
    }
}
