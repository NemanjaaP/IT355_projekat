/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekat.IT355.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projekat.IT355.validator.UniqueUsername;
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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Nemanja
 */
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private int id;

    @Size(min = 5, message="Size must be at least 3 characters long.")
    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "USERNAME")
    @UniqueUsername
    private String username;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "enabled")
    private int enabled;

    @ManyToOne(fetch = FetchType.EAGER,
            cascade = {CascadeType.MERGE,
                CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "CITY_ID")
    private City city;

    @ManyToMany(cascade = {
        CascadeType.PERSIST,
        CascadeType.MERGE
    })
    @JoinTable(name = "user_item",
            joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "ITEM_ID")
    )
    @JsonIgnore
    private List<Item> items;

    @OneToMany(mappedBy = "users",
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE,
                CascadeType.REFRESH,
                CascadeType.DETACH})
    @JsonIgnore
    private List<Orders> orders;

    @ManyToMany(cascade = {
        CascadeType.PERSIST,
        CascadeType.MERGE
    })
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    @JsonIgnore
    private List<Role> roles;

    public User() {
    }

    public User(String firstName, String lastName, String username, String email, String password, City city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.city = city;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void addItem(Item item) {
        if (items == null) {
            items = new ArrayList<>();
        }
        items.add(item);
    }

    public void addRole(Role role) {
        if (roles == null) {
            roles = new ArrayList<>();
        }
        roles.add(role);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }
    

    @Override
    public String toString() {
        return "Users{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", username=" + username + ", email=" + email + ", city=" + city + '}';
    }

}
