package com.kh.statement.view;

import java.util.List;
import java.util.Scanner;

import com.kh.statement.controller.MemberController;
import com.kh.statement.model.vo.Member;

/**
 * MemberView 클래스는 JDBC 실습을 위해 생성하였으며,
 * 사용자에게 입력 및 출력을 수행하는 메소드를 제공합니다.
 * 
 * @author 홍길동
 * @version 0.1
 * @date 2025-09-01
 */
public class MemberView {

	private Scanner sc = new Scanner(System.in);
	private MemberController mc = new MemberController(); 
	// 상속이 아니라 필드에 두고 쓰는 거 = 컴포지션(합성)
	
	/**
	 * 프로그램 구동 시 사용자에게 메인화면을 출력해주는 메소드입니다.
	 */
	public void mainMenu() {
		while(true) {
			System.out.println(" ---- 회원 관리 프로그램 ---- ");
			System.out.println("1. 회원 추가");
			System.out.println("2. 회원 전체 조회");
			System.out.println("3. 회원 아이디로 조회");
			System.out.println("4. 회원 이름 키워드로 조회");
			System.out.println("5. 회원 정보 변경");
			System.out.println("6. 회원 탈퇴");
			System.out.println("9. 프로그램 종료");
			System.out.print("메뉴를 선택해주세요 > ");
			int menuNo = sc.nextInt();
			sc.nextLine();
			
			switch(menuNo) {
			case 1 : save(); break;
			case 2 : findAll(); break;
			case 3 : break;
			case 4 : break;
			case 5 : break;
			case 6 : break;
			case 9 : System.out.println("프로그램을 종료합니다."); return; // 메인메소드로 리턴
			default : System.out.println("잘못된 메뉴입니다.");
			;
			}
			
			
		}
		
		
		
	}
	
	/**
	 * MEMBER 테이블에 INSERT할 값을 사용자로부터 입력받는 화면을 출력해주는 메소드
	 * 
	 * 컬럼에 INSERT할 값들을 모두 입력받은 후 입력받은 값 컨트롤러로 전달
	 */
	private void save() {
		
		System.out.println("--- 회원 추가 ---");
		System.out.print("아이디를 입력해주세요 > ");
		String userId = sc.nextLine();
		System.out.print("비밀번호를 입력해주세요 > ");
		String userPwd = sc.nextLine();
		System.out.print("성함을 입력해주세요 > ");
		String userName = sc.nextLine();
		System.out.print("이메일을 입력해주세요 > ");
		String email = sc.nextLine();

		// 일단 View에서 할 일은 끝났다. -> 컨트롤러로 요청 처리
		int result = mc.save(userId, userPwd, userName, email);
		if(result > 0) {
			System.out.println("회원 가입에 성공했습니다.");
		} else {
			System.out.println("회원 가입에 실패했습니다.");
		}
	
		
		
	}
	
	
	
	/**
	 * 회원 전체 조회 요청 시 Member 테이블에 존재하는 모든 회원의 정보를 출력하는 메소드
	 */
	private void findAll() {
		
		System.out.println("\n회원 전체 조회");
		
		// 컨트롤러야 회원들의 데이터 값 좀...
		List<Member> members = mc.findAll();
		
		// 뷰에서 2절
		System.out.println("\n조회된 총 회원수는 " + members.size() + "명 입니다.");
		if(members.isEmpty()) {
			System.out.println("조회결과가 존재하지 않습니다.");
		} else {
			
			for(Member member : members) {
				System.out.println("===============================");
				System.out.println(member.getUserNo() + "번 회원의 정보");
				System.out.println("아이디 : " + member.getUserId() + ", ");
				System.out.println("비밀번호 : " + member.getUserPwd() + ", ");
				System.out.println("이름 : " + member.getUserName() + ", ");
				System.out.println("이메일 : " + member.getEmail() + ", ");
				System.out.println("가입일 : " + member.getEnrollDate());
				System.out.println();
				
			}
			
		}
	
		
		
		
	}
	
	
	
	
}
