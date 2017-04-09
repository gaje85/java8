package com.training.concurrent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ExecutorMain extends JFrame{
	
	JButton but;
	public ExecutorMain(){
		
		but = new JButton("click");
		but.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				startThreads();
				
			}
		});
		add(but);
	}
	private static final int NTHREDS = 1000;

	public static void main(String[] args) {
		ExecutorMain main = new ExecutorMain();
		main.setSize(300, 300);
		main.setVisible(true);
	}
	public void startThreads(){
		ExecutorService executor = Executors.newFixedThreadPool(NTHREDS);
		//ExecutorService executor = Executors.newCachedThreadPool();
		long start = System.currentTimeMillis();
		for (int i = 0; i < 50000; i++) {
			Runnable worker = new MyRunnable(1000000L + i);
			//Thread thr = new Thread(worker);
			//thr.setPriority(5);
			executor.execute(worker);
		}
		// This will make the executor accept no new threads
		// and finish all existing threads in the queue
		executor.shutdown();
		// Wait until all threads are finish
		while (!executor.isTerminated()) {

		}
		long end = System.currentTimeMillis();
		System.out.println("Finished all threads "+(end-start));
	}
}