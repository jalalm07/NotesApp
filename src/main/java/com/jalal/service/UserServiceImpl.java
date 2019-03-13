package com.jalal.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.jalal.dao.UserDao;
import com.jalal.model.Login;
import com.jalal.model.User;

public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	public void register(User user) {
		userDao.register(user);
	}
	
	public User validateUser(Login login) {
		return userDao.validateUser(login); 
		}
	 

}
