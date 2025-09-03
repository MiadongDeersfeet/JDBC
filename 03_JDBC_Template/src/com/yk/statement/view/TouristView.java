package com.yk.statement.view;

import java.util.Scanner;

import com.yk.statement.controller.TouristController;

public class TouristView {
	private Scanner sc = new Scanner(System.in);
	private TouristController tc = new TouristController();
	
	public void mainMenu() {
		
		System.out.println("========윤기투어에 오신 것을 환영합니다.========");
		System.out.println("여행을 떠나기 위해서 메뉴를 선택해주세요.");
		System.out.println("1. 윤기투어 예약하기");
		System.out.println("2. 윤기투어 예약조회");
		System.out.println("3. ID번호로 예약조회");
		System.out.println("4. 이름으로 예약조회");
		System.out.println("5. 목적지 변경하기");
		System.out.println("6. 윤기투어 예약취소");
		System.out.println("9. 프로그램 종료");
		System.out.print("메뉴를 선택해주세요 > ");
		int menuNo = sc.nextInt();
		sc.nextLine();
		
		switch(menuNo) {
		case 1 : book(); break;
		case 2 : findAll(); break;
		case 3 : break;
		case 4 : break;
		case 5 : break;
		case 6 : break;
		case 9 : break;
		}
	}
	
	private void book() {
		System.out.println("여행을 떠날 준비를 해볼까요~?");
		System.out.println("---------예약하기--------");
		System.out.print("이름을 입력해주세요 > ");
		String touristName = sc.nextLine();
		System.out.print("주민등록번호를 입력해주세요 > ");
		String touristNo = sc.nextLine();
		System.out.print("연락처를 입력해주세요 > ");
		String phone = sc.nextLine();
		System.out.print("목적지를 입력해주세요 > ");
		String destination = sc.nextLine();
		
		
		int result = tc.book(touristName, touristNo, phone, destination);
		
		if(result > 0) {
			System.out.println("예약에 성공했습니다.");
		} else {
			System.out.println("다시 시도해주세요.");
		}
	
	}
	
	private void findAll() {
		System.out.println("--------전체 예약내용 조회--------");
		tc.findAll();
		
	 }
	
}
