/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekat.IT355.controller;

import com.projekat.IT355.domain.Custom;
import com.projekat.IT355.domain.Item;
import com.projekat.IT355.domain.Itm;
import com.projekat.IT355.domain.User;
import com.projekat.IT355.service.ItemService;
import com.projekat.IT355.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Nemanja
 */
@Controller
@RequestMapping("/users/items")
public class UserItemController {

    private final UserService userService;
    private final ItemService itemService;

    // set up constructor injection
    @Autowired
    public UserItemController(UserService theUserService, ItemService theItemService) {
        userService = theUserService;
        itemService = theItemService;
    }

    //Show user items in shopping cart
    @GetMapping("/showItems")
    public String getAllItems(Model theModel) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String str1 = auth.getName();

        RestTemplate restTemplate = new RestTemplate();

        //retrive user by username
        final String uri1 = "http://localhost:8080/api/user";
        User user = restTemplate.getForObject(uri1 + "/" + str1, User.class);

        int i = user.getId();

        final String uri = "http://localhost:8080/api/users/items";
        List<Item> items = restTemplate.getForObject(uri + "/" + i, List.class);
        theModel.addAttribute("items", items);
        return "shoppingCart";
    }

    @RequestMapping(value = "/delete", method = {RequestMethod.GET, RequestMethod.POST}) 
    public String deleteItemFromShoppingCart(
            @RequestParam("itemId") int itemId) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String str1 = auth.getName();

        RestTemplate restTemplate = new RestTemplate();

        //retrive user by username
        final String uri1 = "http://localhost:8080/api/user";
        User user = restTemplate.getForObject(uri1 + "/" + str1, User.class);

        int i = user.getId();
        
        User u = userService.getUser(i);//user id
        Item e = itemService.getItemById(itemId);//item id
        u.removeItem(e);
        userService.save(u);
        itemService.saveOrUpdate(e);
        return "redirect:/users/items/showItems";
    }

    //Save new item in shopping cart
    @RequestMapping(value = "/add", method = {RequestMethod.GET, RequestMethod.POST}) //direktno ubaciti mozda usera i item
    public String addNewItemInShoppingCart(
            @RequestParam("itemId") int itemId) {

        RestTemplate restTemplate = new RestTemplate();

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String str1 = auth.getName();

        final String uri = "http://localhost:8080/api/user";
        User user = restTemplate.getForObject(uri + "/" + str1, User.class);

        int ee = user.getId();

        User u = userService.getUser(ee);
        Item i = itemService.getItemById(itemId);
        int e = i.getProductType().getId();
        u.addItem(i);
        userService.save(u);
        itemService.saveOrUpdate(i);
        return "redirect:/itemsList?productTypeId=" + e;
    }

}
