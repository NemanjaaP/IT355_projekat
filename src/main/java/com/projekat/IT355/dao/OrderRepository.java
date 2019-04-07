/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekat.IT355.dao;

import com.projekat.IT355.domain.Orders;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Nemanja
 */
public interface OrderRepository extends JpaRepository<Orders, Integer> {

    public List<Orders> findByUsers_Id(int userId);


    @Modifying
    @Query(value = "UPDATE orders o SET o.STATUS_ID = ?1 WHERE ORDER_ID = ?2", nativeQuery = true)
    @Transactional(rollbackFor=Exception.class)
    public void updateOrder(int statusId, int orderId);

}
