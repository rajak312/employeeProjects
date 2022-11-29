package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.model.Employee;
import com.nt.repo.IEmployeeRepo;

@Service("empService")
public class EmployeeServiceMgmtImpl implements IEmployeeServiceMgmtService {

	@Autowired
	private IEmployeeRepo repo;
	
	@Override
	public List<Employee> getReportOfEmployee() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
	
	@Override
	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id).get();
	}
	
	@Override
	public String editEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return "Employee Number "+repo.save(emp).getEmpno()+ " Record Updated Successfully";
	}
	
	@Override
	public String deleteEmplyeeById(int id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
		return "Employee Number " +id +" Record Deleted Successfully";
	}
	
	@Override
	public String registerEmployee(Employee emp) {
		// TODO Auto-generated method stub
		
		return "Employee Registered Successfully with Employee Id "+repo.save(emp).getEmpno();
	}
}
