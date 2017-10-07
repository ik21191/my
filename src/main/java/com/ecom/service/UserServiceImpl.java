package com.ecom.service;

import java.util.List;

import com.ecom.beans.User;
import com.ecom.dao.UserDao;
import com.ecom.dao.UserDaoImpl;

public class UserServiceImpl implements UserService {

	@Override
	public boolean checkEmail(String email) throws Exception {
		UserDao userDao = new UserDaoImpl(); 
		return userDao.checkEmail(email);
	}
	
	@Override
	public List userRegistration(User user) throws Exception {
		UserDao userDao = new UserDaoImpl();
		return userDao.userRegistration(user);
	}
	
	@Override
	public List registerEmail(String email) throws Exception {
		UserDao userDao = new UserDaoImpl();
		return userDao.registerEmail(email);
	}
	
	@Override
	public List validateUser(String user, String password) throws Exception {
		UserDao userDao = new UserDaoImpl();
		return userDao.validateUser(user, password);
	}
}
