package com.yk.employee.model.service;

import static com.yk.employee.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.yk.employee.common.JDBCTemplate;
import com.yk.employee.model.dao.EmployeeDao;
import com.yk.employee.vo.Employee;

public class EmployeeService {
	private Connection conn = null;

	
	public EmployeeService() {
		this.conn = getConnection();
	}
	
	public List<Employee> findAll() {
		
		List<Employee> employees = new EmployeeDao().findAll(conn);
		if(!employees.isEmpty()) {
			JDBCTemplate.commit(conn);
		}
			JDBCTemplate.close(conn);
			return employees;
	}
	
	public List<Employee> findDeptTitle(String deptTitle) {
		List<Employee> employees = new EmployeeDao().findDeptTitle(conn, deptTitle);
		
		if(!employees.isEmpty()) {
			JDBCTemplate.close(conn);
		}
		return employees;
			
		
		
	}
}
