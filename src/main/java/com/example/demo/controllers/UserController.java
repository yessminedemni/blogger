package com.example.demo.controllers;

import com.example.demo.entities.Post;
import com.example.demo.entities.User;
import com.example.demo.services.PostService;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usercontroller")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/adduser")
    public User adduser(@RequestBody User user) {
       return userService.addUser(user);

    }
    @GetMapping("/getuser")
    public List<User> getUsers() {
        return userService.getUsers();
    }
    @DeleteMapping("/deleteuser")
    public void deletePost(User user) {
        userService.removeUser(String.valueOf(user));
    }
    @PutMapping("/updateuser")
   public  User updateUsre(@RequestBody User user) {
        return userService.updateUser(user);
    }

}


