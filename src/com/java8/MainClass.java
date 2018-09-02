package com.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class MainClass{
	
	public static int sumWithCondition(List<Integer> numbers, Predicate<Integer> predicate) {
	    return numbers.parallelStream()
	    		.filter(predicate)
	    		.mapToInt(i -> i)
	    		.sum();
	}
	

public static int findSquareOfMaxOdd(List<Integer> numbers) {
		return numbers.stream()
				.filter(MainClass::isOdd) 		//Predicate is functional interface and
				.filter(MainClass::isGreaterThan3)	// we are using lambdas to initialize it
				.filter(MainClass::isLessThan11)	// rather than anonymous inner classes
				.max(Comparator.naturalOrder())
				.map(i -> i * i)
				.get();
	}

	public static boolean isOdd(int i) {
		return i % 2 != 0;
	}
	
	public static boolean isGreaterThan3(int i){
		return i > 3;
	}
	
	public static boolean isLessThan11(int i){
		return i < 11;
	}


	public static void main(String[] args) {
		
		List<Integer> numbers =Arrays.asList(2,20,31,9);

		//sum of all numbers
		System.out.println(sumWithCondition(numbers, n -> true));
		//sum of all even numbers
		System.out.println(sumWithCondition(numbers, i -> i%2==0));
		//sum of all numbers greater than 5
		System.out.println(sumWithCondition(numbers, i -> i>5));

		System.out.println("---------------Functional Interface test-------------");
		MyFunctionalInterface func = i -> System.out.println(i*i);
		func.test(10);
		
		System.out.println("---------------------");
		//Exception in thread "main" java.util.NoSuchElementException: No value present --> if no element found
		System.out.println(findSquareOfMaxOdd(numbers));
		
	}

	

}
