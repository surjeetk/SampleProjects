package com.generics;

import java.util.ArrayList;
import java.util.List;

import com.pojo.Person;
import com.pojo.Student;

public class HumanDB<T> {

	List<T> humanList = new ArrayList<T>();
	
		public void add(T human){
		
			humanList.add(human);
			
		}
		
		public void displayList(){
			System.out.println(humanList);
		}
		
		public static void main(String ar[]){
			//HumanDB<Student> studDb= new HumanDB();
			HumanDB<Person> personDB = new HumanDB();
			
			Student s1 = new Student();
			s1.setFname("Surjeet");
			s1.setRollno(100);
			
			Person p1 = new Person();
			p1.setFname("Manoj");
			p1.setLname("Kumar");
			
			//Error: com.pojo.Person cannot be cast to com.pojo.Student
			//studDb.add((Student) p1);
			System.out.println("person db list");
			personDB.add(s1);
			personDB.displayList();
			
			System.out.println("Student db list");
			//studDb.displayList();
		}
}
