import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import com.comparators.IntegerComparator;
import com.comparators.StringComparator;
import com.comparators.StudentRollnoSorter;
import com.pojo.Student;

public class TestJavaClass {
	static int a;
	
	static {
		System.out.println("I am inside static block!");
		a=10;
	}
	
	static{
		System.out.println("I am again from static block!");
	}
	
	{
		System.out.println("I am inside initialization block!");
	}
	
	{
		System.out.println("I am again inside initialization block!");
	}
	
	TestJavaClass(){
		System.out.println("I am inside constructor!");
	}
	
	public static void testStaticMethod(){
		System.out.println("inside test static method");
	}
	
	public static void main(String args[]){
		//Hashtable table= new Hashtable();	
		
		//table.put("first", null);
		//System.out.println(table);
		
		
		System.out.println("try block testing...");
		try{
			System.out.println("inside first try block");
		}catch(NullPointerException e){
			
		}finally{
			//int i = 10/0;
			//System.out.println("inside finally block");
		}
		
		//Integer i = new Integer();
		TestJavaClass testObj = new TestJavaClass();
		
		System.out.println("Global variable:"+a);
		
		Student s1 = new Student();
		s1.setFname("Surjeet");
		s1.setRollno(101);
		Student s2 = new Student();
		s2.setFname("Raj");
		s2.setRollno(100);
		
		System.out.println("-----------------Comparator demo-----------------------");
		List<Student> students = new ArrayList<Student>();		
		students.add(s1);
		students.add(s2);
		
		System.out.println("Student list before sorting:"+students);
		Collections.sort(students,new StudentRollnoSorter());
		System.out.println("Sorted list:"+students);
		
		System.out.println("-------------------------to test Hashmap--------------------");
		Map<Student,String> studhashmap= new HashMap<Student, String>();
		studhashmap.put(s1, s1.getFname());
		studhashmap.put(s2, s2.getFname());
		
		//note content of s3 is same as s1
		Student s3= new Student();
		s3.setRollno(100);
		s3.setFname("Raj");
		
		//to put in same bucket
		System.out.println("old value of roll no. 100:"+studhashmap.put(s3, "Raj1"));
		
		System.out.println("s3 student:"+studhashmap.get(s3));
		
		System.out.println("total hashmap:");
		System.out.println(studhashmap);
		System.out.println("Key set:"+studhashmap.keySet());
		
		System.out.println("----------------------------Linked Hash Map demo------------------");
		Map<Student, String> studlinkedHM = new LinkedHashMap<Student, String>();
		
		studlinkedHM.put(s1, s1.getFname());
		studlinkedHM.put(s2, s2.getFname());
		studlinkedHM.put(null, null);
		System.out.println("Additing similar object in linked hashmap:");
		System.out.println(studlinkedHM.put(s3,"Raj1"));
		
		System.out.println("total linked hashmap");
		System.out.println(studlinkedHM);
		System.out.println("key set:"+studlinkedHM.keySet());
		
		System.out.println("-------------------------Treeemap demo---------------------------------------");
		Map<Student, String> studtreemap = new TreeMap<Student,String>(new StudentRollnoSorter());
		studtreemap.put(s1, s1.getFname());
		studtreemap.put(null, s2.getFname());
		studtreemap.put(null, "Ravi");
		System.out.println(studtreemap.put(s3, "Raj1"));
		System.out.println("total treemap:");
		System.out.println(studtreemap);
		
		
		Map<Student, String> studhashtable = new Hashtable<Student,String>();
		List<Student> studvector = new Vector<Student>();
		
		System.out.println("-----------------------Concurrent Hashmap demo-------------------");
		ConcurrentMap<Student,String> studconcurrentmap = new ConcurrentHashMap<Student, String>();
		studconcurrentmap.put(s1, s1.getFname());
		studconcurrentmap.put(s2, s2.getFname());
		studconcurrentmap.put(s3,"Raj1");
		System.out.println("total concurrent hashmap:");
		System.out.println(studconcurrentmap);
		
		
		
		System.out.println("----------------------Treeset demo----------------------------");
		Set<Student> studTreeSet =new TreeSet<Student>(new StudentRollnoSorter());
		System.out.println(studTreeSet.add(null));
		studTreeSet.add(s1);
		System.out.println(studTreeSet.add(null));
		System.out.println(studTreeSet.add(null));
		//here false means element already present in corresponding treemap as key
		System.out.println(studTreeSet.add(s3));
		System.out.println("total treeset");
		System.out.println(studTreeSet);
		
		
		System.out.println("--------------------Treeset demo with Integer and its custom Comparator----------------");
		Set<Integer> inttreeset = new TreeSet<Integer>(new IntegerComparator());
		inttreeset.add(null);
		inttreeset.add(1);
		
		System.out.println("total treeset with in build Class");
		System.out.println(inttreeset);
		
		System.out.println("--------------------Treeset demo with String and its custom Comparator----------------");
		Set<String> strtreeset = new TreeSet<String>(new StringComparator());
		strtreeset.add(null);
		strtreeset.add(null);
		strtreeset.add("SurXXX");
		strtreeset.add("sur");
		strtreeset.add("hello");
		
		System.out.println("total treeset with in build Class");
		System.out.println(strtreeset);
		
		System.out.println("----------------------hashset demo----------------------------");
		Set<Student> studhashset =new TreeSet<Student>(new StudentRollnoSorter());
		studhashset.add(s1);
		System.out.println(studhashset.add(null));
		//here false means element already present in corresponding treemap as key
		System.out.println(studhashset.add(s3));
		System.out.println("total hashset");
		System.out.println(studhashset);
		
		
		System.out.println("-------------------ConcurrentModificationException demo------------------------");
	/*	for(Student student: studTreeSet){
			System.out.println("Student:"+student);
			studTreeSet.add(s3);
		}
		
		for(Student student: studtreemap.keySet()){
			System.out.println("Student:"+student);
			studtreemap.put(s3,"Ravi");
		}*/
		
		
		/*Iterator<Student> i = Collections.unmodifiableMap(studhashmap).keySet().iterator();
	    while(i.hasNext()){
	    	studhashmap.remove(s3);
	        System.out.println(i.next());
	    }*/
		
		ConcurrentMap<Student,String> studconmap= new ConcurrentHashMap<Student,String>();
		studconmap.put(s1, s1.getFname());
		studconmap.put(s2, s2.getFname());
		studconmap.put(s3, "Raj1");
		
		Student s4 = new Student();
		//this will not print this one as it will go in same bucket so lock will already be there, so it won't pick up this. But for some other roll no. 
		//it will pick up the addition as well
		s4.setRollno(100);
		s4.setFname("Ravi");
		
		
		
	    
		 Iterator iterator = studconmap.keySet().iterator();
	        
	        while (iterator.hasNext())
	        {
	            System.out.println(studconmap.get(iterator.next()));
	            studconmap.put(s4, s4.getFname());
	        }
	        
		
	}

}
