/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekat.IT355.controller;

import com.projekat.IT355.domain.Item;
import com.projekat.IT355.domain.ProductType;
import com.projekat.IT355.service.ItemService;
import com.projekat.IT355.service.ProductTypeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Nemanja
 */
@Controller
@RequestMapping("/")
public class ItemController {

    private ItemService itemService;
    private ProductTypeService productTypeService;
    RestTemplate restTemplate = new RestTemplate();

    private static String UPLOADED_FOLDER = "src//main//resources//static//img//";

    // set up constructor injectionC:\Users\Nemanja\Desktop\Spring\IT355
    @Autowired
    public ItemController(ItemService theItemService, ProductTypeService theProductTypeService) {
        itemService = theItemService;
        productTypeService = theProductTypeService;
    }

    //Adding new item - loads the form and call getters
    @GetMapping("/admin/addItemForm")
    public String addItem(Model theModel) {
        List<ProductType> theProductTypes = productTypeService.findAll(); //dodati rest za ovo
        Item item = new Item();
        theModel.addAttribute("item", item);
        theModel.addAttribute("theProductTypes", theProductTypes);
        return "admin/addItemForm";
    }

    //Saves new item to database - REST
    @PostMapping("/admin/save")
    public String saveItem(@ModelAttribute("item") Item theItem,
            @RequestParam("file") MultipartFile file) throws Exception {

        if (file.isEmpty()) {
            throw new Exception();
        }
        try {
            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);

        } catch (IOException e) {
            e.printStackTrace();
        }

        final String uri = "http://localhost:8080/api/items";
        theItem.setPhotoPath("/img/" + file.getOriginalFilename());
        restTemplate.postForEntity(uri, theItem, Item.class);
        return "redirect:/admin/addItemForm";
    }

    //Shows all items - REST
    @GetMapping("/admin/itemsList")
    public String itemsList(Model theModel) {
        final String uri = "http://localhost:8080/api/items";
        List<Item> items = restTemplate.getForObject(uri, List.class);
        theModel.addAttribute("items", items);
        return "admin/itemsList";
    }

    //Show all items based on product type
    @GetMapping("/itemsList")
    public String itemList(@RequestParam("productTypeId") int theProductTypeId,
            Model theModel) {
        final String uri = "http://localhost:8080/api/itemss";
        List<Item> items = restTemplate.getForObject(uri + "/" + theProductTypeId, List.class);
        theModel.addAttribute("items", items);
        return "admin/itemsList";
    }

    //Delete item by id - REST
    @GetMapping("/admin/deleteItem")
    public String delete(@RequestParam("itemId") int theId) {
        final String uri = "http://localhost:8080//api/admin/items";
        restTemplate.delete(uri + "/" + theId);
        return "redirect:/admin/itemsList";
    }

    //Show form for update - REST
    @GetMapping("/admin/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("itemId") int theId,
            Model theModel) {
        
        List<ProductType> theProductTypes = productTypeService.findAll();
        theModel.addAttribute("theProductTypes", theProductTypes);

        final String uri = "http://localhost:8080/api/items";
        Item item = restTemplate.getForObject(uri + "/" + theId, Item.class);
        RestTemplate restTemplate1 = new RestTemplate();
        restTemplate1.put(uri, item);
        theModel.addAttribute("item", item);
        return "admin/updateItemForm";
    }

    
    //updates item 
    @PostMapping("/admin/update")
    public String updateItem(@ModelAttribute("item") Item theItem) {
        final String uri = "http://localhost:8080/api/items";
        restTemplate.postForEntity(uri, theItem, Item.class);
        return "admin/successfulUpdate";
    }
    
    //Show one item - REST 
    @GetMapping("/item/showItem")
    public String showItem(@RequestParam("itemId") int theId,
            Model theModel) {
        final String uri = "http://localhost:8080/api/items";
        Item item = restTemplate.getForObject(uri + "/" + theId, Item.class);
        theModel.addAttribute("item", item);
        return "showItem";
    }
}
