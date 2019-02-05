package com.satyaj.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.satyaj.model.User;
import com.satyaj.model.UserDocuments;
import com.satyaj.service.IUserService;

@Controller
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	IUserService service;
	
	
	@RequestMapping("/registerUser")
	public String formUser(){
		return "reguser";
	}
	
	@RequestMapping("/uploadDocument/{id}")
	public String documentUpload(){
		logger.info(" uploading file--- ");		
		return "userdocuments";
	}
	
	@RequestMapping(value = "/saveDocument" , method = RequestMethod.POST)
	public String saveDocument(@RequestParam("file") MultipartFile uploadfile, @RequestParam("user_id") Long id){
		String fileName= uploadfile.getOriginalFilename();
		logger.info(" file is name -  "+fileName);
		
		String fileuri=ServletUriComponentsBuilder.fromCurrentContextPath().path("/docs").path(fileName).toString();
		logger.info(" uri is  "+fileuri);
//		service.save(user);
//		userDocuments.getUser().getId();
//		return "redirect:/uploadDocument/"+id+fileName+fileuri;
		return "userdocuments";		
	}
	
	@RequestMapping(value = "/saveUser" , method = RequestMethod.POST)
	public String saveUser(@Valid User user){
		service.save(user);
		return "redirect:/users";
	}
	
	@RequestMapping("/users")
	public ModelAndView getAllUsers(){
		List<User> list = service.getAllUsers();
        return new ModelAndView("viewusers","list",list);  		
	}
	
	/* It opens the record for the given id in editstudent page */
	 @RequestMapping(value="/edituser/{id}")  
	    public String edit(@PathVariable long id,ModelMap model){  
	       User user=service.getUserById(id);  
	       model.addAttribute("user", user);
	       return "edituser";
	    } 
	 
	 /* It updates record for the given id in editstudent page and redirects to /viewstudents */  
	 @RequestMapping(value="/updateUser",method = RequestMethod.POST)  
	    public ModelAndView editsave(@ModelAttribute("user") User user){  
	    	System.out.println("id is"+user.getId());
	    	service.update(user);  
	        return new ModelAndView("redirect:/viewusers/1");  
	    }  
	 
	 /* It deletes record for the given id  and redirects to /viewuser*/  
	    @RequestMapping(value="/deleteuser/{id}",method = RequestMethod.GET)  
	    public ModelAndView delete(@PathVariable long id){  
	    	service.delete(id);  
	        return new ModelAndView("redirect:/viewusers/1");  
	    }  


}
