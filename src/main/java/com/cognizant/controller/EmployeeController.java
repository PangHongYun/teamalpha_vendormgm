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
import com.cognizant.domain.Company;
import com.cognizant.domain.Department;
import com.cognizant.domain.Employee;
import com.cognizant.services.CompanyService;
import com.cognizant.services.DepartmentService;
import com.cognizant.services.EmployeeService;

@Controller
public class EmployeeController {

	private final String prefixURL = "views";
	
	@Autowired
	EmployeeService employeeService;
	@Autowired
	CompanyService companyService;
	@Autowired
	DepartmentService departmentService;

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
		ModelAndView mav = new ModelAndView("employeeRegistration");
		request.getParameter("acc_email");
		String email=request.getSession().getAttribute("account").toString();
		Employee e= new Employee();
		e.setEmployeeEmail(email);
		mav.addObject("employeeRegistration", e);
		return mav;
	}
	
	@RequestMapping(value = "/empRegistrationProcess", method = RequestMethod.POST)
	public ModelAndView registrationProcess(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("employeeRegistration") Employee e_registration) {
		ModelAndView mav = null;
		Employee e = employeeService.getUniqueEmployee(e_registration.getEmployeeEmail());
		if (e!=null) {
			String url = "error";
			mav = new ModelAndView(url);
			mav.addObject("message", "Email already in use!");
		} else {
			employeeService.saveOrUpdate(e_registration);
			String c_name=e_registration.getCompany_name();
			Company c=companyService.getUniqueCompanyByName(c_name);
			if(c==null){
				String url = "companyRegistration";
				mav = new ModelAndView(url);	
				return mav;
			}
			else{
				String dept=e.getEmployeeDepartment();
				Department department=departmentService.findbyDepartmentNameAndComId(dept, c.getId());
				if(department==null){
					String url = "deptRegistration";
					mav = new ModelAndView(url);	
					return mav;
				}
				else{
					String url = "employeeView";
					mav = new ModelAndView(url);	
					return mav;
				}
			}
		}
		return mav;
	}

	@RequestMapping(value = "/viewAllApplications", method = RequestMethod.POST)
	public ModelAndView viewAllApplied(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("employeeView") Employee e) {
		ModelAndView mav = null;
//		Department dept=e.getEmployeeDepartment();
//		List<Vendor> appList = getVendorApp(dept.getId());
//		mav.addObject("VendorsApplied", appList);
		return mav;
	}
	@RequestMapping(value = "/createEmployeeTender", method = RequestMethod.POST)
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
	@RequestMapping(value = "/companyRegistration", method = RequestMethod.POST)
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