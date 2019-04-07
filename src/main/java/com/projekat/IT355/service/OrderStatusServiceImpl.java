/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekat.IT355.service;

import com.projekat.IT355.dao.OrderStatusRepository;
import com.projekat.IT355.domain.OrderStatus;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nemanja
 */
@Service
public class OrderStatusServiceImpl implements OrderStatusService {

    private OrderStatusRepository orderStatus;

    // set up constructor injection
    @Autowired
    public OrderStatusServiceImpl(OrderStatusRepository theOrderStatus) {
        orderStatus = theOrderStatus;
    }

    @Override
    public String getOrderStatus(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<OrderStatus> getAllStatus() {
        List<OrderStatus> all = orderStatus.findAll();
        return all;
    }

}
