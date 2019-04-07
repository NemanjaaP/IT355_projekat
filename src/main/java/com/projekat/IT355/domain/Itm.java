/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekat.IT355.domain;

import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Nemanja
 */
public class Itm {
    private List<Item> items;

    public Itm() {
    }

    public Itm(List<Item> items) {
        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
    
    public String getItemsList() {
        String str = "";
        for (Item list1 : this.items) {
            str += list1.getName();
        }
        
        return str;
    }

    @Override
    public String toString() {
        return "Itm{" + "items=" + items + '}';
    }
    
    
    
    
}
