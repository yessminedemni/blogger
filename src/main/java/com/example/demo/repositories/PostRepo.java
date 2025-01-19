package com.example.demo.repositories;

import com.example.demo.entities.Categorie;
import com.example.demo.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepo extends JpaRepository<Post, Long> {
    List<Post> findByCategorie(Categorie categorie);

}
