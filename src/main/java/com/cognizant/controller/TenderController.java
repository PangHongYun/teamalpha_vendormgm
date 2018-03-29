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
import com.cognizant.services.CompanyService;
import com.cognizant.services.DepartmentService;
import com.cognizant.services.EmployeeService;
import com.cognizant.services.TenderService;
import com.cognizant.services.VendorAppService;
import com.cognizant.services.VendorService;

@Controller
public class TenderController {

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

	@RequestMapping(value = "/tenderCreationProcess", method = {
			RequestMethod.POST, RequestMethod.GET })
	public ModelAndView tenderCreationProcess(HttpServletRequest request,
			HttpServletResponse response,
			@ModelAttribute("tender") Tender tender) {
		ModelAndView mav = null;
		Employee emp = employeeService.findByEmployeeIdNo(request
				.getParameter("empId"));
		tenderService.saveOrUpdate(tender);
		String url = "employeeView";
		mav = new ModelAndView(url);
		Company company = companyService.getUniqueCompanyByName(emp
				.getCompany_name());
		Department dpmt = departmentService.findbyDepartmentNameAndComId(
				emp.getEmployeeDepartment(), company.getId());
		List<Tender> tenders = tenderService.findbyDeptId(dpmt.getId());
		int tenderSize = tenders.size();
		List<VendorApp> applications = new ArrayList<VendorApp>();
		for (int i = 0; i < tenderSize; i++) {
			List<VendorApp> venAppl = vendorAppService.findbyProjId(Long
					.toString(tenders.get(i).getId()));
			int venApplSize = venAppl.size();
			for (int j = 0; j < venApplSize; j++) {
				applications.add(venAppl.get(j));
			}
		}
		int size = applications.size();
		for (int i = 0; i < size; i++) {
			Long v_id = Long.parseLong(applications.get(i).getVendorId());
			Vendor v = vendorService.getUniqueVendorById(v_id);
			applications.get(i).setVendorId(v.getVendorName());
			Long proj_id = Long.parseLong(applications.get(i).getProjId());
			Tender proj = tenderService.findProjectID(proj_id);
			applications.get(i).setProjId(proj.getProject_Name());
		}
		request.getSession().setAttribute("applications", applications);
		request.getSession().setAttribute("employee", emp);
		return mav;
	}

	@RequestMapping(value = "/tenderCreation", method = RequestMethod.GET)
	public ModelAndView tenderCreation(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = null;
		Employee e = employeeService.findByEmployeeIdNo(request
				.getParameter("id"));
		Company c = companyService.getUniqueCompanyByName(e.getCompany_name());
		Department d = departmentService.findbyDepartmentNameAndComId(
				e.getEmployeeDepartment(), c.getId());
		Tender t = new Tender();
		t.setProject_Dept(Long.toString(d.getId()));
		t.setProject_Incharge(Long.toString(e.getId()));
		t.setCreatedBy(c.getCompanyName());
		String url = "tenderCreation";
		mav = new ModelAndView(url);
		mav.addObject("tender", t);
		request.getSession().setAttribute("tender", t);
		request.getSession().setAttribute("employee", e);
		return mav;
	}

	@RequestMapping(value = "/tenderEdit", method = RequestMethod.GET)
	public ModelAndView tenderEdit(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = null;
		Employee e = employeeService.findByEmployeeIdNo(request
				.getParameter("id"));
		Tender t = (Tender) tenderService.find(Long.parseLong(request.getParameter("tenId")));
		Company c = companyService.getUniqueCompanyByName(e.getCompany_name());
		Department d = departmentService.findbyDepartmentNameAndComId(
				e.getEmployeeDepartment(), c.getId());
		t.setProject_Dept(Long.toString(d.getId()));
		t.setProject_Incharge(Long.toString(e.getId()));
		t.setCreatedBy(c.getCompanyName());
		String url = "tenderCreation";
		mav = new ModelAndView(url);
		mav.addObject("tender", t);
		request.getSession().setAttribute("tender", t);
		request.getSession().setAttribute("employee", e);
		return mav;
	}
	
	@RequestMapping(value = "/tenderDelete", method = RequestMethod.GET)
	public ModelAndView tenderDeleteProcess(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = null;
		Employee e = employeeService.findByEmployeeIdNo(request
				.getParameter("id"));
		tenderService.deleteTenderProject(Long.parseLong(request.getParameter("tenId")));
		Company c= companyService.getUniqueCompanyByName(e.getCompany_name());
		Department d= departmentService.findbyDepartmentNameAndComId(e.getEmployeeDepartment(), c.getId());
		List<Tender> tender;
			 tender = tenderService.findbyDeptId(d.getId());
			 int listSize=tender.size();
			 for(int i=0;i<listSize;i++){				 
				 e=(Employee)employeeService.find(Long.parseLong(tender.get(i).getProject_Incharge()));
				 tender.get(i).setProject_Incharge(e.getEmployeeName());
			 }
		String url = "tenderView";
		mav = new ModelAndView(url);
		 request.setAttribute("tenders", tender);
		request.getSession().setAttribute("employee", e);
		return mav;
	}

	@RequestMapping(value = "/viewTender", method = RequestMethod.GET)
	public ModelAndView showAllTenders(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("tenderView");
		String search = request.getParameter("id");
		Employee e=(Employee)employeeService.find(Long.parseLong(search));
		Company c= companyService.getUniqueCompanyByName(e.getCompany_name());
		Department d= departmentService.findbyDepartmentNameAndComId(e.getEmployeeDepartment(), c.getId());
		List<Tender> tender;
			 tender = tenderService.findbyDeptId(d.getId());
			 int listSize=tender.size();
			 for(int i=0;i<listSize;i++){				 
				 e=(Employee)employeeService.find(Long.parseLong(tender.get(i).getProject_Incharge()));
				 tender.get(i).setProject_Incharge(e.getEmployeeName());
			 }
			 request.setAttribute("tenders", tender);
			 request.setAttribute("employee", e);
		return model;
	}
	
	@RequestMapping(value = "/tenderSearch", method = RequestMethod.GET)
	public ModelAndView searchTenders(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("vendorView");
		String search = request.getParameter("search");
		List<Tender> tender;
		if (search == null) {
			tender = tenderService.findAll();
			model.addObject("tender", tender);
		} else {
			// tender = tenderService.findByCompanyName(search);
			// model.addObject("tender", tender);
		}
		return model;
	}
}