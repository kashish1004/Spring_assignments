package com.phoenix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.phoenix.entities.User;
/*
 * @author kashish.jain@stltech.in
 * @version 1.0
 * @creation_date 02-Aug-2021
 * @copyright Sterlite Technologies Ltd.
 */

public interface UserRepository extends JpaRepository<User, String> {
	
}
