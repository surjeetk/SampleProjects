package com.test;

import java.util.Comparator;

public class EmpId implements Comparator<Employee> {

	@Override
	public int compare(Employee emp1, Employee emp2) {
		// TODO Auto-generated method stub
		return emp1.getEmp_id().compareTo(emp2.getEmp_id());
	}

	
}
