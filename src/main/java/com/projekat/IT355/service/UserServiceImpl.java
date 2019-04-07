/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekat.IT355.service;

import com.projekat.IT355.dao.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.projekat.IT355.domain.User;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nemanja
 */
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    // set up constructor injection
    @Autowired
    public UserServiceImpl(UserRepository theUserRepository) {
        userRepository = theUserRepository;
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(int id) {
        Optional<User> result = userRepository.findById(id);//videti sta je optional tacno

        User theUser = null;
        if (result.isPresent()) {
            theUser = result.get();
        } else {
            throw new RuntimeException("Did not find employee id -- " + id);
        }

        return theUser;
    }

    @Override
    public void deleteUserById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public boolean isUsernameAlreadyInUse(String username) {

        System.out.println(userRepository.findByUsername(username) + "eeeeeee");
        return userRepository.findByUsername(username) != null;
    }

}
