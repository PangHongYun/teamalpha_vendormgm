package com.cognizant.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.domain.Account;
import com.cognizant.domain.Employee;
import com.cognizant.services.AccountService;

@Controller
public class RegistrationController {

	private final String prefixURL = "views";
	
	@Autowired
	AccountService accountService;

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public ModelAndView showRegister(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("registration");
		mav.addObject("registration", new Account());
		return mav;
	}

	@RequestMapping(value = "/registrationProcess", method = RequestMethod.POST)
	public ModelAndView registrationProcess(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("registration") Account registration) {
		ModelAndView mav = null;
		Account account = accountService.getUniqueAccount(registration.getAcc_email());
		if (account!=null) {
			String url = "error";
			mav = new ModelAndView(url);
			mav.addObject("message", "Email already in use!");
		} else {
			accountService.saveOrUpdate(registration);
			int type=registration.getAcc_type();
			if(type==1){
				String url = "vendorRegistration";
				mav = new ModelAndView(url);
				return mav;
			}
			else if(type==2){
				String url = "employeeRegistration";
				mav = new ModelAndView(url);
				Employee e=new Employee();
				e.setEmployeeEmail(registration.getAcc_email());
				mav.addObject("employee",e);
				return mav;
			}
		}
		return mav;
	}
}