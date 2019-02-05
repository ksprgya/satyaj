package com.satyaj.dao;

import java.util.List;

import com.satyaj.model.User;

public interface IUserDao {
	public void save(User user);
	public List<User> getAllUsers();
	public User getUserById(long id);
	public void update(User user);
	public void delete(long id);

}
