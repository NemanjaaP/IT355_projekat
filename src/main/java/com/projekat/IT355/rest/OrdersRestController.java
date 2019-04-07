/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekat.IT355.rest;

import com.projekat.IT355.dao.ProductTypeRepository;
import com.projekat.IT355.domain.Orders;
import com.projekat.IT355.domain.User;
import com.projekat.IT355.service.OrdersService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("api")
public class OrdersRestController {

    private final OrdersService orderService;

    // set up constructor injection
    @Autowired
    public OrdersRestController(OrdersService theOrderService) {
        orderService = theOrderService;
    }

    @GetMapping("/orders")
    public List<Orders> getAllOrders() {
        return orderService.getAllOrders();
    }

    @PostMapping("/orders")
    public String saveUser(@RequestBody Orders order) {
        orderService.save(order);
        return null;
    }

    @GetMapping("/orders/{userId}")
    public List<Orders> getUserOrders(@PathVariable int userId) {
        return orderService.getAllOrdersByUser(userId);
    }

/*    @GetMapping("/admin/updateStatus/{statusId}/{orderId}")
    public String updateStatus(@PathVariable("statusId") int statusId,
                               @PathVariable("orderId") int orderId) {
        orderService.updateOrder(statusId, orderId);
        return "uspesno";
    }*/

}
