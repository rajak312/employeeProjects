package com.nt.service;

import java.util.List;

import com.nt.model.Employee;



public interface IEmployeeServiceMgmtService {
	
	public List<Employee> getReportOfEmployee();
	public Employee getEmployeeById(int id);
	public String editEmployee(Employee emp);
	public String deleteEmplyeeById(int id);
	public String registerEmployee(Employee emp);
	

}
