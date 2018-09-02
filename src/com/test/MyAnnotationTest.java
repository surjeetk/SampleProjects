package com.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyAnnotationTest {

	public static void main(String[] args) {
		
		AnnotationRunner runner= new AnnotationRunner();
		Method[] methods=runner.getClass().getMethods();
		
		for (Method method: methods){
			CanRun annos =method.getAnnotation(CanRun.class);
			 if(annos!=null){
				 try {
					method.invoke(runner);
				} catch (IllegalAccessException | IllegalArgumentException
						| InvocationTargetException e) {
					e.printStackTrace();
				}
			 }
		}

	}

}
