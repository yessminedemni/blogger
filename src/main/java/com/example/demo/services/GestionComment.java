package com.example.demo.services;

import com.example.demo.entities.Comment;

import java.util.List;
import java.util.Optional;

public interface GestionComment {
    Optional<Comment> getComment(String commentId);
    public Comment addComment(Comment comment);
    public Comment updateComment(Comment comment);
    public void deleteComment(String commentId);

}
