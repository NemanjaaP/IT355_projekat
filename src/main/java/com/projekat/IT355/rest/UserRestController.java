/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekat.IT355.rest;

import com.projekat.IT355.domain.Item;
import com.projekat.IT355.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.projekat.IT355.domain.User;
import com.projekat.IT355.service.ItemService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Nemanja
 */
@RestController
@RequestMapping("/api")
public class UserRestController {

    private final UserService userService;
    private final ItemService itemService;
    // set up constructor injection
    @Autowired
    public UserRestController(UserService theUserService, ItemService theItemService) {
        userService = theUserService;
        itemService = theItemService;
    }

    //Add new user 
    @PostMapping("/users")
    public String saveUser(@RequestBody User user) {
        userService.save(user);
        return null;
    }
    
    //Get all users
    @GetMapping("/users")
    public List<User> findAll() {
        List<User> users = userService.getAllUsers();
        return users;
    }

    //Get specific user based on user id    
    @GetMapping("/users/{userId}")
    public User getUser(@PathVariable int userId) {
       return userService.getUser(userId);
    }
    
    @GetMapping("/user/{username}")
    public User getUser(@PathVariable String username){
        return userService.getUserByUsername(username);
    }
    
    @GetMapping("/userById/{username}")
     public boolean getUser1(@PathVariable String username){
        return userService.isUsernameAlreadyInUse(username);
    }

}
