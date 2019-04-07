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
import java.lang.annotation.ElementType;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = UniqueUsernameValidator.class)
@Retention(RUNTIME)
@Target({ ElementType.FIELD, ElementType.METHOD, ElementType.CONSTRUCTOR })
public @interface UniqueUsername {
	
	public String message() default "There is already user with this username!";
	
	public Class<?>[] groups() default {};
	
	public Class<? extends Payload>[] payload() default{};

}