package com.training.java8interfaces;

@FunctionalInterface  //SAM interface
public interface SampleInterface extends SampleInterfaceTwo{
	
	public static final float sal = 120.0f;
	public int size();
//	public int sizeTwo();
	
	public default int getCount(){
		System.out.println("inside get Count");
		return 100;
	}

	public static void getItems(){
		System.out.println("inside getItems ");
	}
}
