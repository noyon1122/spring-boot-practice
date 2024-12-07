package com.noyon.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.noyon.main.entities.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

	List<User> findByName(String name);

}
