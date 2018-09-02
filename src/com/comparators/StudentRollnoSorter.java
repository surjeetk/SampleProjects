package com.comparators;

import java.util.Comparator;

import com.pojo.Student;

public class StudentRollnoSorter implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		// TODO Auto-generated method stub
		if(o1 == null && o2==null) return 0;
		
		if(o1 == null) return -1;
		if(o2==null) return 1;
		 if(o1.getRollno() < o2.getRollno()) return -1;
		 if((o1.getRollno() > o2.getRollno()))return 1;
		 return 0;
	}

	
}
