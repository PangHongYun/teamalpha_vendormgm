package com.cognizant.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.domain.Vendor;
import com.cognizant.domain.VendorCertification;
import com.cognizant.services.VendorCertificateService;
import com.cognizant.services.VendorService;

@Controller
@RequestMapping("/vendorView")
public class CertificationController {

	@Autowired
	VendorCertificateService vendorCertificateservice;
	
	@Autowired
	VendorService vendorService;
	
	@RequestMapping(value="/allCerts",method=RequestMethod.GET)
	public ModelAndView showAllCertificates(HttpServletRequest request){
		ModelAndView model = new ModelAndView("vendorCertView");
		String search = request.getParameter("search");
		List<VendorCertification> vendorCert;
		if(search==null){
			vendorCert = vendorCertificateservice.findAll();
			model.addObject("vendorCert", vendorCert);
		}else{
			vendorCert = vendorCertificateservice.findByVendorId(search);
			model.addObject("vendorCert", vendorCert);
		}
		return model;
	}
	
//	@RequestMapping(value="/certByVendor",method=RequestMethod.GET)
//	public ModelAndView showCertificatesByVendor(HttpServletRequest request){
//		
//		
//		String search = request.getParameter("search");
//		ModelAndView model = new ModelAndView("certBySpecificVendor");	
//		List<VendorCertification> vendorCert = vendorCertificateservice.findByVendorId(search);
//		model.addObject("vendorCert", vendorCert);
//		return model;	
//	}
	
	
}
