/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekat.IT355.service;

import com.projekat.IT355.domain.Item;
import com.projekat.IT355.domain.ProductType;
import java.util.List;

/**
 *
 * @author Nemanja
 */
public interface ItemService {
   public void saveOrUpdate(Item item);
   public void deleteById(int id);
   public List<Item> getAllItems();
   public Item getItemById(int id);
   public List<Item> getItemByProductType(int id);
}
