package com.inheritance;

public class A {
	private int a;
	private int b;
	public static int c =10;
	
	public A(){
		System.out.println("under default constructor of A");
	}
	
	A(int a, int b){
		System.out.println("under paramerterized constructor of A");
		this.a=a;
		this.b=b;
	}
	
	protected   int calculate(int a ,int b) throws RuntimeException{
		System.out.println("under first calculate");
		return a*b;
	}
	
	static final int calculate(Integer a ,int b){
		System.out.println("under second calculate");
		return a*b;
	}
	
	protected  void testMethodOfA(){
		System.out.println("Inside test method of A class");
	}
	
	
	public static void main(String args[]){
		A a = new A();
		
	}

}
