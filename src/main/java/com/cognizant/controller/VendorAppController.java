package com.cognizant.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.domain.VendorApp;
import com.cognizant.services.VendorAppService;

@Controller
@RequestMapping("/employeeView")
public class VendorAppController {

	private final String prefixURL = "views";
	
	@Autowired
	VendorAppService vendorAppService;
	
	@RequestMapping(value="/appSearch",method=RequestMethod.GET)
	public ModelAndView showAllTenders(HttpServletRequest request){
		ModelAndView model = new ModelAndView("employeeView");
		String search = request.getParameter("search");
		List<VendorApp> vendorApp;
		if(search==null){
			vendorApp = vendorAppService.findAll();
			model.addObject("applications", vendorApp);
		}else{
//			tender = tenderService.findByCompanyName(search);
//			model.addObject("tender", tender);
		}
		return model;
	}	
}