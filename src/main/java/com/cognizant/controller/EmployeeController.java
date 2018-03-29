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
public class EmployeeController {

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

	@RequestMapping(value = "/empRegProcess", method = RequestMethod.POST)
	public ModelAndView registrationProcess(HttpServletRequest request,
			HttpServletResponse response,
			@ModelAttribute("employee") Employee e_registration) {
		ModelAndView mav = null;
		employeeService.saveOrUpdate(e_registration);
		String c_name = e_registration.getCompany_name();
		Company c = companyService.getUniqueCompanyByName(c_name);
		if (c == null) {
			String url = "companyRegistration";
			mav = new ModelAndView(url);
			c = new Company();
			c.setCompanyName(c_name);
			mav.addObject("company", c);
			request.getSession().setAttribute("employee", e_registration);
			return mav;
		} else {
			String dept = e_registration.getEmployeeDepartment();
			Department department = departmentService
					.findbyDepartmentNameAndComId(dept, c.getId());
			if (department == null) {
				department = new Department();
				department.setCom_id(c.getId());
				department.setDept_name(dept);
				departmentService.saveOrUpdate(department);
			}
			String url = "employeeView";
			mav = new ModelAndView(url);
			Company company = companyService
					.getUniqueCompanyByName(e_registration.getCompany_name());
			Department dpmt = departmentService.findbyDepartmentNameAndComId(
					e_registration.getEmployeeDepartment(), company.getId());
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
			request.getSession().setAttribute("employee", e_registration);
			return mav;

		}
	}

	@RequestMapping(value = "/empEdit", method = RequestMethod.GET)
	public ModelAndView editEmp(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = null;
		String eid = request.getParameter("id");
		Employee e = employeeService.findByEmployeeIdNo(eid);
		String url = "employeeRegistration";
		mav = new ModelAndView(url);
		mav.addObject("employee", e);
		return mav;
	}

	@RequestMapping(value = "/changePw", method = RequestMethod.POST)
	public ModelAndView changePassword(HttpServletRequest request,
			HttpServletResponse response,
			@ModelAttribute("employeeView") Employee e) {
		ModelAndView mav = null;
		return mav;
	}

	@RequestMapping(value = "/companyDelete", method = RequestMethod.POST)
	public ModelAndView deleteCompany(HttpServletRequest request,
			HttpServletResponse response,
			@ModelAttribute("employeeView") Employee e) {
		ModelAndView mav = null;
		return mav;
	}

	@RequestMapping(value = "/departmentEdit", method = RequestMethod.GET)
	public ModelAndView editDepartment(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = null;
		String emp_id=request.getParameter("id");
		Employee e=employeeService.findByEmployeeIdNo(emp_id);
		Company c = companyService.getUniqueCompanyByName(e.getCompany_name());
		Department d = departmentService.findbyDepartmentNameAndComId(e.getEmployeeDepartment(), c.getId());
		String url="changeDepartment";
		mav=new ModelAndView(url);
		mav.addObject("department",d);
		request.getSession().setAttribute("old_dept_name", d.getDept_name());		
		request.getSession().setAttribute("employee",e);
		return mav;
	}
	
	@RequestMapping(value = "/editDepartmentProcess", method = RequestMethod.POST)
	public ModelAndView editDepartmentProcess(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("department") Department d) {
		ModelAndView mav = null;
		String old_name=request.getParameter("odName");
		Employee e= employeeService.findByEmployeeIdNo(request.getParameter("empId"));
		Company c=(Company) companyService.find(d.getCom_id());
		List<Employee> empList =employeeService.findByEmployeeDeptAndCompany(old_name,c.getCompanyName());
		for(int i=0;i<empList.size();i++){
			empList.get(i).setEmployeeDepartment(d.getDept_name());
			employeeService.saveOrUpdate(empList.get(i));
		}
		departmentService.saveOrUpdate(d);
		String url = "employeeView";
		mav = new ModelAndView(url);
		Company com=companyService.getUniqueCompanyByName(e.getCompany_name());
		Department dpmt = departmentService.findbyDepartmentNameAndComId(d.getDept_name(), com.getId());
		List<Tender> tenders=tenderService.findbyDeptId(dpmt.getId());
		int tenderSize=tenders.size();
		List<VendorApp> applications= new ArrayList<VendorApp>();
		for(int i=0;i<tenderSize;i++){
			List<VendorApp> venAppl=vendorAppService.findbyProjId(Long.toString(tenders.get(i).getId()));
			int venApplSize=venAppl.size();
			for(int j=0;j<venApplSize;j++){
				applications.add(venAppl.get(j));
			}
		}
		int size=applications.size();
		for(int i=0;i<size;i++){
			Long v_id=Long.parseLong(applications.get(i).getVendorId());
			Vendor v=vendorService.getUniqueVendorById(v_id);
			applications.get(i).setVendorId(v.getVendorName());
			Long proj_id=Long.parseLong(applications.get(i).getProjId());
			Tender proj=tenderService.findProjectID(proj_id);
			applications.get(i).setProjId(proj.getProject_Name());
		}
		request.getSession().setAttribute("applications", applications);
		request.getSession().setAttribute("employee", e);
		return mav;
	}

	@RequestMapping(value = "/departmentDelete", method = RequestMethod.POST)
	public ModelAndView deleteDepartment(HttpServletRequest request,
			HttpServletResponse response,
			@ModelAttribute("employeeView") Employee e) {
		ModelAndView mav = null;
		return mav;
	}

}