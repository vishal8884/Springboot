package com.vishal.loginLogout.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vishal.loginLogout.entities.User;
import com.vishal.loginLogout.repository.UserRepository;

@Controller
public class userController {

	@Autowired
	UserRepository userRepo;
	
	@RequestMapping("/")
	public String home()
	{
		return "home";
	}
	
	
	@RequestMapping("/showreg")
	public String showRegistrationPage()
	{
		return "RegisterUser";
	}
	
	@RequestMapping("/reguser")
	public String registerUser(@ModelAttribute("user") User user , ModelMap modelMap)
	{
		User savedUser = null;
		try {  savedUser = userRepo.save(user);} catch (Exception e) {System.out.println("Dublicate user entered");}
		
		modelMap.addAttribute("savedUser", savedUser);
		
		return "loginPage";
	}
	
	
	
	@RequestMapping("/user/login")
	public String login()
	{
		return "loginPage";
	}
	
	@RequestMapping("/user/dashboard")
	public String dashboard()
	{
		return "user";
	}
	



}
