package com.lambda;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.test.Employee;

//import java.util.function.

public class LambdaExpressionTest {

	public static void main(String args[]) {

		Predicate<String> stringLen = (s) -> s.length() > 10;
		System.out.println(stringLen.test("Hello World!"));

		// accepts a single input argument and returns no result
		Consumer<String> consumerStr = (s) -> System.out.println(s
				.toLowerCase());
		consumerStr.accept("THIS IS CAPITAL");

		// accepts one argument and produces a result
		Function<Integer, String> converter = (num) -> Integer.toString(num);
		System.out.println(converter.apply(124));

		// return type
		Supplier<String> supplier = () -> "this is supplier test";
		System.out.println(supplier.get());

		BinaryOperator<Integer> bo = (i, j) -> i + j;
		System.out.println(bo.apply(10, 20));

		UnaryOperator<String> uo = (msg) -> msg.toUpperCase();
		System.out.println(uo.apply("this is to test unary operator"));

		// using an existing functional interface BiFunction
		BiFunction<String, String, String> concat = (a, b) -> a + b;
		String sentence = concat.apply("Today is ", "a great day");
		System.out.println(sentence);

		// example of the Consumer functional interface
		Consumer<String> hello = name -> System.out.println("Hello, " + name);
		for (String name : Arrays.asList("Duke", "Mickey", "Minnie")) {
			hello.accept(name);
		}

		// example of passing one value
		GreetingFunction greeting = message -> System.out
				.println("Java Programming " + message);
		greeting.sayMessage("Rocks with lambda expressions");

		IntFunction<String> intToString = num -> Integer.toString(num);
		System.out.println("expected value 3, actual value: "
				+ intToString.apply(123).length());

		// static method reference using ::
		IntFunction<String> intToString2 = Integer::toString;
		System.out.println("expected value 4, actual value:  "
				+ intToString2.apply(4567).length());

		// lambdas made using a constructor
		Function<String, BigInteger> newBigInt = BigInteger::new;
		System.out.println("expected value: 123456789, actual value: "
				+ newBigInt.apply("123456789"));

		// example of a lambda made from an instance method
		Consumer<String> print = System.out::println;
		print.accept("Coming to you directly from a lambda...");

		// these two are the same using the static method concat
		UnaryOperator<String> greeting1 = x -> "Hello, ".concat(x);
		System.out.println(greeting1.apply("World"));

		UnaryOperator<String> makeGreeting = "Hello, "::concat;
		System.out.println(makeGreeting.apply("Peggy"));

		// collections

		List<String> names = Arrays.asList("Rahul", "Sagar", "Ankit", "Madari");
		Collections.sort(names, (a, b) -> a.compareTo(b));
		System.out.println("Sorted Names:" + names);

		List<Employee> empList = Arrays.asList(new Employee(100, "Surjeet"),
				new Employee(99, "Raj"));
		int totalId = empList.stream().collect(
				Collectors.summingInt(Employee::getEmp_id));
		System.out.println("Total ID:" + totalId);

		List<String> empNames = empList.stream().map(Employee::getEmp_name).sorted()
				.collect(Collectors.toList());
		System.out.println("Emp Names:" + empNames);

		Collections.sort(empList,
				(a, b) -> a.getEmp_name().compareTo(b.getEmp_name()));
		System.out.println("Sorted emp list:" + empList);

		// example of Stream.of with a filter
		Stream.of("apple", "pear", "banana", "cherry", "apricot")
				.filter(fruit -> {
					// System.out.println("filter: " + fruit);
					return fruit.startsWith("a"); // predicate
				})
				// if the foreach is removed, nothing will print,
				// the foreach makes it a terminal event
				.forEach(fruit -> System.out.println("Starts with A: " + fruit));

		IntStream.range(1, 4).forEach(System.out::println);

		// find the average of the numbers squared
		Arrays.stream(new int[] { 1, 2, 3, 4 }).map(n -> n * n).average()
				.ifPresent(System.out::println);

		// map doubles to ints
		Stream.of(1.5, 2.3, 3.7).mapToInt(Double::intValue)
				.forEach(System.out::println);
		
		Arrays.asList("red", "green", "blue")
        .stream()
        .sorted()
        .findFirst()
        .ifPresent(System.out::println);
		
		  //using a stream and map operation to create a list of words in caps
        List<String> collected = Stream.of("Java", " Rocks")
                .map(string -> string.toUpperCase())
                .collect(Collectors.toList());
        System.out.println(collected.toString());
        
        //demo for forEach loop
        collected.forEach(str->System.out.println(str));
        
        
        //demo for Predicate
        System.out.println("-----demo for predicate interface-------");
        Predicate<Employee> predGt100 =p->p.getEmp_id()>=100;
        Predicate<Employee> predLt100 =p->p.getEmp_id()<100;
        
        displayEmployee(empList, predGt100);
        displayEmployee(empList, predLt100);
        
	}

	private static void displayEmployee(List<Employee> empList,
			Predicate<Employee> predGt100) {
		/*empList.forEach(e ->{
        	if(predGt100.test(e))
        		System.out.println(e.getEmp_name());
        });*/
	
		empList.stream().filter(predGt100).forEach(e->System.out.println(e.getEmp_name()));
	}

	// custom functional interface
	@FunctionalInterface
	interface GreetingFunction {
		void sayMessage(String message);
	}

}
