package com.test;

public class Interview {
	static String str; 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hello");
		//try {
			try {
				//int a = 10 / 0;
				int a=0;
				/*while(true){
					a++;
				}*/
				
				
				
				System.out.println("lenght:"+str.length());
			} catch (NumberFormatException | NullPointerException
					| ArithmeticException e) {
				System.out.println("Exception occurred:" + e);
				//throw new RuntimeException();
			} finally {
				System.out.println("inside finally block...");
			}
		/*} catch (Exception e) {
			System.out.println("exception occurred inside try block:"+e.getMessage());
		}*/
		System.out.println("Code after try block");
	}

	public void sayHello() {
		System.out.println("kemcho..");
	}

}
