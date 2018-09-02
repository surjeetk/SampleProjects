package com.test;

public class Employee implements Comparable<Employee>, Cloneable {

	private Integer emp_id;
	private String emp_name;

	public Employee(int emp_id, String emp_name) {
		super();
		this.emp_id = emp_id;
		this.emp_name = emp_name;
	}

	public Integer getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public String toString() {
		return "Emp id:" + getEmp_id() + " Emp Name:" + getEmp_name();
	}

	public int hashCode() {
		System.out.println("inside hashcode method");
		// return (int) Math.random();
		return emp_id;
	}

	@Override
	public int compareTo(Employee emp) {
		// TODO Auto-generated method stub
		return emp_name.compareTo(emp.emp_name);

	}

	public Object clone() {
		Object clone = null;

		try {
			clone = super.clone();

		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}

		return clone;
	}

	public boolean equals(Object obj) {
		System.out.println("inside equals method of Employee");
		if (obj instanceof Employee) {
			Employee emp = (Employee) obj;

			if (emp_id == emp.getEmp_id()) {
				System.out.println("equals found");
				return true;
			}
		}
		return false;
	}

}
