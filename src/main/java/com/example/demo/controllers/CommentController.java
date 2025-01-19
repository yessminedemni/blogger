package com.example.demo.controllers;

import com.example.demo.entities.Comment;
import com.example.demo.entities.Post;
import com.example.demo.repositories.CommandRepo;
import com.example.demo.services.CommentService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/commentcontroller")
@CrossOrigin(origins = "*")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping("/addComment")
    public Comment addComment(@RequestBody Comment comment) {
        return commentService.addComment(comment);

    }
    @GetMapping("/getComment/{id}")
    public Optional<Comment> getCommentById(@PathVariable("id") String id) {
        return commentService.getComment(id);
    }
    @DeleteMapping("/deletecomment/{id}")
    public void deleteCommentById(@PathVariable("id") String id) {
        commentService.deleteComment(id);
    }
    @PutMapping("/updatecomment/{id}")
    @Transactional

    public Comment updateComment(@PathVariable("id") String id, @RequestBody Comment comment) {
        // Set the ID of the comment to be updated
        comment.setId(Long.valueOf(id)); // Assuming your Comment class has a setId method
        return commentService.updateComment(comment);
    }
    @GetMapping("/post/{postId}")
    public List<Comment> getCommentsByPostId(@PathVariable Long postId) {
        Post post = new Post();
        post.setPostId(postId); // Create a Post object with the given ID
        return commentService.getCommentsByPost(post); // Fetch comments for the post
    }

}
