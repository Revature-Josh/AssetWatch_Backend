package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.revature.dao.UserDAO;
import com.revature.dto.UserDTO;
import com.revature.model.User;

@Component
public class UserService {
	
	@Autowired
	UserDAO userDAO;
	
	//to add a new feature, all that's necessary is to define a function with @Transactional
	// note: if the feature does not affect the database, like this one, you should also set the readOnly property to true
	@Transactional(readOnly = true)
	public User login(UserDTO userDTO) {
		return userDAO.login(userDTO);
	}
}
