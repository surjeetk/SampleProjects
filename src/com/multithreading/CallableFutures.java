package com.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class CallableFutures {
 
	private static final int Nthreads=10;
	
	public static void main(String args[]) throws InterruptedException {
	ExecutorService executor=Executors.newFixedThreadPool(Nthreads);
	
	List<Future<Long>> list =new ArrayList<Future<Long>>();
	
		for(int i=0;i<2000;i++){
			Callable<Long> task= new MyCallable();
			Future<Long> submit=executor.submit(task);
			list.add(submit);
		}
		
		Thread.sleep(1000);
		
		long sum=0;
		System.out.println(list.size());
		executor.shutdown();
		System.out.println("--waiting to get completed---");
		try {
			executor.awaitTermination(50,TimeUnit.SECONDS);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("work got completed");
		
		for(Future<Long> future: list){
			try {
				//System.out.println("is done:"+future.isDone());
				sum+=future.get();
				//System.out.println(future.get()+" added in sum");
				
			} catch (InterruptedException | ExecutionException e) {
				
				e.printStackTrace();
			}
			
		}
		
		System.out.println("Sum:"+sum);
	
	}
}
