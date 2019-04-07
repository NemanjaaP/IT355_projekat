/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekat.IT355.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Nemanja
 */
@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ITEM_ID")
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PRICE")
    private float price;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "PHOTO_PATH")
    private String photoPath;

    @ManyToOne(fetch = FetchType.EAGER,
            cascade = {CascadeType.MERGE,
                CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "PRODUCT_TYPE")
    private ProductType productType;

    @ManyToMany(mappedBy = "items")
    @JsonIgnore
    private List<User> users;

    public Item() {
    }

    public Item(int id, String name, float price, String description, String photoPath, ProductType productType) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.photoPath = photoPath;
        this.productType = productType;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public void addUser(User user) {
        if (users == null) {
            users = new ArrayList<>();
        }
        users.add(user);
    }

    @Override
    public String toString() {
        return "Item{" + "id=" + id + ", productType=" + productType + ", name=" + name + ", price=" + price + ", description=" + description + ", photoPath=" + photoPath + '}';
    }

}
