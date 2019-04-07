/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekat.IT355.service;

import com.projekat.IT355.domain.City;
import java.util.List;

/**
 *
 * @author Nemanja
 */
public interface CityService {
     public void save(City theCity);
     public List<City> findAll();
     public void deleteById(int id);
}
