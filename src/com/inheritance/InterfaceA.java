package com.inheritance;

public abstract interface InterfaceA {

	default void printMessage(){
		System.out.println("This is message from interface A");
	}
	
	static void print(){
		System.out.println("Static print from interface A");
	}
	
}
