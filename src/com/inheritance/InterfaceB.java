package com.inheritance;


public interface InterfaceB {
	
	default void printMessage(){
		System.out.println("This is message from interface B");
	}
	
	default void printMessage2(){
		System.out.println("This is second message from interface B");
	}
	
	static void print(){
		System.out.println("Static print from interface B");
	}
	
	

}
