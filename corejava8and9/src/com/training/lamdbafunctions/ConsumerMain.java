package com.training.lamdbafunctions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerMain {

	
	public ConsumerMain(){
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
		
		Consumer<Employee> consEmp = (empOne) -> System.out.println("One "+empOne);
		Consumer<Employee> consEmpTwo = (empOne) -> System.out.println("Two "+empOne);
		empList.forEach(consEmp.andThen(consEmpTwo));
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("one", "1");
		map.put("two", "2");
		map.put("three", "3");
		
		BiConsumer<String, String> biCons = (name,value) -> System.out.println(name +" = "+value);
		map.forEach(biCons);
		
		
	}
	public static void main(String[] args) {
		ConsumerMain main = new ConsumerMain();
	}
	
}
