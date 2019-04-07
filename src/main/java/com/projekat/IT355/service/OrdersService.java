/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekat.IT355.service;

import com.projekat.IT355.domain.Orders;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Nemanja
 */
public interface OrdersService {
    public void save(Orders order);
    public List<Orders> getAllOrders();
    public List<Orders> getAllOrdersByUser(int id);
    public void updateOrder(int statusId, int orderId);
    public Orders getOrderById(int id);
}
