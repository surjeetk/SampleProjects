package com.test;

public class Thread1 implements Runnable {

	@Override
	synchronized public void run() {
		// TODO Auto-generated method stub
		System.out.println("Now Running :"+Thread.currentThread());
		
		for (int i=1;i<10;i++){
			System.out.println(Thread.currentThread()+" "+i);
			if(i==5){
			Thread.yield();
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		}
	}

}
