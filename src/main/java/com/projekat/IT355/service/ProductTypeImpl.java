/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekat.IT355.service;

import com.projekat.IT355.dao.CityRepository;
import com.projekat.IT355.dao.ProductTypeRepository;
import com.projekat.IT355.domain.ProductType;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nemanja
 */
@Service
public class ProductTypeImpl implements ProductTypeService {

    private ProductTypeRepository productTypeRepository;

    // set up constructor injection
    @Autowired
    public ProductTypeImpl(ProductTypeRepository theProductTypeRepository) {
        productTypeRepository = theProductTypeRepository;
    }

    @Override
    public List<ProductType> findAll() {
        return productTypeRepository.findAll();
    }

}
