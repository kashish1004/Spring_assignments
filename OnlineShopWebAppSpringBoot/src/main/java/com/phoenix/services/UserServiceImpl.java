package com.phoenix.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phoenix.entities.User;
import com.phoenix.exceptions.UserAlreadyExistsException;
import com.phoenix.exceptions.UserNotFoundException;
import com.phoenix.repositories.UserRepository;
/*
 * @author kashish.jain@stltech.in
 * @version 1.0
 * @creation_date 02-Aug-2021
 * @copyright Sterlite Technologies Ltd.
 */
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public User findByUsername(String username) throws UserNotFoundException {
		// TODO Auto-generated method stub
		/*
		 * Optional<User> op= userRepo.findById(username); if(op.isPresent()) return
		 * op.get(); else throw new UserNotFoundException("Sorry User is not found");
		 */
		return userRepo.findById(username).orElseThrow(()->new UserNotFoundException("Sorry User with username "+ username+ " is not found"));
		
	}

	@Override
	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	@Override
	public void add(User user) throws UserAlreadyExistsException {
		// TODO Auto-generated method stub
		Optional<User> op = userRepo.findById(user.getUsername());
		if(op.isPresent()) {
			throw new UserAlreadyExistsException("Sorry! User with username "+ user.getUsername()+ " Already Exists");
		}
		else {
			userRepo.save(user);
		}
	}

	@Override
	public void edit(User user){
		// TODO Auto-generated method stub
		userRepo.save(user);
	}

	@Override
	public void remove(User user) throws UserNotFoundException {
		// TODO Auto-generated method stub
		userRepo.delete(user);
	}
}
