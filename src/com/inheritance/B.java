package com.inheritance;

public class B extends A implements InterfaceA,InterfaceB, Cloneable{
	public static int c=50;
	
	
	
	public void printMessage(){
		System.out.println("This is message from class B");
	}
	
	B(){
		System.out.println("inside default constructor of B");
	}
	
	B(int a, int b){
		System.out.println("inside p. const of B");
	}

	public  final int  calculate(int a, int b) throws NullPointerException{
		System.out.println("Inside calculate method of class B");
		return a*b;
	}
	
	public void testMethod(){
		System.out.println("inside test method");
	}
}
