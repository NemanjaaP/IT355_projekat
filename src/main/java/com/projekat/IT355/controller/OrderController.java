/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekat.IT355.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.projekat.IT355.domain.Custom;
import com.projekat.IT355.domain.Item;
import com.projekat.IT355.domain.OrderStatus;
import com.projekat.IT355.domain.Orders;
import com.projekat.IT355.domain.User;
import com.projekat.IT355.service.ItemService;
import com.projekat.IT355.service.OrderStatusService;
import com.projekat.IT355.service.OrdersService;
import com.projekat.IT355.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Nemanja
 */
@Controller
@RequestMapping("/")
public class OrderController {

    private final OrdersService orderService;
    private final OrderStatusService orderStatusService;

    // set up constructor injection
    @Autowired
    public OrderController(OrdersService theOrdersService, OrderStatusService theOrderStatusService,
            UserService theUserService, ItemService theItemService) {
        orderStatusService = theOrderStatusService;
        orderService = theOrdersService;
    }

    String s = "";

    @RequestMapping(value = "/user/order", method = {RequestMethod.GET, RequestMethod.POST})
    public String confirmOrder() {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String str1 = auth.getName();

        RestTemplate restTemplate = new RestTemplate();

        //retrive user by username
        final String uri = "http://localhost:8080/api/user";
        User user = restTemplate.getForObject(uri + "/" + str1, User.class);

        int i = user.getId();

        final String uri1 = "http://localhost:8080/api/users/items";
        List<Item> items = restTemplate.getForObject(uri1 + "/" + i, List.class);

        System.out.println(items);

        ObjectMapper obm = new ObjectMapper();
        List<Item> items2 = obm.convertValue(items, new TypeReference<List<Item>>() {
        }
        );

        String str = "";
        float sum = 0;
        int br = 0;
        for (Item itm : items2) {
            str += "Item " + br + ":" + itm.getName() + ", ";
            sum += itm.getPrice();
            br++;
        }

        orderService.save(new Orders(str, sum, user, new OrderStatus(1)));


        return "redirect:/index";
    }

    @GetMapping("/user/viewOrders")
    public String viewOrders(Model theModel) {

        RestTemplate restTemplate = new RestTemplate();

        String username = getUsername();
        final String uri1 = "http://localhost:8080/api/user";
        User user = restTemplate.getForObject(uri1 + "/" + username, User.class);

        int id = user.getId();
        final String uri = "http://localhost:8080/api/orders";
        List<Orders> userOrders = restTemplate.getForObject(uri + "/" + id, List.class);

        theModel.addAttribute("orders", userOrders);

        return "userOrders";
    }

    @GetMapping("/admin/viewOrders")
    public String viewAllOrders(Model theModel) {
        RestTemplate restTemplate = new RestTemplate();

        final String uri = "http://localhost:8080/api/orders";

        List<Orders> orders = restTemplate.getForObject(uri, List.class);

        theModel.addAttribute("orders", orders);

        return "userOrders";
    }

    @GetMapping("/admin/showOrderStatusUpdateForm")
    public String showFormForUpdate(@RequestParam("orderId") int theId,
            Model theModel) {

        List<OrderStatus> status = orderStatusService.getAllStatus();
        Orders order = orderService.getOrderById(theId);
        OrderStatus orderStatus = new OrderStatus();

        theModel.addAttribute("order", order);
        theModel.addAttribute("status", status);
        theModel.addAttribute("orderStatus", orderStatus);

        return "updateOrderStatus";
    }

    @PostMapping("/admin/saveStatusUpdate")
    public String saveStatusUpdate(@ModelAttribute("order") Orders order) {
        orderService.save(order);
        return "redirect:/admin/viewOrders";
    }

    public String getUsername() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String str1 = auth.getName();
        return str1;
    }
}
