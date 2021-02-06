package com.vishal.loginLogout.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceptionController {


	
	@RequestMapping("/403")
	public String accessDeniedPage()
	{
		return "its ok you dont have access";
	}
}
