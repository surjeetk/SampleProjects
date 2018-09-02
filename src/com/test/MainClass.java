package com.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import com.test.Employee;

import static java.lang.System.*;

public class MainClass extends ImplementClass {

	private int var;
	Integer i1,i2;
	String str1,str2;
	public void mainClassMethod(){
		int a=3,b=4;
		System.out.println(a+=b);
		a=3;
		b=4;
		System.out.println(a-=b);
		i1=i2;
		str1=str2;
		i1=10000000;
		System.out.println(i1);
		Integer i=new  Integer(-10);
		Integer j=new Integer(-10);
		int k=-10;
		System.out.println(i==k);
		System.out.println(i.equals(k));
		System.out.println(i==j);
		//	 str1.equals(str2);
		System.out.println("Inside main class method");
		int var1=10;
		class localInnerClass{
			public void innerClassMethod(){
				//	var1=var1+10;
				System.out.println("inside local inner class : var :"+var1);
			}
		}

		localInnerClass innerclass=new localInnerClass();
		innerclass.innerClassMethod();

		//Anonymous class
		TestInterface ac=new TestInterface() {

			@Override
			public void method2() {
				// TODO Auto-generated method stub
				System.out.println("inside method 2");
			}

			@Override
			public void method1() {
				// TODO Auto-generated method stub
				System.out.println("inside method 1");
			}

			@Override
			public void sayHello() {
				// TODO Auto-generated method stub
				System.out.println("inside say Hello");
			}

			public void extraMethod(){
				System.out.println("This is an extra method");
			}
		};

		ac.method1();
		ac.method2();
		ac.sayHello();
		//	ac.extraMethod();
		
		System.out.println("----------collection test---------");
		List<Integer> list= Arrays.asList(3,2,5,6,8);
		Collections.sort(list);
		list.forEach((vari)->{
			System.out.println("integer:"+vari);
			System.out.println("inside foreach");
		});
		
		
		
		
	}

	public  class memberClass{

		public void innerMethod(){
			var=10;
			System.out.println("inside member class method");
			System.out.println("outside variable:"+var);
		}



	}

	static class staticMemberClass{
		static void staticClassMethod(){
			System.out.println("inside static member class method");
		}
	}


	public static void main(String args[]){
		TestInterface test =new ImplementClass();
		test.sayHello();

		ImplementClass obj=new MainClass();

		Employee emp1= new Employee(100, "Rahul");
		Employee emp2= new Employee(100, "Rahul");
		Employee emp3= new Employee(101, "Rahul");

		System.out.println(emp1==emp2);
		//System.out.println(empl.equals(emp2));

		//obj.mainClass


		/*String str="adacbdefabg";
		char char_array[]=str.toCharArray();
		TreeSet char_set=new TreeSet();

		for (char a: char_array){
			char_set.add(a);
		}

		Iterator i =char_set.iterator();

		while(i.hasNext()){
			System.out.println(i.next());
		}*/


		/*String str1="str";
		String str2="str1";
		String str3="str";
		String str4= new String("str");
		str1=str4;

		//str3.

		System.out.println(str1.equals(str4));
		System.out.println(str1==str4);*/

		//Enum

		Days day=Days.FRIDAY;
		System.out.println(day+" : "+day.getDayCode());

		for(Days d: Days.values()){
			System.out.println(d.name()+" : "+d.ordinal()+" : "+d);
		}

		//Inner classes
		System.out.println("-------------------------------------------------");

		MainClass.memberClass mc1= new MainClass().new memberClass();
		mc1.innerMethod();

		//static member class
		MainClass.staticMemberClass smc =new MainClass.staticMemberClass();
		smc.staticClassMethod();

		//Local Inner Class

		MainClass mainclass=new MainClass();
		mainclass.mainClassMethod();

		//Wrapper classes
		int i=Integer.parseInt("2");
		int i1=3;
		new Integer(i1).toString();
		String str1="3";
		Integer i3=Integer.valueOf("3");
		int i4=i3.intValue();

		try{
			throw new IOException("throwing exception");
			//System.out.println("this won't come");
		}
		catch(RuntimeException exp){
			System.out.println("inside catch of runtime exp");
		}
		catch(IOException exp){
			//throw new Exception();
			//return;
			System.out.println("Exception thrown:"+exp.getMessage());
		}
		finally{
			System.out.println("under finally");
		}

		System.out.println("outside exception block");


		System.out.println(cube(3));
		
		printXprimeNumbers(5);
		
		//Array test
		char chararray[]={'c','b','a'};
		System.out.println(chararray);
		Arrays.sort(chararray);
		System.out.println(chararray);
		String str=Arrays.toString(chararray);
		System.out.println(str);
		int i5=1;
		 System.out.println((i+str).hashCode());
		
		 
		 ImplementClass impl=new MainClass();
		 impl.testMethod(5);
		 
		 out.print("hello");
		 
		 
		 ImplementClass impl1=new ImplementClass();
		 ImplementClass impl2=new MainClass();
		//	MainClass main1=(MainClass) impl1;
			
			MainClass main2= (MainClass) impl2;
			
			//main2.cube(5);
			
			System.out.println("1234".charAt(1)-'0');
			String strSum="1234";
			
			int sum=0,i7=0,digit=0;
			while( i7<strSum.length()){
				digit=strSum.charAt(i7)-'0';
				sum+=digit;
				i7++;
			}
			System.out.println("string sum:"+sum);
			
			
			char c='2';
			
			int k=Integer.parseInt(""+'2');
			//String str=new String(c);
			
			System.out.println(k);
			
			HashMap<Character,Integer> tempMap= new HashMap<Character,Integer>();
			tempMap.put('c',1);
			System.out.println(tempMap);
			
			String str4="hello";
			String str5="hello";
			String str6=str5;
			String str7=str5+"";
			String str8="he"+"llo";
			String str9="he"+"llo"+"";
			String str2=new String("hello");
			String str3=new String("hello");
		//	str3=str2;
			System.out.println("surjeet........");
			System.out.println("str2==str3"+(str2==str3));
			System.out.println("str6==str5"+(str6==str5));
			System.out.println("str7==str5"+(str7==str5));
			System.out.println("str8==str5"+(str8==str5));
			System.out.println("str9==str5"+(str9==str5));
			System.out.println();
			
		//	testMethod();
		
			StaticBlockTest test1=new StaticBlockTest();
			StaticBlockTest test2=new StaticBlockTest();
			
			
			
	}
	
	public static void testMethod() throws FileNotFoundException{
		throw new FileNotFoundException();
	}

	
	public static int cube(int i){
		return i*i*i;
	}

	public static void printXprimeNumbers(int X){
		
		int counter=0;
		for(int i=2;counter<X;i++){
			
			if(isPrime(i)){
				System.out.print(i+" ");
				counter++;
			}
		}
	}
	
	public static boolean isPrime(int num){
		for(int i=2;2*i<=num;i++){
			if(num%i==0)
				return false;
		}
		return true;
	}


	public static void testMethod(int i){
		System.out.println("testMethod of main class");
	}
	
	/*private static void testMethod(int i){
		System.out.println("testMethod of main class");
	}
	*/
	
	
	
	
	
}
