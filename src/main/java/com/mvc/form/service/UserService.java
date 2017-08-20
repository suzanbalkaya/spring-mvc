package com.mvc.form.service;

import java.util.List;

import com.mvc.form.model.Entity.User;
//UserService interface'i
public interface UserService {
	//this method work, Pull user with ID 
	User findById(String  id);
	//This method is used to list the users
	List<User> findAll();
	//users save and update
	void saveOrUpdate(User user);
	//Delete user with ID 
	void delete(String  id);
	
}
