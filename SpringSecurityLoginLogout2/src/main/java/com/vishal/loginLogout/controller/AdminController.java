package com.vishal.loginLogout.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@RequestMapping("/login")
	public String login()
	{
		return "AdminLogin";
	}
	
	@RequestMapping("/dashboard")
	public String dashboard()
	{
		return "admin";
	}
	
//	@RequestMapping("/logout")
//	public String logout()
//	{
//		return "";
//	}
	
	

}
