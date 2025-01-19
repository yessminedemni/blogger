package com.example.demo.services;

import com.example.demo.entities.Comment;
import com.example.demo.entities.Post;
import com.example.demo.repositories.CommandRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService implements GestionComment{
    @Autowired
    private CommandRepo commandRepo;

    @Override
    public Optional<Comment> getComment(String id) {
        return commandRepo.findById(Integer.valueOf(id));
    }



    @Override
    public Comment addComment(Comment comment) {
        return commandRepo.save(comment);
    }

    @Override
    public Comment updateComment(Comment comment) {
        return commandRepo.save(comment);
    }

    @Override
    public void deleteComment(String id) {
        commandRepo.deleteById(Integer.valueOf(id));

    }
    public List<Comment> getCommentsByPost(Post post) {
        return commandRepo.findByPost(post); // Call the updated method
    }
}
