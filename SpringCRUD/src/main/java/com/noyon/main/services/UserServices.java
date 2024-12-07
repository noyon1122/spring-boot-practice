package com.noyon.main.services;

import java.util.List;

import com.noyon.main.entities.User;

public interface UserServices {
	
	User saveUser(User user);
	
	List<User> getAllUser();
	
	User getUserById(int id);

	List<User> getUsersByName(String name);

	User updateUser(User user, int id);
	
	void deleteUser(int id);

}
