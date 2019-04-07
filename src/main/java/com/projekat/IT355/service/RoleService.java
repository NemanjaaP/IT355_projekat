/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekat.IT355.service;

import com.projekat.IT355.domain.Role;

/**
 *
 * @author Nemanja
 */
public interface RoleService {
    public void save(Role role);
    public Role getRoleById(int i); 
}
