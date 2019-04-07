/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekat.IT355.controller;

import com.projekat.IT355.domain.City;
import com.projekat.IT355.service.CityService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Nemanja
 */
@Controller
@RequestMapping("/admin/city")
public class CityController {

    private CityService cityService;

    // set up constructor injection
    @Autowired
    public CityController(CityService theCityRepository) {
        cityService = theCityRepository;
    }

    //Show all cities
    @GetMapping("/showCities")
    public String showCityAddForm(Model theModel) {
        final String uri = "http://localhost:8080/api/cities";
        RestTemplate restTemplate = new RestTemplate();
        List<City> cities = restTemplate.getForObject(uri, List.class);
        City city = new City();
        theModel.addAttribute("city", city);
        theModel.addAttribute("cities", cities);
        return "city/addCity";
    }

    //Save new city
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") City theCity) {
        final String uri = "http://localhost:8080/api/admin/cities";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForEntity(uri, theCity, City.class);
        return "redirect:/admin/city/showCities";
    }

    //Delete city - REST
    @GetMapping("/delete")
    public String delete(@RequestParam("cityId") int theId) {
        final String uri = "http://localhost:8080/api/admin/cities";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(uri + "/" + theId);
        return "redirect:/admin/city/showCities";
    }
}
