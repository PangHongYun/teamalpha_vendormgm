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
import com.cognizant.domain.Vendor;
import com.cognizant.services.AccountService;
import com.cognizant.services.EmployeeService;
import com.cognizant.services.VendorService;

@Controller
public class LoginController {

	private final String prefixURL = "views";
	
	@Autowired
	AccountService accountService;
	VendorService vendorService;
	EmployeeService employeeService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView showLogin(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("login", new Account());
		return mav;
	}

	@RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
	public ModelAndView loginProcess(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("login") Account login) {
		ModelAndView mav = null;
		Account account = accountService.getUniqueAccount(login.getAcc_email());
		if (login.getAcc_email().equalsIgnoreCase(account.getAcc_email())
				&& login.getAcc_password().equalsIgnoreCase(
						account.getAcc_password())) {
			int type=account.getAcc_type();
			if(type==1){
				String url = "vendorView";
				mav = new ModelAndView(url);			
				Vendor v=vendorService.getUniqueVendor(account.getAcc_email());
				//mav.addObject("vendor", v);	
				request.getSession().setAttribute("vendor", v);
			}
			else if(type==2){
				String url = "employeeView";
				mav = new ModelAndView(url);
				Employee e=employeeService.getUniqueEmployee(account.getAcc_email());
				mav.addObject("firstname", account.getAcc_email());	
				//mav.addObject("employee", e);	
				request.getSession().setAttribute("employee", e);
			}
			else{
				String url = "main";
				mav = new ModelAndView(url);
				mav.addObject("firstname", "Admin");	
			}
		} else {
			String url = "error";
			mav = new ModelAndView(url);
			mav.addObject("message", "Username or Password is wrong!!");
		}
		return mav;
	}
}