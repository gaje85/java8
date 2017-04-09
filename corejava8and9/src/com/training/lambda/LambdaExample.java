package com.training.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import static java.util.Comparator.comparing;
import java.util.List;

public class LambdaExample {
	
	public LambdaExample(){
		
		Runnable runn = () -> System.out.println("Run");
		Thread thread = new Thread(runn);
		thread.start();
		
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
		
		/*Collections.sort(empList,new Comparator<Employee>() {

			@Override
			public int compare(Employee emp1, Employee emp2) {
				if(emp1.getSalary() > emp2.getSalary())
					return -1;
				if(emp1.getSalary() < emp2.getSalary())
					return 1;
				return 0;
			}
			
		});
		System.out.println(empList); */
		
		//Collections.sort(empList,(employee1,employee2) -> Double.compare(employee2.getSalary(),employee1.getSalary()));
		Collections.sort(empList,comparing(Employee::getSalary));
		
		System.out.println(empList);
	}
 public static void main(String[] args) {
	LambdaExample example = new LambdaExample();
}
}
