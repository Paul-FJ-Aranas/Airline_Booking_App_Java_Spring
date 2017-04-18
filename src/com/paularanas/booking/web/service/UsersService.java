package com.paularanas.booking.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paularanas.booking.web.dao.User;
import com.paularanas.booking.web.dao.UsersDao;

@Service("usersService")
public class UsersService {
	private UsersDao usersDao;

	@Autowired
	public void setUserDao(UsersDao userDao) {
		this.usersDao = userDao;
	}
	public void createUser(User user) {
	     usersDao.create(user);
	
		
	}
	public boolean usernameExists(String username) {
		return usersDao.usernameExists(username);
	}
	
	public boolean passwordExists(String password) {
		return usersDao.passwordExists(password);
	}

}
