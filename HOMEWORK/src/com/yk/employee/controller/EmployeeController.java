package com.yk.employee.controller;

import java.util.List;

import com.yk.employee.model.service.EmployeeService;
import com.yk.employee.vo.Employee;

public class EmployeeController {

	
	public List<Employee> findAll() {
		
		List<Employee> employees = new EmployeeService().findAll();
		return employees;
		
	}
	
	public List<Employee> findDeptTitle(String deptTitle) {
		List<Employee> employees = new EmployeeService().findDeptTitle(deptTitle);
		return employees;
	}
	
	
}
