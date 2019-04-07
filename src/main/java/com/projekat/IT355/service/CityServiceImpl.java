/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekat.IT355.service;

import com.projekat.IT355.dao.CityRepository;
import com.projekat.IT355.domain.City;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nemanja
 */
@Service
public class CityServiceImpl implements CityService{
  
    private CityRepository cityRepository;

    // set up constructor injection
    @Autowired
    public CityServiceImpl(CityRepository theCityRepository) {
        cityRepository = theCityRepository;
    }
    
    @Override
    public void save(City theCity) {
        cityRepository.save(theCity);
    }

    @Override
    public List<City> findAll() {
        return cityRepository.findAll();
    }

    @Override
    public void deleteById(int id) {
        cityRepository.deleteById(id);
    }
    
    
}
