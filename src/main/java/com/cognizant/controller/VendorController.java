package com.cognizant.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.domain.Employee;
import com.cognizant.domain.Vendor;
import com.cognizant.services.VendorService;

@Controller
public class VendorController {

	private final String prefixURL = "views";

	@Autowired
	VendorService vendorService;

	@RequestMapping(value = "/vendorRegistrationProcess", method = RequestMethod.POST)
	public ModelAndView editVendor(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("vendor") Vendor v) {
		ModelAndView mav = null;
		vendorService.saveOrUpdate(v);
		String url = "vendorView";
		mav = new ModelAndView(url);
		request.getSession().setAttribute("vendor", v);
		return mav;
	}

	@RequestMapping(value = "/venEdit", method = RequestMethod.GET)
	public ModelAndView editVen(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = null;
		String vid = request.getParameter("id");
		Vendor v = vendorService.getUniqueVendorById(Long.parseLong(vid));
		String url = "vendorRegistration";
		mav = new ModelAndView(url);
		mav.addObject("vendor", v);
		return mav;
	}
}