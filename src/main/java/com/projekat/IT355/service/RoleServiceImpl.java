/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekat.IT355.service;

import com.projekat.IT355.dao.RoleRepository;
import com.projekat.IT355.dao.UserRepository;
import com.projekat.IT355.domain.Role;
import com.projekat.IT355.domain.User;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nemanja
 */
@Service
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;

    // set up constructor injection
    @Autowired
    public RoleServiceImpl(RoleRepository theRoleRepository) {
        roleRepository = theRoleRepository;
    }

    @Override
    public void save(Role role) {
        roleRepository.save(role);
    }

    @Override
    public Role getRoleById(int i) {
        Optional<Role> result = roleRepository.findById(i);//videti sta je optional tacno

        Role theRole = null;
        if (result.isPresent()) {
            theRole = result.get();
        } else {
            throw new RuntimeException("Did not find employee id -- " + i);
        }

        return theRole;
    }

}
