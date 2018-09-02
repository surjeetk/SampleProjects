package com.junit;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class MyTestRunner {

	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(MyClassTest.class);
		
		System.out.println("Total ignored test cases:"+result.getIgnoreCount());
		System.out.println("List of failures:");
		for(Failure failure:result.getFailures()){
			System.out.println(failure.toString());
		}
		System.out.println("Count of run:"+result.getRunCount());
		
		System.out.println("------------------Checking Parameterized test -----------------");
		Result result1 = JUnitCore.runClasses(ParameterizedTestFields.class);
		
		System.out.println("Total ignored test cases:"+result1.getIgnoreCount());
		System.out.println("List of failures:");
		for(Failure failure:result1.getFailures()){
			System.out.println(failure.toString());
		}
		System.out.println("Count of run:"+result1.getRunCount());
			
	}

}
