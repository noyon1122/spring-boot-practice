package com.noyon.main.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.noyon.main.entities.User;
import com.noyon.main.repository.UserRepo;

import ch.qos.logback.core.joran.conditional.IfAction;
import jakarta.persistence.EntityNotFoundException;

@Service
public class UserServ implements UserServices {
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public User saveUser(User user) {
		
		return userRepo.save(user);
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		
		Optional<User> user=userRepo.findById(id);
				
		if(user.isPresent())
		{
			return user.get();
		}
		else {
			return null;
		}
		
	}

	@Override
	public List<User> getUsersByName(String name) {
		// TODO Auto-generated method stub
		
		List<User> user=userRepo.findByName(name);
		return user;
	}

	@Override
	public User updateUser(User user, int id) {
		User existingUser = userRepo.findById(id).orElseThrow(
				()-> new EntityNotFoundException()
				);
		  existingUser.setName(user.getName());
		  existingUser.setDept(user.getDept());
		  existingUser.setUniversity(user.getUniversity());
		  userRepo.save(existingUser);
		  
		return existingUser;
	}

	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		userRepo.deleteById(id);
		
	}

}
