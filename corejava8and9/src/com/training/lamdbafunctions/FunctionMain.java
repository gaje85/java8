package com.training.lamdbafunctions;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.ToDoubleBiFunction;
import java.util.function.ToDoubleFunction;

public class FunctionMain {
	
	public FunctionMain(){
		List<Employee> empList = new ArrayList<Employee>();
		Employee emp = new Employee(1,"google",22342.23);
		Employee emp1 = new Employee(2,"ebay",42342.23);
		Employee emp2 = new Employee(3,"google",12342.23);
		Employee emp3 = new Employee(4,"ebay",62342.23);
		Employee emp4 = new Employee(5,"google",25342.23);
		empList.add(emp);
		empList.add(emp1);
		empList.add(emp2);
		empList.add(emp3);
		empList.add(emp4);
		
		System.out.println(empList);
		
		Function<Employee,Employee> function = (empOne) -> {
			empOne.setOrgName(empOne.getOrgName().toUpperCase());
			return empOne;
		};
		Function<Employee,String> functionOne = (empOne) -> empOne.getOrgName();
		
		ToDoubleFunction<Employee> salaryFunction = (empOne) -> empOne.getSalary();
		
		Employee newEmp = function.apply(emp);
		System.out.println(newEmp);
		
		String orgName = functionOne.apply(emp);
		System.out.println(orgName);
		
		System.out.println(salaryFunction.applyAsDouble(emp));
		
		// Add 2 emps salary and get back the double result
		BiFunction<Employee, Employee, Double> biFun = (empOne,empTwo) -> empOne.getSalary() + empTwo.getSalary();
		
		ToDoubleBiFunction<Employee, Employee> biFunDouble = (empOne,empTwo) -> empOne.getSalary() + empTwo.getSalary();
		
		Double res = biFun.apply(emp, emp1);
		System.out.println(res);
		
		System.out.println(biFunDouble.applyAsDouble(emp, emp1));
		
		// higher order function 
		Function<Employee,Employee> toUpper = (empOne) -> {
			System.out.println("To Upper");
			empOne.setOrgName(empOne.getOrgName().toUpperCase());
			return empOne;
		};
		
		Function<Employee,Employee> toLower = (empOne) -> {
			System.out.println("To Lower ");
			empOne.setOrgName(empOne.getOrgName().toLowerCase());
			return empOne;
		};
		
		toUpper.andThen(toLower).apply(emp);
		System.out.println("-----------------------------------");
		toUpper.compose(toLower).apply(emp);
		
	}
	
	public static void main(String[] args) {
		FunctionMain main = new FunctionMain();
	}

}
