package com.training.concurrent;

import static java.util.concurrent.CompletableFuture.supplyAsync;

import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureExample {
	
	UUID createId() {
		System.out.println("uuid "+Thread.currentThread());
        return UUID.randomUUID();
    }
	void store(String message) {
		System.out.println("store "+Thread.currentThread());
        System.out.println("message = " + message);
    }
	
	String convert(UUID input) {
		System.out.println("conver "+Thread.currentThread());
        return input.toString();
    }
	
	public CompletableFutureExample() {
		try{
		/*supplyAsync(this::createId).
        thenApply(this::convert).
        thenAccept(this::store).get(); */
		
		/*supplyAsync(this::createId).
        thenApply(this::convert).
        thenAccept(this::store).get();
			
			uuid Thread[ForkJoinPool.commonPool-worker-1,5,main]
					conver Thread[ForkJoinPool.commonPool-worker-1,5,main]
					store Thread[ForkJoinPool.commonPool-worker-1,5,main] */
		
		  ExecutorService es = Executors.newFixedThreadPool(2);
	        supplyAsync(this::createId,es).thenApply(this::convert).
	        thenAccept(this::store).get();
	        es.shutdown();
	        
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	
	}
	
	public static void main(String[] args) {
		CompletableFutureExample example = new CompletableFutureExample();
	}

}
