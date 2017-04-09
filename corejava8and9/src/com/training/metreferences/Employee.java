package com.training.metreferences;

public class Employee {
	
	int id;
	String orgName;
	double salary;
	
	@Override
	public String toString() {
		return id +" = "+ salary +" = "+orgName;
	}
	public Employee(){
		System.out.println("empty cons called");
	}
	public Employee(int id,String orgName,double salary){
		this.id = id;
		this.orgName = orgName;
		this.salary = salary;
		System.out.println("3 arg cons called");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public Employee setSalaryTwo(double d){
		this.setSalary(d);
		return this;
	}

}
