package com.test;

public class MultithreadingDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("inside main Thread");
		Thread1 obj =new Thread1();
		Thread thread=new Thread(obj);
		Thread thread1=new Thread(obj);
		
		thread.setPriority(5);
		
		thread.setName("Name Thread 1");
		thread1.setName("Name Thread 2");
		
		thread.start();
		/*try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	//	System.out.println(Thread.currentThread());
		
		thread1.start();
		try {
			thread1.join();
		//	System.out.println(Thread.currentThread());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("End of main method");
		
	}

}
