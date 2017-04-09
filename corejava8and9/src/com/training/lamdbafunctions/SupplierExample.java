package com.training.lamdbafunctions;

import java.util.function.Supplier;

public class SupplierExample {
	
	public SupplierExample(){
		
		
		Supplier<Employee> supplier = () -> new Employee();
		System.out.println(supplier.get());
		
	}
	
	public static void main(String[] args) {
		SupplierExample supp = new SupplierExample();
	}

}
