package com.training.metreferences;

import static java.util.Comparator.comparing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.DoubleFunction;
import java.util.function.Supplier;

public class MetReferencesExample {
	
	public MetReferencesExample(){
		
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
		//MetReferencesExample ex = new MetReferencesExample();
		Collections.sort(empList,comparing(Employee::getOrgName));
		System.out.println(empList);
		BinaryOperator<Double> binOP = (Double oneEmp, Double twoEmp) -> oneEmp + twoEmp;
		BinaryOperator<Double> binOPMet = this::add;
		
		Double res = binOP.apply(emp1.getSalary(), emp2.getSalary());
		
		System.out.println(res);
		
		
		DoubleFunction<Double> doubleFunction = (num) -> Math.sqrt(num);
		DoubleFunction<Double> doubleFunctionMet = Math::sqrt;
		DoubleFunction<Double> doubleFunctionMetSub = MetReferencesExample::sub;
		Double resSqrt = doubleFunctionMet.apply(2);
		System.out.println(resSqrt);
		
		BiFunction<Employee, Double, Employee> biFun = (empBiFun,sal) -> {
			empBiFun.setSalary(sal);
			return empBiFun;
		};
		
		BiFunction<Employee, Double, Employee> biFunTwo = Employee::setSalaryTwo;
		BiFunction<Employee, Double, Employee> biFunLam = (empLam,sal) -> empLam.setSalaryTwo(sal);
		
		Supplier<Employee> supplier = Employee::new;
		supplier.get();
		
		// lambda for tri function 
		
		TriFunction triFunction = (id,orgName,salary) -> new Employee(id, orgName, salary);
		
		TriFunction triFunctionOne = Employee::new;
		
		triFunctionOne.create(6, "paypal", 33000.9);
		
	}
	
/*	public Employee ClassCallingInstance(Employee emp,double sal){
		emp.setSalary(sal);
		return emp;
	}*/
	
	
	public static Double sub(double d){
		return d - 10;
	}
	
	public Double add(Double one,Double two){
		return one + two;
	}
 public static void main(String[] args) {
	 MetReferencesExample example = new MetReferencesExample();
}
}
