package com.test;


 public class ImplementClass implements TestInterface{
	public void sayHello(){
		System.out.println("Hello beta !!!!");
		System.out.println(TestInterface.var1);
	}

	@Override
	public void method1() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void method2() {
		// TODO Auto-generated method stub
		
	}
	
	public static void testMethod(int i){
		System.out.println("testMethod of implement class");
	}

}
