package com.test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import com.test.Employee;

import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;
//import java.util.concurrent.





public class JavaCollectionDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	ArrayList<E>
		
		
		
		
		List list =new ArrayList<String>();
		
		ArrayList<String> list1 = new ArrayList<String>();
		
		list1.add("hello");
		list1.add("surjeet");
		
	/*	System.out.println(list1.size());
		
		Object[] str_array= list1.toArray();
		
		for (Object obj: str_array){
			System.out.println(obj.toString());
		}
	
		System.out.println(	str_array.toString());*/
	
		
		list1.add("hi");
		list1.add("rahul");
		list1.add("rahul");
		//list1.add(null);
		
		System.out.println(Collections.binarySearch(list1, "rahul"));
		
		System.out.println(list1);
		System.out.println(list1.indexOf("rahul"));
		
		list1.add(0,"maria");
		
		System.out.println(list1);
		System.out.println(list1.indexOf("rahul"));
		
		
		Collections.sort(list1);
		
		System.out.println(list1);
		System.out.println(list1.indexOf("rahul"));
		
		System.out.println(Collections.binarySearch(list1, "rahul"));
		System.out.println(list1.lastIndexOf("rahul"));
		
		
		list1.clear();
		System.out.println(list1);
		
		//set
		
		Employee emp1 =new Employee(100,"Rahul");
		Employee emp2 =new Employee(50,"Surjeet");
		Employee emp3 =new Employee(102,"Ankan");
		Employee emp4 =new Employee(108,"Chetan");
		Employee emp5 =new Employee(500,"Rahul");
		Employee emp6 =new Employee(100,"Jyothi");
		Employee emp7;
		
		HashSet<Employee> hash_set =new HashSet<Employee>();
		
		hash_set.add(emp1);
		hash_set.add(emp2);
		hash_set.add(emp3);
		hash_set.add(emp4);
		hash_set.add(emp5);
		hash_set.add(emp6);
		
		System.out.println(hash_set);
		
		//Collections.sort(hash_set);
		
		LinkedHashSet<Employee> linked_hash_set =new LinkedHashSet<Employee>();
		
		linked_hash_set.add(emp1);
		linked_hash_set.add(emp2);
		linked_hash_set.add(emp3);
		linked_hash_set.add(emp4);
		linked_hash_set.add(emp5);
		linked_hash_set.add(emp6);
		
		System.out.println(linked_hash_set);
		
		System.out.println("----------------------------------TreeSet------------------------------------");
		TreeSet<Employee> treeset= new TreeSet<Employee>();
		
		treeset.add(emp1);
		treeset.add(emp2);
		treeset.add(emp3);
		treeset.add(emp4);
		treeset.add(emp5);
		treeset.add(emp6);
		//treeset.add(emp7);
		
		System.out.println(treeset);
		
		
		TreeSet<Employee> set1=(TreeSet<Employee>) treeset.descendingSet();
		System.out.println(set1);
		
		TreeSet<Employee> set2=(TreeSet<Employee>) treeset.headSet(emp5);
		
		System.out.println(set2);
		
		System.out.println("----------------------------------------------------------------------------------");
		//Map
		
		HashMap<Integer,Employee> hashmap=new HashMap<>();
		//HashMap<> hashmap1=new HashMap<Integer,Employee>();
		
		hashmap.put(1, emp1);
		hashmap.put(2, emp2);
		hashmap.put(3, emp3);
		hashmap.put(4, emp4);
	//	hashmap.put(5, emp5);
		hashmap.put(6, emp6);
		hashmap.put(6, emp4);
		hashmap.put(null, emp4);
		hashmap.put(null, emp5);
		System.out.println(hashmap);
		
		Set<Entry<Integer,Employee>> entryset=hashmap.entrySet();
	//	System.out.println(entryset);
		System.out.println("getting entry set");
		for (Entry<Integer,Employee> entry: entryset){
			
			System.out.println("key:"+entry.getKey());
			System.out.println("Value:"+entry.getValue());
		}
		System.out.println("-------------------------------------------------------------------");
		
		Set<Integer> keyset=hashmap.keySet();
		
		/*for(int i: keyset){
			System.out.println(hashmap.get(i));
		}*/
		
		System.out.println(hashmap.containsValue(emp5));
		System.out.println(hashmap.containsKey(null));
		
		TreeMap<Integer,Employee> treemap=new TreeMap<Integer,Employee>();
		
		treemap.put(10, emp1);
		treemap.put(2, emp3);
		treemap.put(3, emp3);
		System.out.println(treemap);
		
		Entry<Integer,Employee> entry=treemap.firstEntry();
		System.out.println(entry.getKey());
		System.out.println(entry.getValue());
		
		Entry<Integer,Employee> entry1=treemap.pollFirstEntry();
		System.out.println(entry1);
		System.out.println(treemap);
		
		System.out.println("-----------------------------------------------------------------------------");
		
		ConcurrentHashMap<Employee,String> chashmap=new ConcurrentHashMap<Employee,String>();
		
	}

}
