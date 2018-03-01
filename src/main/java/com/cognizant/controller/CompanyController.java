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
public class CompanyController {

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

	@RequestMapping(value = "/companyRegProcess", method ={ RequestMethod.GET,RequestMethod.POST})
	public ModelAndView registrationProcess(HttpServletRequest request,
			HttpServletResponse response,
			@ModelAttribute("company") Company com) {
		ModelAndView mav = null;
		Employee emp=employeeService.findByEmployeeIdNo(request.getParameter("empId"));
		companyService.saveOrUpdate(com);
		emp.setCompany_name(com.getCompanyName());
		employeeService.saveOrUpdate(emp);
		String dept=emp.getEmployeeDepartment();
			Department department = departmentService
					.findbyDepartmentNameAndComId(dept, com.getId());
			if (department == null) {
				department = new Department();
				department.setCom_id(com.getId());
				department.setDept_name(dept);
				departmentService.saveOrUpdate(department);
			}
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

	@RequestMapping(value = "/comEdit", method = RequestMethod.GET)
	public ModelAndView editCom(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = null;
		String cname = request.getParameter("name");
		Company c = companyService.getUniqueCompanyByName(cname);
		String eid = request.getParameter("id");
		Employee e = (Employee) employeeService.find(Long.parseLong(eid));
		String url = "companyRegistration";
		mav = new ModelAndView(url);
		mav.addObject("company", c);
//		mav.addObject("employee", e);
		request.getSession().setAttribute("employee", e);
		return mav;
	}
}