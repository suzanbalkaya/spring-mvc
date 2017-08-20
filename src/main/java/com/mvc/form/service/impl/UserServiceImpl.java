package com.mvc.form.service.impl;

import java.util.List;
import java.util.UUID;

import com.mvc.form.model.dao.UserDao;
import com.mvc.form.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.form.model.Entity.User;
//this is service class
@Service("userService")
public class UserServiceImpl implements UserService {
	//UserDao class used for db
	@Autowired
	UserDao userDao;
	//pull user with id
	@Override
	public User findById(String  id) {
		return userDao.findById(id);
	}

	// list the users
	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}

	//user save and update operation
	@Override
	public void saveOrUpdate(User user) {
		if (findById(user.getId())==null) {
			//create generic ıd for user
			user.setId( UUID.randomUUID().toString());
			userDao.save(user);
		} else {
			userDao.save(user);
		}

	}

	//delete user
	@Override
	public void delete(String  id) {
		userDao.delete(id);
	}

}
