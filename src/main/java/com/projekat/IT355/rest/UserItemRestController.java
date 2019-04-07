/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekat.IT355.rest;

import com.projekat.IT355.domain.Custom;
import com.projekat.IT355.domain.Item;
import com.projekat.IT355.domain.User;
import com.projekat.IT355.service.ItemService;
import com.projekat.IT355.service.UserService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Nemanja
 */
@RestController
@RequestMapping("api")
public class UserItemRestController {

    private final UserService userService;
    private final ItemService itemService;

    // set up constructor injection
    @Autowired
    public UserItemRestController(UserService theUserService, ItemService theItemService) {
        userService = theUserService;
        itemService = theItemService;
    }
  

    //get items for specific user
    @GetMapping("users/items/{userId}")
    public List<Item> items(@PathVariable int userId) {
        User u = userService.getUser(userId);
        return u.getItems();
    }

    
    //Add item
    @PostMapping("users/items/{userId}/{itemId}")
    public List<Item> items(@PathVariable int userId,
            @PathVariable int itemId) {
        User u = userService.getUser(userId);
        Item i = itemService.getItemById(itemId);
        u.addItem(i);
        userService.save(u);
        itemService.saveOrUpdate(i);
        return u.getItems();
    }
    
    //Delete from user_item table
    @PutMapping("/user/a")
    public String deleteItems(@RequestBody Custom custom) {
        User u = userService.getUser(custom.getA());//user id
        Item i = itemService.getItemById(custom.getB());//item id
        u.removeItem(i);
        userService.save(u);
        itemService.saveOrUpdate(i);
        return "Success";
    }
    
}
