package com.loan.reviewfood.service;

import com.loan.reviewfood.dao.UserDAO;
import com.loan.reviewfood.entity.User;

public class UserService {

	public boolean insertUser(String username, String email, String password) {
		UserDAO userDAO = new UserDAO();
		boolean isAccountExist = userDAO.isUsernameExists(username);
		if(isAccountExist) {
			return false;
		}
		User newUser = new User();
		newUser.setUsername(username);
		newUser.setEmail(email);
		newUser.setPassword(password);
		newUser.setRole("USER");
		userDAO.insertUser(newUser);
		return true;
	}
	
	public User findByUsernameAndPassword(String username, String password) {
		UserDAO userDAO = new UserDAO();
		return userDAO.findByUsernameAndPassword(username, password);
	}
	
}
