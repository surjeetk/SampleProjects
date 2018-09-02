package com.inheritance;


import java.util.Arrays;
import java.util.List;

public class MainClass{

	public static void main(String[] args) {
		
	
		System.out.println("-----------------------");
		A a = new A();
		a.calculate(10,20);
		
		System.out.println("-----------------------");
		A ab = new B();
		ab.calculate(10, 20);
		
		
		System.out.println("-----------------------");
		B b = new B(10,20);
		b.calculate(10, 20);
		
		System.out.println("-----------------------");
		System.out.println("Static overridden variable:"+ab.c);
		//B.testMethodOfA();
		
		System.out.println("-----------------------");
		a=b;
		b=(B)a;
		//get java.lang.ClassCastException: com.inheritance.A cannot be cast to com.inheritance.B
		b.testMethod(); 
		
		b.calculate(10, 10);
		
		System.out.println("-------------Java 8 Interface-----------");
		InterfaceA.print();
		b.printMessage();
		b.printMessage2();
	
		C c = new C();
		c.testMethodOfA();
		b.testMethodOfA();
		
		String a1[] = new String[]{"abc","klm","xyz","pqr"};
		List<String> list = Arrays.asList(a1);
		list.add("fg");
	}

}
