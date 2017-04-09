package com.training.optional;

import java.util.Optional;

import com.training.lambda.Employee;

public class OptionalExample {

	public OptionalExample(){
		// null check 
		Employee emp = new Employee(10,"paypal",12000);
		
		if(emp != null){
			emp.getOrgName();
		}
		Employee emp1 = null;
				
		Optional<Employee> op = Optional.ofNullable(emp1);
		
		Employee empOne = op.orElseGet(() -> new Employee());
		
		if(op.isPresent()){
			System.out.println("true");
		}else{
			System.out.println("false");
		}
		
	}
	
	public static void main(String[] args) {
		OptionalExample ex = new OptionalExample();
	}
}
