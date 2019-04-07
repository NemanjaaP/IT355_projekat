/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekat.IT355.rest;

import com.projekat.IT355.domain.City;
import com.projekat.IT355.service.CityService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Nemanja
 */
@RestController
@RequestMapping("/api")
public class CityRestController {

    private CityService cityService;

    // set up constructor injection
    @Autowired
    public CityRestController(CityService theCityRepository) {
        cityService = theCityRepository;
    }

    //Return list of all cities
    @GetMapping("/cities")
    public List<City> getCities() {
        List<City> cities = cityService.findAll();
        return cities;
    }

    //Delete city based on ID
    @DeleteMapping("/admin/cities/{cityId}")
    public String deleteCity(@PathVariable int cityId) {
        cityService.deleteById(cityId);
        return "Obrisan je";
    }

    //Saves new city
    @PostMapping("/admin/cities")
    public City saveCity(@RequestBody City theCity) {
        List<City> cities = cityService.findAll();
        for (City city : cities) {
            if (city.getName().equals(theCity.getName())) {
            }
        }
        cityService.save(theCity);
        return theCity;
    }
}
