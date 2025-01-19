package com.example.demo.controllers;

import com.example.demo.entities.User;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usercontroller")
@CrossOrigin(origins = "*")public class UserController {

    @Autowired
    private UserService userService;

    // Endpoint to add a new user
    @PostMapping("/adduser")
    public ResponseEntity<User> addUser (@RequestBody User user) {
        User savedUser  = userService.addUser (user);
        return ResponseEntity.ok(savedUser ); // Return the saved user
    }

    // Endpoint to get all users
    @GetMapping("/getuser")
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = userService.getUsers();
        return ResponseEntity.ok(users); // Return the list of users
    }

    // Endpoint to delete a user by ID
    @DeleteMapping("/deleteuser/{id}")
    public ResponseEntity<Void> deleteUser (@PathVariable String id) {
        userService.removeUser (id);
        return ResponseEntity.noContent().build(); // Return 204 No Content
    }

    // Endpoint to update an existing user
    @PutMapping("/updateuser/{id}")
    public ResponseEntity<User> updateUser (@PathVariable Long id ,@RequestBody User user) {
        User updatedUser  = userService.updateUser (user);
        return ResponseEntity.ok(updatedUser ); // Return the updated user
    }
}