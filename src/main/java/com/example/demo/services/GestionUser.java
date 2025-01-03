package com.example.demo.services;

import com.example.demo.entities.User;

import java.util.List;
import java.util.Optional;

public interface GestionUser {
   public Optional<User> getUser(String id);
public List<User> getUsers();
public void removeUser(String id);
public User addUser(User user);
public User updateUser(User user);}
