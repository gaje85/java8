package com.training.lamdbafunctions;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.IntPredicate;
import java.util.function.Predicate;



public class PredicateMain {

	public PredicateMain(){
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
		// emp in google
		printEmp(empList, (empOne) -> empOne.getOrgName().equals("google"));
		// emp salary > 40000
		printEmp(empList, (empOne) -> empOne.getSalary() > 40000.0);
		
		// get empid 3
		printEmp(empList, (empOne) -> empOne.getId() == 3);
		
		// getEmp in google and salary greater than 20000
		Predicate<Employee> predicateOne = (empOne) -> empOne.getOrgName().equals("google");
		Predicate<Employee> predicateTwo = (empOne) -> empOne.getSalary() > 20000.0;
		printEmp(empList, predicateOne.and(predicateTwo));
		
		// for IntPredicate
		printEmpInt(empList,(id) -> id == 3 );
		
		Integer in = 20;
		int k = in;
	}
	
	public void printEmp(List<Employee> empList,Predicate<Employee> predicate){
		/*for (Employee employee : empList) {
			if(predicate.test(employee)){
				System.out.println(employee);
			}
		}*/
		// the above code is commented to explain the consumer interface 
		Consumer<Employee> consEmp = (empOne) ->{
			if(predicate.test(empOne)){
				System.out.println(empOne);
			}
		};
		empList.forEach(consEmp);
		System.out.println("----------------------------------");
	}
	
	public void printEmpInt(List<Employee> empList,IntPredicate predicate){
		for (Employee employee : empList) {
			if(predicate.test(employee.getId())){
				System.out.println(employee);
			}
		}
		System.out.println("----------------------------------");
	}
	public static void main(String[] args) {
		PredicateMain main = new PredicateMain();
	}
}
