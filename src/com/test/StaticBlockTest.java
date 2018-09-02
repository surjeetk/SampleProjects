package com.test;

public class StaticBlockTest {
	
	StaticBlockTest(){
		System.out.println("a");
	}
	
	static{
		System.out.println("b");
	}
	
	{
		System.out.println("c");
	}

}
