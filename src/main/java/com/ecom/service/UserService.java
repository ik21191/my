package com.ecom.service;

import java.util.List;

import com.ecom.beans.User;

public interface UserService {
	boolean checkEmail(String email)throws Exception;
	List userRegistration(User user)throws Exception;
	List registerEmail(String email)throws Exception;
	List validateUser(String user,String password)throws Exception;
}
