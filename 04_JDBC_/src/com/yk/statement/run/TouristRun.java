package com.yk.statement.run;

import com.kh.common.JDBCTemplate;
import com.yk.statement.view.TouristView;

public class TouristRun {

	public static void main(String[] args) {
		JDBCTemplate.registDriver();
		TouristView tv = new TouristView();
		tv.mainMenu();

	}

}
