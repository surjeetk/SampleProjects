package com.generics;

public class GenericMethodTest {

	public static <E> void printArray(E[] elements){
		for(E element: elements){
			System.out.printf("%s ",element);
		}
		System.out.println();
	}
	
	public static <T extends Comparable<T>> T maximum(T x, T y, T z) {
	      T max = x;   // assume x is initially the largest
	     
	      if(y.compareTo(max) > 0) {
	         max = y;   // y is the largest so far
	      }
	      
	      if(z.compareTo(max) > 0) {
	         max = z;   // z is the largest now                 
	      }
	      return max;   // returns the largest object   
	   }
	
	
	public static void main(String[] args) {
		Integer[] intArray = {1,2,3,10,5};
		Double[] doubleArray= {1.1,2.5,1.5,3.5};
		String[] stringArray={"hello", "surjeet"};
		Character[]  charArray={'C','c','A'};
		printArray(intArray);
		printArray(doubleArray);
		printArray(stringArray);
		printArray(charArray);
		//printArray({1.0,1.5,4.6});
		
		System.out.printf("Max of %d, %d and %d is %d\n\n", 
		         3, 4, 5, maximum( 3, 4, 5 ));

		      System.out.printf("Max of %.1f,%.1f and %.1f is %.1f\n\n",
		         6.6, 8.8, 7.7, maximum( 6.6, 8.8, 7.7 ));

		      System.out.printf("Max of %s, %s and %s is %s\n","pear",
		         "apple", "orange", maximum("pear", "apple", "orange"));
	}

}
