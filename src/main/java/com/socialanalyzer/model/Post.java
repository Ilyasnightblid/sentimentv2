package com.socialanalyzer.model;

public class Post {
    private String id;
    private String content;
    private String userId;

    public Post(String id, String content, String userId) {
        this.id = id;
        this.content = content;
        this.userId = userId;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getUserId() {
        return userId;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    // Met à jour le contenu du message
    public void updateContent(String newContent) {
        if(userId != null) {
            this.content = newContent;
        } else {
            throw new IllegalStateException("Cannot update post content. User ID is not set.");
        }
    }

    // Vérifie si l'utilisateur peut éditer le message
    public boolean canEditUser(){
        return userId != null;
    }

}
