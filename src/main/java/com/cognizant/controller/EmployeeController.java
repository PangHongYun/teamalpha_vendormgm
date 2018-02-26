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
import com.cognizant.services.EmployeeService;

@Controller
public class EmployeeController {

	private final String prefixURL = "views";
	
	@Autowired
	EmployeeService employeeService;

	@RequestMapping(value = "/employeeView", method = RequestMethod.GET)
	public ModelAndView showEmployee(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("employeeView");
		Employee e = (Employee) request.getSession().getAttribute("employee");
		mav.addObject("employeeView", e);
		return mav;
	}
	@RequestMapping(value = "/employeeRegistration", method = RequestMethod.GET)
	public ModelAndView createEmployee(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("employeeCreation");
		Employee e= new Employee();
		mav.addObject("employeeCreation", e);
		return mav;
	}

	@RequestMapping(value = "/viewAllApplications", method = RequestMethod.POST)
	public ModelAndView viewAllApplied(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("employeeView") Employee e) {
		ModelAndView mav = null;
		return mav;
	}
	@RequestMapping(value = "/submitEmployeeTender", method = RequestMethod.POST)
	public ModelAndView submitEmpTender(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("employeeView") Employee e) {
		ModelAndView mav = null;
		return mav;
	}
	@RequestMapping(value = "/editEmployeeTender", method = RequestMethod.POST)
	public ModelAndView editEmpTender(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("employeeView") Employee e) {
		ModelAndView mav = null;
		return mav;
	}
	@RequestMapping(value = "/deleteEmployeeTender", method = RequestMethod.POST)
	public ModelAndView deleteEmpTender(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("employeeView") Employee e) {
		ModelAndView mav = null;
		return mav;
	}
	@RequestMapping(value = "/changePw", method = RequestMethod.POST)
	public ModelAndView changePassword(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("employeeView") Employee e) {
		ModelAndView mav = null;
		return mav;
	}
	@RequestMapping(value = "/employeeRegistration", method = RequestMethod.POST)
	public ModelAndView editEmployee(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("employeeView") Employee e) {
		ModelAndView mav = null;
		return mav;
	}
	@RequestMapping(value = "/companyCreation", method = RequestMethod.POST)
	public ModelAndView createCompany(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("employeeView") Employee e) {
		ModelAndView mav = null;
		return mav;
	}
	@RequestMapping(value = "/companyEdit", method = RequestMethod.POST)
	public ModelAndView editCompany(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("employeeView") Employee e) {
		ModelAndView mav = null;
		return mav;
	}
	@RequestMapping(value = "/companyDelete", method = RequestMethod.POST)
	public ModelAndView deleteCompany(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("employeeView") Employee e) {
		ModelAndView mav = null;
		return mav;
	}
	@RequestMapping(value = "/departmentCreation", method = RequestMethod.POST)
	public ModelAndView createDepartment(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("employeeView") Employee e) {
		ModelAndView mav = null;
		return mav;
	}
	@RequestMapping(value = "/departmentEdit", method = RequestMethod.POST)
	public ModelAndView editDepartment(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("employeeView") Employee e) {
		ModelAndView mav = null;
		return mav;
	}
	@RequestMapping(value = "/departmentDelete", method = RequestMethod.POST)
	public ModelAndView deleteDepartment(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("employeeView") Employee e) {
		ModelAndView mav = null;
		return mav;
	}
	
}