package com.yk.employee.model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InvalidPropertiesFormatException;
import java.util.List;
import java.util.Properties;

import com.yk.employee.common.JDBCTemplate;
import com.yk.employee.vo.Employee;

public class EmployeeDao {
	private Properties prop = new Properties();
	
	
	public EmployeeDao() {
	try {
		prop.loadFromXML(new FileInputStream("resources/member-mapper.xml"));
	} catch (InvalidPropertiesFormatException e) {
		e.printStackTrace();
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}	
	}
	
	
	public List<Employee> findAll(Connection conn) {
		List<Employee> employees = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("findAll");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Employee employee = new Employee(rset.getInt("EMP_ID")
						                     ,rset.getString("EMP_NAME")
						                     ,rset.getInt("SALARY")
						                     ,rset.getString("EMP_NO")
						                     ,rset.getString("DEPT_TITLE")
						                     ,rset.getString("JOB_NAME")
				                             ,rset.getDate("HIRE_DATE"));
				employees.add(employee);
				                  
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return employees; 
	}
	
	
	public List<Employee> findDeptTitle(Connection conn, String deptTitle) {
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		List<Employee> employees = new ArrayList();
		
		String sql = prop.getProperty("findDeptTitle");
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, deptTitle);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Employee employee = new Employee(rset.getString("EMP_NAME"));
				employees.add(employee);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return employees;
	}
}
