/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekat.IT355.service;

import com.projekat.IT355.dao.ItemRepository;
import com.projekat.IT355.domain.Item;
import com.projekat.IT355.domain.ProductType;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nemanja
 */
@Service
public class ItemServiceImpl implements ItemService {

    private ItemRepository itemRepository;

    // set up constructor injection
    @Autowired
    public ItemServiceImpl(ItemRepository theItemRepository) {
        itemRepository = theItemRepository;
    }

    @Override
    public void saveOrUpdate(Item item) {
        itemRepository.save(item);
    }

    @Override
    public void deleteById(int id) {
        itemRepository.deleteById(id);
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public Item getItemById(int id) {
        Optional<Item> result = itemRepository.findById(id);//videti sta je optional tacno

        Item theItem = null;
        if (result.isPresent()) {
            theItem = result.get();
        } else {
            throw new RuntimeException("Did not find employee id -- " + id);
        }

        return theItem;
    }

    @Override
    public List<Item> getItemByProductType(int id) {
        return itemRepository.findByProductType_Id(id);
    }
}
