package com.phoenix.services;

import java.util.List;

import com.phoenix.entities.User;
import com.phoenix.exceptions.UserAlreadyExistsException;
import com.phoenix.exceptions.UserNotFoundException;
/*
 * @author kashish.jain@stltech.in
 * @version 1.0
 * @creation_date 02-Aug-2021
 * @copyright Sterlite Technologies Ltd.
 */
public interface UserService {
	User findByUsername(String username) throws UserNotFoundException;
	List<User> findAllUsers();
	void add(User user) throws UserAlreadyExistsException;
	void edit(User user);
	void remove(User user) throws UserNotFoundException;
	
	
}
