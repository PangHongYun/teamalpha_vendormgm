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
public class LoginController {

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

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView showLogin(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("login", new Account());
		return mav;
	}

	@RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
	public ModelAndView loginProcess(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("login") Account login) {
		ModelAndView mav = null;
		Account account = accountService.getUniqueAccount(login.getAcc_email());
		if (login.getAcc_email().equalsIgnoreCase(account.getAcc_email())
				&& login.getAcc_password().equalsIgnoreCase(
						account.getAcc_password())) {
			int type=account.getAcc_type();
			if(type==1){
				Vendor v=vendorService.getUniqueVendor(account.getAcc_email());
				if(v==null){
					String url = "vendorRegistration";	
					mav = new ModelAndView(url);	
					v=new Vendor();
					v.setVendorEmail(account.getAcc_email());
					mav.addObject("vendor",v);		
					return mav;
				}
				else{
					String url = "vendorView";
					mav = new ModelAndView(url);
					List<Tender> tenders=tenderService.findAll();
					int size=tenders.size();
					for(int i=0;i<size;i++){
						Long d_id=Long.parseLong(tenders.get(i).getProject_Dept());
						Department dept=departmentService.findbyDepartmentId(d_id);
						Company com=(Company) companyService.find(dept.getCom_id());
						tenders.get(i).setProject_Dept(com.getCompanyName());
					}
					request.getSession().setAttribute("tenders", tenders);
					request.getSession().setAttribute("vendor", v);
					return mav;
				}
				
			}
			else if(type==2){
				Employee e=employeeService.getUniqueEmployee(account.getAcc_email());				
				if(e==null){
					String url = "employeeRegistration";
					mav = new ModelAndView(url);
					e=new Employee();
					e.setEmployeeEmail(account.getAcc_email());
					mav.addObject("employee",e);
					return mav;
				}
				else{
					String c_name=e.getCompany_name();
					Company c=companyService.getUniqueCompanyByName(c_name);
					if(c==null){
						String url = "companyRegistration";
						mav = new ModelAndView(url);
						c=new Company();
						c.setCompanyName(c_name);
						mav.addObject("company",c);
						mav.addObject("dept",e.getEmployeeDepartment());
						return mav;
					}
					else{
						String dept=e.getEmployeeDepartment();
						Department department=departmentService.findbyDepartmentNameAndComId(dept, c.getId());
						if(department==null){
							department=new Department();
							department.setCom_id(c.getId());
							department.setDept_name(dept);
							departmentService.saveOrUpdate(department);
						}
						String url = "employeeView";
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
				}
			}
			else{
				String url = "main";
				mav = new ModelAndView(url);
				mav.addObject("firstname", "Admin");	
			}
		} else {
			String url = "error";
			mav = new ModelAndView(url);
			mav.addObject("message", "Username or Password is wrong!!");
		}
		return mav;
	}
}