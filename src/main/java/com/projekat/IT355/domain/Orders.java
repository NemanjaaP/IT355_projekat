/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekat.IT355.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Nemanja
 */
@Entity
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID")
    private int id;

    @ManyToOne(
            cascade = {
                CascadeType.MERGE,
                CascadeType.DETACH,
                CascadeType.REFRESH})
    @JoinColumn(name = "USER_ID")
    private User users;

    @Column(name = "ITEMS")
    private String name;

    @Column(name = "SUM")
    private float finalSum;

    @ManyToOne(
            cascade = {
                CascadeType.MERGE,
                CascadeType.DETACH,
                CascadeType.REFRESH})
    @JoinColumn(name = "STATUS_ID")
    private OrderStatus orderStatus;

    
    public Orders() {
    }

    public Orders(String name, float finalSum, User users, OrderStatus status) {
        this.name = name;
        this.finalSum = finalSum;
        this.users = users;
        this.orderStatus = status;
    }

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
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

    public float getFinalSum() {
        return finalSum;
    }

    public void setFinalSum(float finalSum) {
        this.finalSum = finalSum;
    }

    @Override
    public String toString() {
        return "Orders{" + "id=" + id + ", users=" + users + ", name=" + name + ", finalSum=" + finalSum + ", orderStatus=" + orderStatus + '}';
    }
    
    

}
