package com.aclass.test.run;

public class ReflactionRun {

	public static void main(String[] args) {

		try {
			Class<?> c = Class.forName("com.aclass.test.run.SelectRun");
			String typeName = c.getTypeName();
			//Object tr = c.newInstance();
		//	System.out.println(tr);
			System.out.println(typeName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
