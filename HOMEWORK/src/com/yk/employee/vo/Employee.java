package com.yk.employee.vo;

import java.sql.Date;
import java.util.Objects;

public class Employee {
	private int empId;
	private String empName;
	private int salary;
	private String empNo;
	private String email;
	private String Phone;
	private Date hireDate;
	
	public Employee() {
		super();
	}
	
	public Employee(String empName) {
		this.empName = empName;
	}

	
	public Employee(int empId, String empName, int salary, String empNo, String email, String phone, Date hireDate) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.salary = salary;
		this.empNo = empNo;
		this.email = email;
		Phone = phone;
		this.hireDate = hireDate;
	}


	public int getEmpId() {
		return empId;
	}


	public void setEmpId(int empId) {
		this.empId = empId;
	}


	public String getEmpName() {
		return empName;
	}


	public void setEmpName(String empName) {
		this.empName = empName;
	}


	public int getSalary() {
		return salary;
	}


	public void setSalary(int salary) {
		this.salary = salary;
	}


	public String getEmpNo() {
		return empNo;
	}


	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return Phone;
	}


	public void setPhone(String phone) {
		Phone = phone;
	}


	public Date getHireDate() {
		return hireDate;
	}


	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}


	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", salary=" + salary + ", empNo=" + empNo
				+ ", email=" + email + ", Phone=" + Phone + ", hireDate=" + hireDate + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(Phone, email, empId, empName, empNo, hireDate, salary);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(Phone, other.Phone) && Objects.equals(email, other.email) && empId == other.empId
				&& Objects.equals(empName, other.empName) && Objects.equals(empNo, other.empNo)
				&& Objects.equals(hireDate, other.hireDate) && salary == other.salary;
	}
	
}
	
	
	
	
