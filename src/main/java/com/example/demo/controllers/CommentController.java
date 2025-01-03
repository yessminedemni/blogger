package com.example.demo.controllers;

import com.example.demo.entities.Comment;
import com.example.demo.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/commentcontroller ")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping("/addComment")
    public Comment addComment(@RequestBody Comment comment) {
        return commentService.addComment(comment);

    }
    @GetMapping("/getComment/{id}")
public Optional<Comment> getCommentById(@RequestParam("id") String id) {
        return commentService.getComment(id);
    }
    @DeleteMapping("/deletecomment/{id}")
    public void deleteCommentById(@RequestParam("id") String id) {
        commentService.deleteComment(id);

    }

    @PutMapping("/updatecomment")
    public Comment updateComment(@RequestBody Comment comment) {
        return commentService.updateComment(comment);

    }

}
