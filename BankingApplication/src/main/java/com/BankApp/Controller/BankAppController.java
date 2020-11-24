package com.BankApp.Controller;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.BankApp.Logic.PinLogic;
import com.BankApp.Repo.BankAppRepo;
import com.BankApp.Repo.BankPinRepo;
import com.BankApp.model.BankCustomer;
import com.BankApp.model.BankCustomerPin;

@Component
@Controller
public class BankAppController {
	
	@Autowired
	BankAppRepo repo;
	
	@Autowired
	BankPinRepo pinrepo;
	
	PinLogic pinlogic = new PinLogic();
	
	@RequestMapping("/")
	public String home()
	{
		return "HomePage";
	}
	
	@RequestMapping("/NewCustRegister")
	public ModelAndView newUserRegisteration(BankCustomer bankCustomer,BankCustomerPin backCustomerPin)
	{
		ModelAndView mv = new ModelAndView("RegistrationSucessfulPage");
		repo.save(bankCustomer);
		
		backCustomerPin.setPin(pinlogic.getPin());
		backCustomerPin.setCustId(bankCustomer.getCustId());
		pinrepo.save(backCustomerPin);
		mv.addObject("backCustomerPin",backCustomerPin);
		return mv;
	}
	
	@RequestMapping("/ExistCustLogin")
	public ModelAndView existingUserLogin(@RequestParam() int pin , @RequestParam() int custId)
	{
		ModelAndView mv = new ModelAndView("afterUserLoginPage");
		ModelAndView mv2 = new ModelAndView("ExistingUserLoginPage");
		
		mv.addObject("pin",pin);
		mv.addObject("custId", custId);
		
		BankCustomerPin backCustomerPin = pinrepo.findById(custId).orElse(new BankCustomerPin());
		
		int dbcustId = backCustomerPin.getCustId();
		int dbPin = backCustomerPin.getPin();
		

			
		
		if(custId == dbcustId  && pin == dbPin)
		{
			return mv;
		}
		
		
		
		else
		{
			return mv2;
		}
			
		
	}

}
