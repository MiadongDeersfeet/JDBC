package com.homework.employee.run;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertRun {

	public static void main(String[] args) {
		/*1. Employee 프로젝트를 생성한 후
		실행 클래스를 두 개 만들어서
		하나의 클래스에서는 Employee 테이블에 사용자에게 값을 입력받아서
		INSERT를 할 수 있는 기능
		하나의 클래스에서는 Employee테이블에 존재하는 모든 행을 SELECT해서 콘솔창에 출력하는 기능을 구현하시오
*/// JDBC 맛보기
		/*
		 * 1. DBeaver 실행(클라이언트 프로그램 실행)
		 * 
		 * 2. 접속하기 누름
		 * 
		 * 3. DBMS 선택
		 * 
		 * 4. ojdbc.jar --> 등록    ※ 커넥션 안돼서 선생님이 보내주신 자료
		 * 
		 * 5. IP주소, PORT번호, 사용자계정, 비밀번호 연결
		 * 
		 * 6. 새 SQL편집기
		 * 
		 * 7. INSERT문 작성 => INSERT INTO 테이블명 VALUES('값', '값', '값);
		 * 
		 * 8. SQL문을 실행
		 * 
		 * 9. UpdatedRows : 1      <= 결과가 이렇게 나온다구요.
		 * 
		 * 10. COMMIT;
		 */
		
		// 0. 변수 선언
		// 사용자로부터 값을 입력받아서 DBMS로 전달 => 테이블에 INSERT
		// 실행할 SQL문(완성된 형태로 만들어주기)
		// 1) JDBC Drive 등록 -> ojdbc.jarㄴ
		// Driver 등록은 프로그램 실행 시 딱 1회만 하면 된다.
		// 2) DB서버와의 연결(IP주소, PORT번호, 사용자이름, 비밀번호)
		// 3) 새 SQL편집기 열기
		// 4) SQL문 실행
		// Updated Rows : N 
		// Updated Rows : N
		// Updated Rows : N
		// DML(INSERT, UPDATE, DELETE) => 처리된 행의 개수
		// executeUpdate(DML문) : int (반환타입)
		// 5) 트랜잭션처리
		
		/*1. Employee 프로젝트를 생성한 후
		실행 클래스를 두 개 만들어서
		하나의 클래스에서는 Employee 테이블에 사용자에게 값을 입력받아서
		INSERT를 할 수 있는 기능
		하나의 클래스에서는 Employee테이블에 존재하는 모든 행을 SELECT해서 콘솔창에 출력하는 기능을 구현하시오
		*/
		
		Connection conn = null;
		Statement stmt = null;
		int result = 0;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("사원번호를 입력해주세요 > ");
		String empId = sc.nextLine();
		System.out.print("사원이름을 입력해주세요 > ");
		String empName = sc.nextLine();
		System.out.print("주민등록번호를 입력해주세요 > ");
		String empNo = sc.nextLine();
		System.out.print("이메일을 입력해주세요 > ");
		String email = sc.nextLine();
		System.out.print("연락처를 입력해주세요 > ");
		String phone = sc.nextLine();
		System.out.print("부서코드를 입력해주세요 > ");
		String deptCode = sc.nextLine();
		System.out.print("직급코드를 입력해주세요 > ");
		String jobCode = sc.nextLine();
		System.out.print("급여등급을 입력해주세요 > ");
		String salLevel = sc.nextLine();
		System.out.print("급여를 입력해주세요 > ");
		int salary = sc.nextInt();
		sc.nextLine();
		System.out.print("보너스율을 입력해주세요 > ");
		Double bonus = sc.nextDouble();
		sc.nextLine();
		System.out.print("관리자사번을 입력해주세요 > ");
		String managerId = sc.nextLine();
		
		String sql = "INSERT"
				+ "INTO "
				+ "VALUES"
				+ "("
				+ empId
				+ ",'" + empName + "'"
				+ "'," + empNo + "'"
				+ "'," + email + "'"
				+ "'," + phone + "'"
				+ "'," + deptCode + "'"
				+ "'," + jobCode + "'"
				+ "'," + salLevel + "'"
				+ "'," + salary
				+ ", " + bonus
				+ ", " + managerId
				+ ", SYSDATE)";
		try {	
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Driver등록 성공!");
		
		conn = DriverManager.getConnection("jdbc:oracle:thin:@115.90.212.20:10000:XE", "KYK03", "KYK031234");
		System.out.println("DB서버 접속 성공!");
		
		stmt = conn.createStatement();
		System.out.println("Statement 객체 생성!");
		
		result = stmt.executeUpdate(sql);
		System.out.println("SQL문 실행 성공!");
		
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
				
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
				
			
			
				

	/*	// 실행할 SQL문(완성된 형태로 만들어주기)
		String sql = "INSERT INTO EMPLOYEE VALUES(777, '김삼열', '961104-1234567', 'deersfeet@naver.com',
				 '010-1234-5678', 'D9', 'J1', 'S5', 3000000, 2.5, 888, SYSDATE)";"
				 		
		sql = "INSERT INTO EMPLOYEE VALUES(" + empId + ",'"+ empName + "', '"+ empNo +"', '"+ email +"', '"+ phone +'", '"+ deptCode +'",
		'"+ jobCod +"', '" + salLevel +"', " + salary + ", " + bonus + ", " + managerId + ");
    */
	
		
	}

}
