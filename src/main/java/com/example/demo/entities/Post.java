package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter

@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String title;
    private String content;
    @ManyToOne
    private User user;

}
