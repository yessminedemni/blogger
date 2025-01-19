package com.example.demo.controllers;

import com.example.demo.entities.Categorie;
import com.example.demo.entities.Comment;
import com.example.demo.entities.Post;
import com.example.demo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/postcontroller")
@CrossOrigin(origins = "*")
public class PostController {
    @Autowired
    private PostService postService;
    @PostMapping("/addpost")
    public Post addPost(@RequestBody Post post) {
        return postService.add(post);

    }

    @GetMapping("/getpost/{postId}")
    public List<Post> getPosts(@PathVariable Long postId) {
        return postService.posts();
    }

    @DeleteMapping("/deletepost/{postId}")
    public void deletePost(@PathVariable Long postId) {
        postService.delete(postId);
    }

    @GetMapping("/getposts/category/{category}") // New endpoint to get posts by category
    public List<Post> getPostsByCategory(@PathVariable Categorie category) {
        return postService.getPostsByCategory(category);
    }

    @PutMapping("/updatepost")
    Post updatePost(@RequestBody Post post) {
        return postService.update(post);
    }

    @PostMapping("/addpostbycategorie/{category}") // New endpoint to add post by category
    public Post addPostByCategorie(@RequestBody Post post, @PathVariable Categorie category) {
        post.setCategorie(category); // Set the category for the post
        return postService.add(post);

    }}