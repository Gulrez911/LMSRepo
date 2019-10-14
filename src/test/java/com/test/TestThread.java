package com.test;

public class TestThread {
	
	public static void main(String args[]) throws InterruptedException{
		Debiter action1 = new Debiter();
		Creditor action2 = new  Creditor();
		
		Thread t1 = new Thread(action1);
		Thread t2 = new Thread(action2);
		
		t1.start();
		t2.start();	
		t1.join();
		t2.join();
		
	}

}

class Creditor implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("500 recieved");
	}
	
	
}

class Debiter implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("500 sent");
	}
	
	
}
