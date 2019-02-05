package com.satyaj.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.satyaj.dao.IUserDao;
import com.satyaj.model.User;
import com.satyaj.repository.UserRepository;

@Repository
public class UserDao implements IUserDao{

	@Autowired
	UserRepository repository;
	
	@Override
	public void save(User user) {
		repository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		return repository.findAll();
	}

	@Override
	public User getUserById(long id) {
		return repository.findById(id).get(); 
	}

	@Override
	public void update(User user) {
//		repository.
		User us= repository.findById(user.getId()).get();
		
//		repository.save(user);
	}

	@Override
	public void delete(long id) {
		repository.deleteById(id);
	}

}
