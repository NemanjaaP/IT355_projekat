/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekat.IT355.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.projekat.IT355.domain.User;

/**
 *
 * @author Nemanja
 */
public interface UserRepository extends JpaRepository<User, Integer>{
    public User findByUsername(String username);
    public User findByEmail(String email);
}
