package com.training.lambda;

public class FinalVar {
	
	int count = 100;
	static int item = 10;
	
	public FinalVar(){
		
		int cus = 100;
		
		Runnable runn = () -> {
			System.out.println("Run "+count++);
			System.out.println(item++);
			System.out.println(cus);
		};
		
		Thread thread = new Thread(runn);
		thread.start();
		
	/*	Runnable runOne = new Runnable() {
			
			@Override
			public void run() {
				System.out.println(cus++);
				
			}
		};*/
		
	}
	public static void main(String[] args) {
		
	}

}
