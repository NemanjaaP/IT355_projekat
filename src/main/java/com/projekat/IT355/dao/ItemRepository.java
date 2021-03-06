/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekat.IT355.dao;

import com.projekat.IT355.domain.Item;
import com.projekat.IT355.domain.ProductType;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Nemanja
 */
public interface ItemRepository extends JpaRepository<Item, Integer> {
    public List<Item> findByProductType_Id(int productTypeId);
}
