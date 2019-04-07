/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekat.IT355.rest;

import com.projekat.IT355.domain.Item;
import com.projekat.IT355.service.ItemService;
import com.projekat.IT355.service.ProductTypeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Nemanja
 */
@RestController
@RequestMapping("/api")
public class ItemRestController {

    private ItemService itemService;
    private ProductTypeService productTypeService;

    // set up constructor injection
    @Autowired
    public ItemRestController(ItemService theItemService, ProductTypeService theProductTypeService) {
        itemService = theItemService;
        productTypeService = theProductTypeService;
    }

    //Returns all items
    @GetMapping("/items")
    public List<Item> getAllItems() {
        List<Item> items = itemService.getAllItems();
        return items;
    }

    //Saves new item to database
    @PostMapping("/items")
    public Item saveItem(@RequestBody Item theItem) {
        itemService.saveOrUpdate(theItem);
        return theItem;
    }

    @PutMapping("/items")
    public Item updateItem(@RequestBody Item theItem) {
        itemService.saveOrUpdate(theItem);
        return theItem;
    }

    //Deleting item by id
    @DeleteMapping("/admin/items/{itemId}")
    public String delete(@PathVariable int itemId) {
        itemService.deleteById(itemId);
        return "Item with id " + itemId + " is deleted";
    }

    //Return item based on id
    @GetMapping("/items/{itemId}")
    public Item getItemById(@PathVariable int itemId) {
        Item item = itemService.getItemById(itemId);
        return item;
    }

    //Return item based on id
    @GetMapping("/itemss/{theProductTypeId}")
    public List<Item> getAllItemsByProductType(@PathVariable int theProductTypeId) {
        List<Item> items = itemService.getItemByProductType(theProductTypeId);
        return items;
    }
}
