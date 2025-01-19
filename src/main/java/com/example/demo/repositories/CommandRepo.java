package com.example.demo.repositories;

import com.example.demo.entities.Comment;
import com.example.demo.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommandRepo extends JpaRepository<Comment,Integer>{
    Integer id(int id);

    List<Comment> findByPost(Post post); // Use the Post entity directly
}
