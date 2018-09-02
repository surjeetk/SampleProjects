package com.test;

public abstract class AbstractTest  implements TestInterface1{

 int  var=30;
	
	public  void method1(){
		System.out.println("inside method1 of abstract class");
	}
	
	public static void method3(){
		System.out.println("inside method 3 of abstract class");
	}
}
