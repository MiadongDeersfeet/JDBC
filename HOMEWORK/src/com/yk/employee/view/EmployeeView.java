package com.yk.employee.view;

import java.util.List;
import java.util.Scanner;

import com.yk.employee.controller.EmployeeController;
import com.yk.employee.vo.Employee;

public class EmployeeView {
	private Scanner sc = new Scanner(System.in);
	private EmployeeController ec = new EmployeeController();

	
	public void mainMenu() {
		
		System.out.println("회사 운영을 위한 프로그램입니다.");
		System.out.println("1. 회원 전체 조회");
		System.out.println("2. 부서별 사원 조회");
		System.out.println("3. 직급별 사원 조회");
		System.out.println("4. 사원 상세 조회");
		System.out.println("5. 우리회사 탑5 조회");
		System.out.println("6. 우리회사 막냉이들 조회");
		System.out.println("7. 사원 추가하기");
		System.out.println("8. 사원정보 수정하기");
		System.out.println("9. 퇴사하기");
		System.out.print("메뉴를 선택해주세요 > ");
		int menuNo = sc.nextInt();
		sc.nextLine();
		
		switch(menuNo) {
		case 1 : findAll(); break;
		case 2 : findDeptTitle(); break;
		case 3 : break;
		case 4 : break;
		case 5 : break;
		case 6 : break;
		case 7 : break;
		case 8 : break;
		case 9 : break;
		default : System.out.println("없는 메뉴입니다."); break;
		}
		
	}
	
		public void findAll() {
			System.out.println("사원 전체를 조회하는 서비스입니다.");
			List<Employee> employees = ec.findAll();
			if(!employees.isEmpty()) {
			System.out.println("조회하신 사원의 수는 " + employees.size() + "명 입니다.");
			for(Employee employee : employees) {
			System.out.println("사원번호 : " + employee.getEmpId());
			System.out.println("사원이름 : " + employee.getEmpName());
			System.out.println("급여 : " + employee.getSalary());
			System.out.println("주민번호 : " + employee.getEmpNo());
			System.out.println("이메일 : " + employee.getEmail());
			System.out.println("연락처 : " + employee.getPhone());
			System.out.println("입사일 : " + employee.getHireDate());
			
			}
			}
		}
		
			
		public void findDeptTitle() {
			System.out.print("부서명을 입력해주세요 > ");
			String deptTitle = sc.nextLine();
			
			List<Employee> employees = ec.findDeptTitle(deptTitle);
			if(!employees.isEmpty()) {
				System.out.println("조회된 사원의 수는 " + employees.size() + "명 입니다.");
			
			for(Employee employee : employees) {
				System.out.println("사원이름 : " + employee.getEmpName());
			}
			}
	}
	
	
}
