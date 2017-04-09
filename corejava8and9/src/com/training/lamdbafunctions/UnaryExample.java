package com.training.lamdbafunctions;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

import com.training.lamdbafunctions.Employee;

public class UnaryExample {
	
	public UnaryExample(){
		
		UnaryOperator<Employee> uOp = (emp) -> {
			emp.setOrgName("paypal");
			return emp;
		};
		Employee em = uOp.apply(new Employee());
		System.out.println(em);
		em.setSalary(100);
		
		BinaryOperator<Double> binOp = (empOneSal,empTwoSal) -> empOneSal + empTwoSal;
		
		Double res = binOp.apply(em.getSalary(), em.getSalary());
		System.out.println(res);
		
	}
	
	public static void main(String[] args) {
		UnaryExample supp = new UnaryExample();
	}

}
