/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekat.IT355.dao;

import com.projekat.IT355.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Nemanja
 */
public interface RoleRepository extends JpaRepository<Role, Integer> {
    
}
