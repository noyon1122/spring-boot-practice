package com.noyon.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.noyon.main.entities.User;
import com.noyon.main.services.UserServices;

@RestController
public class MyController {

	@Autowired
	private UserServices userServices;
	
	@PostMapping("/users")
	public ResponseEntity<User> saveUser(@RequestBody User user)
	{
		return new ResponseEntity<User>(userServices.saveUser(user),HttpStatus.CREATED);
		
	}
	
	//get All user 
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUser()
	{
		return new ResponseEntity<List<User>>(userServices.getAllUser(), HttpStatus.OK);
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable int id)
	{
		return new ResponseEntity<User>(userServices.getUserById(id), HttpStatus.OK);
	}
	
	@GetMapping("/user/{name}")
	public ResponseEntity<List<User>> getUserById(@PathVariable String name)
	{
		return new ResponseEntity<List<User>>(userServices.getUsersByName(name), HttpStatus.OK);
	}
	
	@PutMapping("/users/{id}")
	public ResponseEntity<User> updateUser(@RequestBody User user , @PathVariable int id)
	{
		return new ResponseEntity<User>(userServices.updateUser(user, id),HttpStatus.OK);
	}
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable int id)
	{
		userServices.deleteUser(id);
		return ResponseEntity.ok("User Deleted Successfully!!");
	}
}
