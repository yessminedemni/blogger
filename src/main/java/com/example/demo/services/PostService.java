package com.example.demo.services;

import com.example.demo.entities.Categorie;
import com.example.demo.entities.Comment;
import com.example.demo.entities.Post;
import com.example.demo.repositories.CommandRepo;
import com.example.demo.repositories.PostRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PostService implements GestionPost{
    @Autowired
    private PostRepo postrepo;
    @Autowired
    private CommandRepo commandRepo;
    @Override
    public Post post(Post post) {
        return postrepo.save(post);
    }

    @Override
    public List<Post> posts() {
        return postrepo.findAll();
    }

    @Override
    public void delete(Long postId) {
        if (postrepo.existsById(postId)) { // Check if the post exists
            postrepo.deleteById(postId); // Use deleteById instead of delete
        } else {
            throw new EntityNotFoundException("Post not found with ID: " + postId);
        }
    }

    public List<Post> getPostsByCategory(Categorie category) {
        return postrepo.findByCategorie(category); // Assuming you have this method in your repository
    }

        @Override
    public Post update(Post post) {
        return postrepo.save(post);
    }

    @Override
    public Post add(Post post) {
        return postrepo.save(post);
    }


}
