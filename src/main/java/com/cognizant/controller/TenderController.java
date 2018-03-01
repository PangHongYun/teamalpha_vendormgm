package com.cognizant.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.domain.Tender;
import com.cognizant.services.TenderService;

@Controller
@RequestMapping("/vendorView")
public class TenderController {

	private final String prefixURL = "views";
	
	@Autowired
	TenderService tenderService;
	
	@RequestMapping(value="/tenderSearch",method=RequestMethod.GET)
	public ModelAndView showAllTenders(HttpServletRequest request){
		ModelAndView model = new ModelAndView("vendorView");
		String search = request.getParameter("search");
		List<Tender> tender;
		if(search==null){
			tender = tenderService.findAll();
			model.addObject("tender", tender);
		}else{
//			tender = tenderService.findByCompanyName(search);
//			model.addObject("tender", tender);
		}
		return model;
	}	
}