package com.cognizant.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.domain.Vendor;
import com.cognizant.services.VendorService;

@Controller
public class VendorController {

	private final String prefixURL = "views";
	
	@Autowired
	VendorService vendorService;

	@RequestMapping(value = "/vendorView", method = RequestMethod.GET)
	public ModelAndView showVendor(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("vendorView");
		Vendor v = (Vendor) request.getSession().getAttribute("vendor");
		mav.addObject("vendorView", v);
		return mav;
	}

	@RequestMapping(value = "/viewAllApplication", method = RequestMethod.POST)
	public ModelAndView viewAllApplied(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("vendorView") Vendor v) {
		ModelAndView mav = null;
		vendorService.findAll();
		return mav;
	}
	@RequestMapping(value = "/submitVendorCert", method = RequestMethod.POST)
	public ModelAndView submitVendorCert(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("vendorView") Vendor v) {
		ModelAndView mav = null;
		String url = "employeeRegistration";
		mav = new ModelAndView(url);	
		return mav;
	}
	@RequestMapping(value = "/submitVendorApplication", method = RequestMethod.POST)
	public ModelAndView submitVendorAppl(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("vendorView") Vendor v) {
		ModelAndView mav = null;
		return mav;
	}
	@RequestMapping(value = "/changePassword", method = RequestMethod.POST)
	public ModelAndView changePassword(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("vendorView") Vendor v) {
		ModelAndView mav = null;
		return mav;
	}
	@RequestMapping(value = "/vendorRegistration", method = RequestMethod.POST)
	public ModelAndView editVendor(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("vendorView") Vendor v) {
		ModelAndView mav = null;
		return mav;
	}
	
}