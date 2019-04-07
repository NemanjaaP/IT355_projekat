/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekat.IT355.service;

import java.util.List;
import com.projekat.IT355.domain.User;

/**
 *
 * @author Nemanja
 */
public interface UserService {
    public void save(User user);
    public List<User> getAllUsers();
    public User getUser(int id);
    public void deleteUserById(int id);   
    public User getUserByUsername(String username);
    public boolean isUsernameAlreadyInUse(String username);
}
