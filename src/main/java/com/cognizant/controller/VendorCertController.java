package com.cognizant.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.domain.Account;
import com.cognizant.domain.Company;
import com.cognizant.domain.Department;
import com.cognizant.domain.Employee;
import com.cognizant.domain.Tender;
import com.cognizant.domain.Vendor;
import com.cognizant.domain.VendorApp;
import com.cognizant.domain.VendorCertification;
import com.cognizant.services.CompanyService;
import com.cognizant.services.DepartmentService;
import com.cognizant.services.EmployeeService;
import com.cognizant.services.TenderService;
import com.cognizant.services.VendorAppService;
import com.cognizant.services.VendorCertificateService;
import com.cognizant.services.VendorService;

@Controller
public class VendorCertController {

	private final String prefixURL = "views";

	@Autowired
	EmployeeService employeeService;
	@Autowired
	CompanyService companyService;
	@Autowired
	DepartmentService departmentService;
	@Autowired
	TenderService tenderService;
	@Autowired
	VendorAppService vendorAppService;
	@Autowired
	VendorService vendorService;
	@Autowired
	VendorCertificateService vendorCertService;

	@RequestMapping(value = "/certCreationProcess", method = {
			RequestMethod.POST, RequestMethod.GET })
	public ModelAndView certCreationProcess(HttpServletRequest request,
			HttpServletResponse response,
			@ModelAttribute("cert") VendorCertification cert) {
		ModelAndView mav = null;
		Vendor v = vendorService.getUniqueVendorById(Long.parseLong(request
				.getParameter("vendor_Id")));
		vendorCertService.saveOrUpdate(cert);
		String url = "certView";
		mav = new ModelAndView(url);
		List<VendorCertification> certificates = vendorCertService.findByVendorId(v.getId());
		request.getSession().setAttribute("certs", certificates);
		request.getSession().setAttribute("vendor", v);
		return mav;
	}

	@RequestMapping(value = "/certCreation", method = RequestMethod.GET)
	public ModelAndView certCreation(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = null;
		Vendor v = vendorService.getUniqueVendorById(Long.parseLong(request
				.getParameter("id")));
		VendorCertification vc = new VendorCertification();
		vc.setVendor_Id(Long.toString(v.getId()));
		String url = "vendorCertCreation";
		mav = new ModelAndView(url);
		mav.addObject("cert", vc);
		request.getSession().setAttribute("cert", vc);
		request.getSession().setAttribute("vendor", v);
		return mav;
	}

	@RequestMapping(value = "/certEdit", method = RequestMethod.GET)
	public ModelAndView certEdit(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = null;
		Vendor v = vendorService.getUniqueVendorById(Long.parseLong(request
				.getParameter("id")));
		VendorCertification vc = vendorCertService.findByCertificateId(Long.parseLong(request.getParameter("vcId")));
		String url = "tenderCreation";
		mav = new ModelAndView(url);
		mav.addObject("cert", vc);
		request.getSession().setAttribute("cert", vc);
		request.getSession().setAttribute("vendor", v);
		return mav;
	}
	
	@RequestMapping(value = "/certDelete", method = RequestMethod.GET)
	public ModelAndView certDeleteProcess(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = null;
		Vendor v = vendorService.getUniqueVendorById(Long.parseLong(request
				.getParameter("id")));
		vendorCertService.deleteByCertificateId(Long.parseLong(request.getParameter("vcId")));
		List<VendorCertification> certs;
			 certs = vendorCertService.findByVendorId(v.getId());
			 int listSize=certs.size();
			 for(int i=0;i<listSize;i++){				 
				 certs.get(i).setVendor_Id(v.getVendorName());
			 }
		String url = "certView";
		mav = new ModelAndView(url);
		request.setAttribute("certs", certs);
		request.getSession().setAttribute("vendor", v);
		return mav;
	}

	@RequestMapping(value = "/viewCert", method = RequestMethod.GET)
	public ModelAndView showAllVendorCert(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("certView");
		String vid = request.getParameter("id");
		Vendor v=(Vendor)vendorService.find(Long.parseLong(vid));
		List<VendorCertification> certs;
			 certs = vendorCertService.findByVendorId(v.getId());
			 model.addObject("certs", certs);
			 request.getSession().setAttribute("certs", certs);
				request.getSession().setAttribute("vendor", v);
		return model;
	}
}