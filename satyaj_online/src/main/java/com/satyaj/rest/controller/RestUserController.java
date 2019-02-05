package com.satyaj.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.satyaj.model.User;
import com.satyaj.service.IUserService;

@RestController
@RequestMapping("/rest")
public class RestUserController {
	@Autowired
	IUserService service;
	
	@RequestMapping(value = "/users" , method = RequestMethod.GET)
	public List<User> getUser(){
		return service.getAllUsers();
	}
	@RequestMapping(value = "/user/{id}" , method = RequestMethod.GET)
	public User getUserById(@PathVariable("id") Long id){
		return service.getUserById(id);
	}
}
