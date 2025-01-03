package com.example.demo.services;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserService implements GestionUser{
    @Autowired
    private UserRepo userRepo;

    @Override
    public Optional<User> getUser(String id) {
        return Optional.ofNullable(userRepo.findById(Long.valueOf(id)).orElse(null));
    }



    @Override
    public List<User> getUsers() {
        return userRepo.findAll();
    }

    @Override
    public void removeUser(String id) {
        userRepo.deleteById(Long.valueOf(id));

    }

    @Override
    public User addUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public User updateUser(User user) {
        return userRepo.save(user);
    }
}
