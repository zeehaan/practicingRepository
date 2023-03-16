package practice_package;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SimplyStreamPractice {
	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<>();
		numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7,8,9);
		{
            //---------------/*-Stream----> Count()<*/------------------
			long getCount = numbers.stream().count();
			System.out.println("To Get count of Numbers " + getCount);
		}
		{
          //---------------/*-Stream---->.contains(number) <*/---/---------------

			boolean hasNumber = numbers.contains(98);
			System.out.println("Do this number is there " + hasNumber);
		}
		{
           //--------------/*-Stream---->.replace(arg,arg) <*/------------------
			String toString = numbers.toString();
			System.out.println("Conversion into Stream into String " + toString);
			String finalString = toString.replace("[", "(").replace("]", ")");
			System.out.println("Replace function in a string afterreplacing " + finalString);
		}
		{
          // ---------------/*-Stream---->.dintinct() <*/------------------
          // Different count
			Long dintinctCount = numbers.stream().distinct().count();
			System.out.println("The distinct vvalue of count is "+dintinctCount);
		}
		{
            //	---------------/*-Stream---->.min() <*/------------------
			 Optional<Integer> minVAlue = numbers.stream().min(Integer::compareTo);
			 System.out.println("Minimun value of the list is "+minVAlue.get());			 
		}
		{
            //	---------------/*-Stream---->.max() <*/------------------
			 Optional<Integer> maxVAlue = numbers.stream().max(Integer::compareTo);
			 System.out.println("Maximun value of the list is "+maxVAlue.get());			 
		}
		{
            //	---------------/*-Stream---->.filter(predecate->predicate.action()).findAny() <*/------------------
			 Optional<Integer> filterNum_AnyOne = numbers.stream() 
					 .filter(num -> num % 2 == 0) 
					 .findAny();
			 System.out.println("Filter value of the list for AnyOne is "+filterNum_AnyOne.get());			 
		}
		{
            //	---------------/*-Stream---->.filter(predecate->predicate.action()).findFirst() <*/------------------
			 Optional<Integer>  filterNum_FindFirst = numbers.stream() 
					 .filter(num -> num % 2 == 0) 
					 .findFirst();
			 System.out.println("Filter value of the list for FindFirst is "+filterNum_FindFirst.get());			 
		}
		{
            //	---------------/*-Stream---->.filter(predecate->predicate.action()) AllList <*/------------------
			  List<Integer> filterNum_AllList = numbers.stream() 
					 .filter(num -> num % 2 == 0) 
					 .collect(Collectors.toList());
			 System.out.println("Filter value of the list for AllList is  "+filterNum_AllList);	
		}
			 {//	---------------/*-Stream---->.filter(predecate->predicate.action()) sum of value with a condition<*/------------------
					int sum = 0;
					sum = numbers.stream()
					             .filter(n -> n % 2 == 0) // filtering condition, even numbers
					             .mapToInt(Integer::intValue) // converting stream of Integer to stream of int
					             .sum(); 
					 System.out.println("Combining two operations filter and for each and adding that to a varaible " +sum);
				}
			 {
//					Example for filter for person gheter than of age 30 years
//				 List<Person> filteredPeople = people.stream()
//	                     .filter(person -> person.getAge() >= 30)
//	                     .collect(Collectors.toList()); 
			 }				
		{
//			A simply example to perform certain operation on each element in a list using ForEach() in stream()
			 numbers.stream().forEach(num->{
			   	 num= num*3;
				 System.out.print(num+" ");
				 });
		}

		{
//			This is an example of adding a array into different arrays with a condition only when it is satisfied
			List<Integer> oddNumbers = new ArrayList<>();
			List<Integer> evenNumbers = new ArrayList<>();

			numbers.forEach(number -> {
			    if (number % 2 == 0) {
			        evenNumbers.add(number);
			    } else {
			        oddNumbers.add(number);
			    }
			});

			System.out.println("Odd numbers: " + oddNumbers);
			System.out.println("Even numbers: " + evenNumbers);
		}

	}

}
