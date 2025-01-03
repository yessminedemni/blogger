package com.example.demo.controllers;

import com.example.demo.entities.Post;
import com.example.demo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/postcontrooler")

public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping("/addpost")
    public Post addPost(@RequestBody Post post) {
        return postService.add(post);

    }
   @GetMapping("/getpost")
   public List<Post> getPosts() {
        return postService.posts();
   }
    @DeleteMapping("/deletepost")
    public void deletePost(Post post) {
        postService.delete(post);
    }
    @PutMapping("/updatepost")
    Post updatePost(@RequestBody Post post) {
        return postService.update(post);
    }

    }

