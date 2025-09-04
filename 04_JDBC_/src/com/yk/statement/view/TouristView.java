package com.yk.statement.view;

import java.util.List;
import java.util.Scanner;

import com.yk.statement.controller.TouristController;
import com.yk.statement.vo.Tourist;

public class TouristView {
	private Scanner sc = new Scanner(System.in);
	private TouristController tc = new TouristController();
	
	public void mainMenu() {
		
		System.out.println("========윤기투어에 오신 것을 환영합니다.========");
		System.out.println("여행을 떠나기 위해서 메뉴를 선택해주세요.");
		System.out.println("1. 윤기투어 예약하기");
		System.out.println("2. 윤기투어 예약조회");
		System.out.println("3. 연락처로 예약조회");
		System.out.println("4. 목적지 변경하기");
		System.out.println("5. 윤기투어 예약취소");
		System.out.println("9. 프로그램 종료");
		System.out.print("메뉴를 선택해주세요 > ");
		int menuNo = sc.nextInt();
		sc.nextLine();
		
		switch(menuNo) {
		case 1 : book(); break;
		case 2 : findAll(); break;
		case 3 : findByPhone(); break;
		case 4 : updateDestination(); break;
		case 5 : cancelTour(); break;
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
		List<Tourist> tourists = tc.findAll();
		
		if(!tourists.isEmpty()) {
			for(Tourist tourist : tourists) {
			System.out.println("전체 예약내용은 총 " + tourists.size() +"건 입니다.");
			System.out.println("예약번호 : " + tourist.getTouristId());
			System.out.println("이름 : " + tourist.getTouristName());
			System.out.println("주민등록번호 : " + tourist.getTouristNo());
			System.out.println("연락처 : " + tourist.getPhone());
			System.out.println("목적지 : " + tourist.getDestination());
			System.out.println("예약일자 : " + tourist.getEnrollDate());
			} 
		} else {
			System.out.println("윤기투어 망했다 흑흑슨");
		}
		
	 }
	
	public void findByPhone() {
		System.out.println("연락처로 예약조회하는 서비스입니다.");
		System.out.print("연락처를 입력해주세요.(010-XXXX-XXXX) > ");
		String phoneNo = sc.nextLine();
		
		Tourist tourist = tc.findByPhone(phoneNo);
		
		if(tourist != null) {
			System.out.println("예약내용은 다음과 같습니다.");
			System.out.println("예약번호 : " + tourist.getTouristId());
			System.out.println("이름 : " + tourist.getTouristName());
			System.out.println("주민등록번호 : " + tourist.getTouristNo());
			System.out.println("연락처 : " + tourist.getPhone());
			System.out.println("목적지 : " + tourist.getDestination());
			System.out.println("예약일자 : " + tourist.getEnrollDate());
		} else {
			System.out.println("예약내용이 없습니다.");
		}
	}
	
	public void updateDestination() {
		System.out.println("목적지를 변경하는 서비스입니다.");
		System.out.println("목적지 변경을 위해 먼저 예약을 조회합니다.");
		System.out.print("연락처를 입력해주세요.(010-XXXX-XXXX) > ");
		String phoneNo = sc.nextLine();
		
		Tourist tourist = tc.findByPhone(phoneNo);
		
		if(tourist != null) {
			System.out.println("예약내용은 다음과 같습니다.");
			System.out.println("예약번호 : " + tourist.getTouristId());
			System.out.println("이름 : " + tourist.getTouristName());
			System.out.println("주민등록번호 : " + tourist.getTouristNo());
			System.out.println("연락처 : " + tourist.getPhone());
			System.out.println("목적지 : " + tourist.getDestination());
			System.out.println("예약일자 : " + tourist.getEnrollDate());
		} else {
			System.out.println("예약내용이 없습니다."); return;
		}
	
		System.out.print("새로운 목적지를 입력해주세요 > ");
		String newDestination = sc.nextLine();
		int result = tc.updateDestination(phoneNo, newDestination);
		
		if(result > 0) {
			System.out.println("목적지가 변경되었습니다.");
		} else {
			System.out.println("다시 시도해주세요.");
		}
	}
	
	public void cancelTour() {
		System.out.println("예약을 취소하시면 돈 안돌려드립니다. 정말로 취소하시겠습니까???");
		System.out.print("이름을 입력해주세요 > ");
		String name = sc.nextLine();
		System.out.print("주민등록번호를 입력해주세요 > ");
		String touristNo = sc.nextLine();
		
		int result = tc.cancelTour(name, touristNo);
		
		if(result > 0) {
			System.out.println("예약이 취소됐습니다. 예약금 꿀꺽");
			
		} else {
			System.out.println("다시 시도해주세요.");
		}
	}
	
}
