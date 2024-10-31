package com.socialanalyzer.repository;

import com.socialanalyzer.model.Post;
import java.util.ArrayList;
import java.util.List;

public class SocialDataRepository {
    private List<Post> posts;

    public SocialDataRepository() {
        this.posts = new ArrayList<>();
    }

    public void savePost(Post post) {
        posts.add(post);
    }

    public List<Post> getAllPosts() {
        return posts;
    }

    public Post getPostById(String id) {
        for (Post post : posts) {
            if (post.getId().equals(id)) {
                return post;
            }
        }
        return null;
    }
}
