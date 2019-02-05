package com.satyaj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satyaj.dao.IUserDao;
import com.satyaj.model.User;
import com.satyaj.service.IUserService;

@Service
public class UserService implements IUserService{

	@Autowired
	IUserDao dao; 
	
	@Override
	public void save(User user) {
		dao.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		return dao.getAllUsers();
	}

	@Override
	public User getUserById(long id) {
		return dao.getUserById(id);
	}

	@Override
	public void update(User user) {
		dao.update(user);
	}

	@Override
	public void delete(long id) {
		dao.delete(id);
	}

}
