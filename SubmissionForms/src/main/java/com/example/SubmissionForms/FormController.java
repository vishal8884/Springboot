package com.example.SubmissionForms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FormController {
	@Autowired
	CustomerRepo repo;
	
	@RequestMapping("/")
	public String details()
	{
		return "eduraka";
	}
	
	@RequestMapping("/details")
	public String details(Customers customers)
	{
		repo.save(customers);
		return "eduraka";
	}
	
	@RequestMapping("/getdetails")
	public String getdetails()
	{
		return "ViewCustomers";
	}
	
	
	
	@PostMapping("/getdetails")
	public ModelAndView getDetails(@RequestParam("cid") int cid)
	{
		ModelAndView mv = new ModelAndView("retrive");
		
		Customers customers =repo.findById(cid).orElse(null);
		
		mv.addObject(customers);
		return mv;
	}
	
}
