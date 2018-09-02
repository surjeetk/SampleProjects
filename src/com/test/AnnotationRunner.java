package com.test;

public class AnnotationRunner {

	public void method1(){
		System.out.println("inside Method1");
	}
	
	public void method2(){
		System.out.println("inside Method2");
	}
	
	@CanRun 
	public void method3(){
		System.out.println("inside Method3");
	}
	
	public void method4(){
		System.out.println("inside Method4");
	}
	@CanRun
	public void method5(){
		System.out.println("inside Method5");
	}
}
