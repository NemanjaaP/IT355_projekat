/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekat.IT355.validator;

/**
 *
 * @author Nemanja
 */
import com.projekat.IT355.service.UserService;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

    private UserService userService;

    @Autowired
    public UniqueUsernameValidator(UserService theUserService) {
        userService = theUserService;
    }

    public UniqueUsernameValidator() {
    }

    @Override
    public void initialize(UniqueUsername arg0) {
    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        return !userService.isUsernameAlreadyInUse(username);
    }
}
