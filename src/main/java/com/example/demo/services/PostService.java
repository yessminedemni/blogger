package com.example.demo.services;

import com.example.demo.entities.Post;
import com.example.demo.repositories.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PostService implements GestionPost{
    @Autowired
    private PostRepo postrepo;
    @Override
    public Post post(Post post) {
        return postrepo.save(post);
    }

    @Override
    public List<Post> posts() {
        return postrepo.findAll();
    }

    @Override
    public void delete(Post post) {
        postrepo.delete(post);

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
