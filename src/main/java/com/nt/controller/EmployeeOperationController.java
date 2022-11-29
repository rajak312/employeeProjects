package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.model.Employee;
import com.nt.service.IEmployeeServiceMgmtService;
import com.nt.validations.EmployeeValidation;

@Controller("empController")
public class EmployeeOperationController {
	
	@Autowired
	private IEmployeeServiceMgmtService service;
	
	@Autowired
	private EmployeeValidation empValidator;
	
	@GetMapping("/")
	public String showHomePage() {
		
		return "home";
	}
	
	@GetMapping("/report")
	public String showReport(Map<String,Object> map) {
		System.out.println("presenting the report----------------");
		List<Employee> list=service.getReportOfEmployee();
		map.put("empList", list);
		return "show_report";
	}
	
	@GetMapping("/edit")
	public String editEmployeeFormDisplay(@ModelAttribute("emp") Employee emp,@RequestParam("empno") int empno) {
		Employee employee=service.getEmployeeById(empno);
		
		//employee=emp
		BeanUtils.copyProperties(employee, emp);
		return "edit_employee";
	}
	
	@PostMapping("/edit")
	public String editEmployeeFormSubmission(RedirectAttributes attr,
			                   @ModelAttribute("emp") Employee emp,BindingResult errors) {
		
		if(emp.getVflag().equalsIgnoreCase("no")) {
			System.out.println("editing validation is started");
			
			if(errors.hasFieldErrors()) {
				return "edit_employee";
			}
			if(empValidator.supports(Employee.class)) {
				empValidator.validate(emp, errors);
				if(errors.hasErrors()) {
					return "edit_employee";
				}
			}
			
			//application error configuration 
			if(emp.getJob().equalsIgnoreCase("hacker")) {
				errors.rejectValue("job","job.error");
				return "edit_employee";
			}
			
		}
		
		
		
		String msg=service.editEmployee(emp);
		/*List<Employee> list=service.getReportOfEmployee();
		map.put("empList", list);
		map.put("msg",msg);*/
		attr.addFlashAttribute("msg", msg);
		return "redirect:report";
		
	}
	
	@GetMapping("/delete")
	public String deleteEmployeeDetails(@ModelAttribute("empno") int empno,
			                    RedirectAttributes attr/*,Map<String,Object> map*/) {
		
		String msg=service.deleteEmplyeeById(empno);
		/*List<Employee> list=service.getReportOfEmployee();
		map.put("empList", list);
		map.put("msg", msg);*/
		
		attr.addFlashAttribute("msg",msg);
		
		return "redirect:report";
		
	}
	@GetMapping("/add")
	public String registerEmployeeForm(@ModelAttribute("emp")Employee emp) {
		return "employee_add";
	}
	
	@PostMapping("/add")
	public String registerEmployee(RedirectAttributes attr,@ModelAttribute("emp")Employee emp,BindingResult errors) {
		 
		//System.out.println("Adding the employee---------");
		
		if(emp.getVflag().equalsIgnoreCase("no")) {
			if(errors.hasFieldErrors()) {
				return "employee_add";
			}
			 
			if(empValidator.supports(emp.getClass())) {
				empValidator.validate(emp, errors);
				if(errors.hasErrors()) {
					return "employee_add";
				}
			}
			
			//Application logics error
			
			if(emp.getJob().equalsIgnoreCase("hacker")) {
				errors.rejectValue("job","job.error");
				return "employee_add";
			}
		}
		
		
		
		
		String msg=service.registerEmployee(emp);

		
		
		attr.addFlashAttribute("msg",msg);
		return "redirect:report";
	}

}
