/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekat.IT355.service;

import com.projekat.IT355.dao.OrderRepository;
import com.projekat.IT355.dao.ProductTypeRepository;
import com.projekat.IT355.domain.Item;
import com.projekat.IT355.domain.Orders;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nemanja
 */
@Service
public class OrdersServiceImpl implements OrdersService {

    private OrderRepository orderRepository;

    // set up constructor injection
    @Autowired
    public OrdersServiceImpl(OrderRepository theOrderRepository) {
        orderRepository = theOrderRepository;
    }

    @Override
    public void save(Orders order) {
        orderRepository.save(order);
    }

    @Override
    public List<Orders> getAllOrders() {
        List<Orders> list = orderRepository.findAll();
        return list;
    }

    @Override
    public List<Orders> getAllOrdersByUser(int id) {
        List<Orders> list = orderRepository.findByUsers_Id(id);
        return list;
    }

    @Override
    public void updateOrder(int statusId, int orderId) {
        orderRepository.updateOrder(statusId, orderId);
    }

    @Override
    public Orders getOrderById(int id) {
        Optional<Orders> result = orderRepository.findById(id);

        Orders theOrder = null;
        if (result.isPresent()) {
            theOrder = result.get();
        } else {
            throw new RuntimeException("Did not find order id -- " + id);
        }

        return theOrder;
    }

}
