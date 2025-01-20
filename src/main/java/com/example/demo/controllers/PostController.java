package com.example.demo.controllers;

import com.example.demo.entities.*;
import com.example.demo.services.PostService;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/postcontroller")
@CrossOrigin(origins = "http://localhost:50442") // Allow Angular to communicate with the backend
public class PostController {
    @Autowired
    private PostService postService;
    @Autowired

    private UserService userService;
    @PostMapping("/addpost")
    public ResponseEntity<Post> addPost(@RequestBody Post post) {
        try {
            Post savedPost = postService.add(post);
            return ResponseEntity.ok(savedPost);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);  // Handle exception
        }
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