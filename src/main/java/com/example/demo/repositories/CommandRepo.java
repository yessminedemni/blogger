package com.example.demo.repositories;

import com.example.demo.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandRepo extends JpaRepository<Comment,Integer>{
    Integer id(int id);
}
