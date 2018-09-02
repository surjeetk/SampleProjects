package com.multithreading;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

import com.test.MultithreadingDemo;

public class MutithreadingTest implements Runnable {
	
	Callable<Integer> call = new Callable<Integer>(){

		@Override
		public Integer call() throws Exception {
			// TODO Auto-generated method stub
			return null;
		}
		
	};
	
	public static Integer i;
	
	{
		System.out.println("this is inside initilalization block");
	}
	
	static   {
		System.out.println("this is inside static block");
	}
	
	public List<String> getList(){
		List<String> list=new ArrayList<String>();
		list.add("first");
		list.add("third");
		
		return Collections.unmodifiableList(list);
	}
	
	public synchronized static void testMethod1() throws InterruptedException{
		System.out.println("under testMethod1 method..going to sleep for one minute");
		
		Thread.sleep(1000*60);
		System.out.println("Test method1 awaken");
		
		
	}

	public synchronized static void testMethod12() throws InterruptedException{
		System.out.println("under testMethod2 method.going to sleep for one minute");
		
		Thread.sleep(1000*60);
		System.out.println("Test method2 awaken");
	}

	public synchronized  static void main(String[] args) throws InterruptedException {
		List<MutithreadingTest> list =new ArrayList<MutithreadingTest>();
		for(int i=0;i<1000;i++){
			MutithreadingTest test=new MutithreadingTest();
			list.add(test);
		}

		System.out.println("starting thread 1...");
		MutithreadingTest test = new MutithreadingTest();
		Thread t1 = new Thread(test);
		t1.setName("Custom Thread 1");
		t1.start();
		
		
		System.out.println("sleeping for ten seconds..");
		Thread.sleep(10*1000);
		System.out.println("calling second static method to check locking mechanism");
		//MutithreadingTest.testMethod12();
		
		Thread t2 = new Thread(test);
		t2.setName("Custom thread 2");
		t2.start();
		
		/*try {
			test.wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		//java.lang.UnsupportedOperationException
		//test.getList().add("Second");
		
		List<String> newList=new ArrayList<String>();
		System.out.println(newList.size());
		//	newList.add("1");
		//	newList.add("2");
		//Collections.copy(newList,test.getList());
		//Collections.
		newList.add("second");
		System.out.println(newList);
		
		
		System.out.println("--------------------------------------------------");
		
		synchronized("hello"){
			System.out.println("inside synchronized block");
			//Collections.
		}
		
		
	}

	@Override
	public void run() {
	 
		try {
			MutithreadingTest.testMethod1();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
