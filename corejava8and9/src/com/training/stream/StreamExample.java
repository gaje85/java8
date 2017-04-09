package com.training.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamExample {
	
	public StreamExample(){
		
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
		
		// Filter google employees and find sum of its salary 
		
		double sum = empList.stream().filter((empFilter) -> empFilter.getOrgName().equals("google"))
		                 .peek((empcons) -> System.out.println(empcons))
						 .mapToDouble((empMap) -> empMap.getSalary())
						 .sum();
		System.out.println(sum);
		
		List<Employee> list = empList.stream().filter((empFilter) -> empFilter.getOrgName().equals("google"))
						.collect(Collectors.toList());
		System.out.println(list);
		
		Long res = empList.stream().filter((empFilter) -> empFilter.getOrgName().equals("google"))
				.collect(Collectors.counting());
			System.out.println(res);
						 
			Map<String,List<Employee>> map = empList.stream().collect(Collectors.groupingBy(Employee::getOrgName));
		    System.out.println(map);
		    
		    Map<Boolean,List<Employee>> mappar = empList.stream().collect(Collectors.partitioningBy((empFilter) -> empFilter.getOrgName().equals("google")));
		    System.out.println(mappar);
		    
		    
		    
	}
	public static void main(String[] args) {
		StreamExample example  = new StreamExample();
	}
}