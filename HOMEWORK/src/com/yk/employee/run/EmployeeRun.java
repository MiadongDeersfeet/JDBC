package com.yk.employee.run;

import com.yk.employee.common.JDBCTemplate;
import com.yk.employee.view.EmployeeView;

public class EmployeeRun {

	public static void main(String[] args) {
		JDBCTemplate.registDriver();
		EmployeeView ev = new EmployeeView();
		ev.mainMenu();
	}

}
