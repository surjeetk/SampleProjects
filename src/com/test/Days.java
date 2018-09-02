package com.test;

public enum Days {

	MONDAY(1),TUESDAY(2),WEDNESDAY(3),THURSDAY(4),FRIDAY(5);
	
	private int dayCode;
	private Days(int code){
		dayCode=code;
	}
	
	public int getDayCode(){
		return dayCode;
	}
}
