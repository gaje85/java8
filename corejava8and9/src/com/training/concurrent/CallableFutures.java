package com.training.concurrent;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableFutures {
	private static final int NTHREDS = 100;

	public static void main(String[] args) throws Exception {

		ExecutorService executor = Executors.newFixedThreadPool(NTHREDS);
		
		List<Future<Long>> list = new ArrayList<Future<Long>>();
		for (int i = 0; i < 20000; i++) {
			Callable<Long> worker = new MyCallable();
			Future<Long> submit = executor.submit(worker);
			//long l = submit.get();
			//System.out.println("The l is == "+l);
			list.add(submit);
		}
		long sum = 0;
		System.out.println(list.size());
		executor.shutdown();
		while (!executor.isTerminated()) {

		}
		// Now retrieve the result
		for (Future<Long> future : list) {
			try {
				sum += future.get();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
		System.out.println(sum);
		
		
	}
}