package com.example.demo.services;

import com.example.demo.entities.Post;

import java.util.List;

public interface GestionPost {
    public Post post(Post post);
    public List<Post> posts();
    public void delete(Long postId);
    public Post update(Post post);
    public Post add(Post post);
}
