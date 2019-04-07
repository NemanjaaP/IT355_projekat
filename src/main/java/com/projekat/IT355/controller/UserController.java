/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekat.IT355.controller;

import com.projekat.IT355.domain.City;
import com.projekat.IT355.domain.Role;
import com.projekat.IT355.domain.User;
import com.projekat.IT355.service.RoleService;
import com.projekat.IT355.service.UserService;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Nemanja
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    private final UserService userService;
    private final RoleService roleService;

    // set up constructor injection
    @Autowired
    public UserController(UserService theUserService, RoleService theRoleService) {
        userService = theUserService;
        roleService = theRoleService;
    }

    //User registration (add user) - REST
    @GetMapping("/register")
    public String showRegisterForm(Model theModel) {
        User user = new User();
        List<City> cities = new ArrayList<>();
        final String uri = "http://localhost:8080/api/cities";
        RestTemplate restTemplate = new RestTemplate();
        cities = restTemplate.getForObject(uri, List.class);
        theModel.addAttribute("user", user);
        theModel.addAttribute("cities", cities);
        return "register";
    }

    //Action save user - REST
    @PostMapping("/save")
    public String addUser(@Valid @ModelAttribute("user") User theUser,
            BindingResult bindingResult) {

        System.out.println(bindingResult.getAllErrors());
        if (bindingResult.hasErrors()) {
            return "redirect:/user/register";
        }
        theUser.setEnabled(1);
        String usn = theUser.getPassword();
        theUser.setPassword(passwordEncoder.encode(usn));
        Role role = roleService.getRoleById(2);
        theUser.addRole(role);
        userService.save(theUser);

        return "redirect:/login";
    }

}
