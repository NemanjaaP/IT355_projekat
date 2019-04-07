/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekat.IT355.service;

import com.projekat.IT355.domain.OrderStatus;
import java.util.List;

/**
 *
 * @author Nemanja
 */
public interface OrderStatusService {
    public String getOrderStatus(int id);
    public List<OrderStatus> getAllStatus();
}
