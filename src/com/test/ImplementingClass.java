package com.test;

import java.util.ArrayList;
import java.util.HashMap;

public  class ImplementingClass extends AbstractTest {

	static int var=40;
	
	public void display(String args){
		System.out.println("inside string display");
	}
	public void display(Object args){
		System.out.println("inside object display");
	}
	public void display(Integer args){
		System.out.println("inside Integer display");
	}
	public void display(Double args){
		System.out.println("inside Double display");
	}
	public void display(int args){
		System.out.println("inside int display");
	}
	public void display(double args){
		System.out.println("inside double display");
	}
	
	public static void main(String...args) {
		// TODO Auto-generated method stub
		TestInterface1 obj=new ImplementingClass();
		System.out.println(obj.var);
		
		obj.method1();
		
		
		AbstractTest obj1=new ImplementingClass();
		System.out.println(obj1.var);
		
		obj1.method1();
		obj1.method3();
		
		Employee emp1=new Employee(100,"Surjeet");
		Employee emp2= new Employee(100,"Surjeet");
		Employee emp3=emp1;
		Employee emp4=(Employee) emp1.clone();
		if(emp1==emp3){
			System.out.println("emp1==emp3");
		}
		
		if(emp1==emp4){
			System.out.println("emp1==emp4");
		}
		
		
		if(emp1.equals(emp2)){
			System.out.println("emp1.equals(emp2)");
		}
		
		emp4.setEmp_id(101);
		System.out.println(emp1.getEmp_id());
		System.out.println(emp4.getEmp_id());
		System.out.println(emp4.getEmp_name());
		
		
		System.out.println("-------------testing exception---------------");
		int i=0;
		int var1=10,var2=0;
		while(i==0){
		try{
			
			System.out.println("before calculation");
			int result=var1/var2;
			System.out.println("after calculation");
			i=1;
			
		}
		catch(ArithmeticException e){
			System.out.println("exception occured :"+e.getMessage());
			var2=10;
		}
		
		continue;
		}
		
		
		HashMap<String,String> testMap=new HashMap<String,String>();
		
		testMap.put("Rahul", "Surjeet");
		testMap.put("Sagar", "Teacher");
		
		System.out.println("testMap get:"+testMap.get("pojo"));
		
		ArrayList<String> stringArray=new ArrayList<String>(2);
		
		stringArray.add("hello");
		stringArray.add("hi");
		stringArray.add("bye");
		stringArray.add("sayonara");
		
		System.out.println(stringArray);
		
		
		Integer i1=0;
		System.out.println(i1);
		
		//Testing method overloading
		ImplementingClass impc = new ImplementingClass();
		impc.display(new Integer(2));
		impc.display(10.5);
		//compilation error:The method display(String) is ambiguous for the type ImplementingClass
		//impc.display(null);
	}
	
	

	@Override
	public void method2() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void method1() {
		super.method1();
		System.out.println("inside method1 of implementingClass");
		
	}
	
	/*public void method3(){
		System.out.println("inside method3 of implementing class");
	}*/

}
