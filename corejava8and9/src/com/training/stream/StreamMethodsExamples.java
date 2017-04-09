package com.training.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamMethodsExamples {

	public StreamMethodsExamples(){
		List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
		numbers.stream()
		       .filter(i -> i % 2 == 0)
		       .distinct()
		       .forEach(System.out::println);
		
		 List<Dish> dishes = Dish.menu.stream()
                 .filter(d -> d.getCalories() > 300)
                 .limit(3)
                 .collect(Collectors.toList());
		 System.out.println(dishes);
		 
		 List<Dish> dishesSkip = Dish.menu.stream()
                 .filter(d -> d.getCalories() > 300)
                 .skip(2)
                 .collect(Collectors.toList());
		 System.out.println(dishesSkip);
		 
		 List<Integer> dishNameLengths = Dish.menu.stream()
                 .map(Dish::getName)
                 .map(String::length)
                 .collect(Collectors.toList());
		 
		 System.out.println(dishNameLengths);
		 
		 // will flattend the structure
		//[[1,2,3] , [3,4,5]] ==   [1,2,3,3,4,5]
		 List<Integer> evens = Arrays.asList(2, 4, 6); 
	      List<Integer> odds = Arrays.asList(3, 5, 7);
	      List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11); 
	      List<Integer> number = Stream.of(evens, odds, primes) // stream of list
	    		  .flatMap(listfm -> listfm.stream()) // 3 stream<integer>
	    		   .collect(Collectors.toList());
	     System.out.println("flattend list: " + number);

	     
	     boolean isHealthy = Dish.menu.stream()
                 .allMatch(d -> d.getCalories() < 1000);

	     boolean isHealthyOne = Dish.menu.stream()
                 .noneMatch(d -> d.getCalories() >= 1000);
	     Optional<Dish> dish =
	    		 Dish.menu.stream()
	    		      .filter(Dish::isVegetarian)
	    		      .findAny();
	     
	     List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
	     Optional<Integer> firstSquareDivisibleByThree =
	       someNumbers.stream()
	                  .map(x -> x * x)
	                  .filter(x -> x % 3 == 0)
	                  .findFirst(); // 9
	     
	     IntStream evenNumbers = IntStream.rangeClosed(1, 100)
	    		 .filter(n -> n % 2 == 0);
	     
	     Stream<String> stream = Stream.of("Java 8 ", "Lambdas ", "example", "code");
	     stream.map(String::toUpperCase).forEach(System.out::println);
	     
	     
	     Stream.iterate(0, n -> n + 2)
	      .limit(100)
	      .forEach(System.out::println);
	     
	     
	     

	     
	}
	
	public static void main(String[] args) {
		StreamMethodsExamples examples  = new StreamMethodsExamples();
	}
}
