package com.training.concurrent;
import java.util.concurrent.Callable;

public class MyCallable implements Callable<Long> {
	@Override
	public Long call() throws Exception {
		long sum = 0;
		for (long i = 0; i <= 100; i++) {
			sum += i;
		}
		//System.out.println(Thread.currentThread().getName());
		//Thread.sleep(100);
		return sum;
	}

}