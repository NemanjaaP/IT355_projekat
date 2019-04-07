/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekat.IT355.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Nemanja
 */
@Controller
public class HomeController {

    @GetMapping("/index")
    public String home() {
        return "index";
    }

    @GetMapping("/gallery")
    public String showGallery() {
        return "gallery";
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }


}
