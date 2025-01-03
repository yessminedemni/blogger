package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String commentaires;
    @ManyToOne
    private  User user;
    @ManyToMany
    private List<User> users;
}
