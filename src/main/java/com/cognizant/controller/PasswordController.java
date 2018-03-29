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
import com.cognizant.services.AccountService;
import com.cognizant.services.CompanyService;
import com.cognizant.services.DepartmentService;
import com.cognizant.services.EmployeeService;
import com.cognizant.services.TenderService;
import com.cognizant.services.VendorAppService;
import com.cognizant.services.VendorService;

@Controller
public class PasswordController {

	private final String prefixURL = "views";
	
	@Autowired
	AccountService accountService;	
	@Autowired
	VendorService vendorService;
	@Autowired
	VendorAppService vendorAppService;
	@Autowired
	EmployeeService employeeService;
	@Autowired
	CompanyService companyService;
	@Autowired
	DepartmentService departmentService;
	@Autowired
	TenderService tenderService;

	@RequestMapping(value = "/passwordChange", method = RequestMethod.GET)
	public ModelAndView passwordChange(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = null;
		String acc_email;
		Vendor v=(Vendor) vendorService.find(Long.parseLong(request.getParameter("id")));
		Employee e=new Employee();
		if(v==null){
			e=(Employee) employeeService.find(Long.parseLong(request.getParameter("id")));
			acc_email=e.getEmployeeEmail();
		}
		else{
			acc_email=v.getVendorEmail();
		}
		Account acc=accountService.getUniqueAccount(acc_email);
		String url = "changePassword";
		mav = new ModelAndView(url);
		mav.addObject("account", acc);
		request.getSession().setAttribute("account", acc);
		return mav;			
	}
	
	@RequestMapping(value = "/changePasswordProcess", method = RequestMethod.POST)
	public ModelAndView changePasswordProcess(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = null;
		String pw=request.getParameter("newPassword");
		String id=request.getParameter("userId");
		Account a=(Account) accountService.find(Long.parseLong(id));
		a.setAcc_password(pw);
		accountService.saveOrUpdate(a);
		String email=a.getAcc_email();
		String url ="";
		Vendor v=vendorService.getUniqueVendor(email);
		Employee e=new Employee();
		if(v==null){
			e=employeeService.getUniqueEmployee(email);
			url="employeeView";
			mav = new ModelAndView(url);
			Company com=companyService.getUniqueCompanyByName(e.getCompany_name());
			Department dpmt = departmentService.findbyDepartmentNameAndComId(e.getEmployeeDepartment(), com.getId());
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
				v=vendorService.getUniqueVendorById(v_id);
				applications.get(i).setVendorId(v.getVendorName());
				Long proj_id=Long.parseLong(applications.get(i).getProjId());
				Tender proj=tenderService.findProjectID(proj_id);
				applications.get(i).setProjId(proj.getProject_Name());
			}
			request.getSession().setAttribute("applications", applications);
			request.getSession().setAttribute("employee", e);
		}
		else{
			url="vendorView";
			mav = new ModelAndView(url);
			List<Tender> tenders=tenderService.findAll();
			int Tensize=tenders.size();
			for(int i=0;i<Tensize;i++){
				Long d_id=Long.parseLong(tenders.get(i).getProject_Dept());
				Department dept=departmentService.findbyDepartmentId(d_id);
				Company com=(Company) companyService.find(dept.getCom_id());
				tenders.get(i).setProject_Dept(com.getCompanyName());
			}
			request.getSession().setAttribute("tenders", tenders);
			request.getSession().setAttribute("vendor", v);
		}
		return mav;			
	}
}