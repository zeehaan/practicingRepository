package practice_package;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ComplexStreamPractice {
	public static void main(String[] args) {
		{
//		Example to get a particular type of object in a List
			List<Object> myList = Arrays.asList("lkijoh", 9, 'o', "?", null, false);
			List<Object> toList = myList.stream().filter(obj -> obj instanceof String).collect(Collectors.toList());
//			System.out.println("The list having only String " + toList);
		}

		{
//			Example to get the maximum length String in a array of String
			String[] listOfStringWithDifferrentLength = { "lkijoh", "lok", "ploki", "tg" };
			String maxLengthString = Arrays.stream(listOfStringWithDifferrentLength)
					.max(Comparator.comparing(String::length)).orElse(null);
//			System.out.println("The maximum Length String is " + maxLengthString);
		}
		{
//			An Example to check whether all number are even return true using Allmatch
			List<Integer> listOfInteger = Arrays.asList(2, 4, 6, 8, 10);
			boolean isListHasOnlyEven = listOfInteger.stream().allMatch(p -> {
				if (p % 2 == 0) {
					return true;
				} else {
					return false;
				}
			});
//			System.out.println(isListHasOnlyEven);
		}
		{
//			An Example to check whether any number are even return true using Anymatch
			List<Integer> listOfInteger = Arrays.asList(1, 4, 3, 5, 2, 0);
			boolean isListHasAnyZero = listOfInteger.stream().anyMatch(p -> {
				if (p == 0) {
					return true;
				} else {
					return false;
				}
			});
//			System.out.println(isListHasAnyZero);
		}
		{
//		get the number of occurence of a character in a String using stream 
			String str = "Hello,World!";
			Map<Character, Long> charCountMap = str.chars()
			    .mapToObj(c -> (char) c)
			    .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

			System.out.println(charCountMap);

		}
		{
//			An example to Get the sum of square numbers who is betwwen 3 to 10 and is a even number
			List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
			int sum = nums.stream()
			              .filter(n -> n > 3 && n <= 10 && n % 2 == 0)
			              .map(n -> n * n)
			              .reduce(0, Integer::sum); //  .reduce((a,b)->a+b);
			System.out.println("Sum of squares of even numbers between 3 and 10: " + sum);
		}
		{
			int[] arr={-2, 1, -3, 4, -1, 2, 1, -5, 4};
			int maxSum = arr[0];
		    int maxSumEndingHere = arr[0];

		    for (int i = 1; i < arr.length; i++) {
		        maxSumEndingHere = Math.max(arr[i], maxSumEndingHere + arr[i]);
		        maxSum = Math.max(maxSum, maxSumEndingHere);
		    }
		    System.out.println(maxSum);
		}
		{
//			Here is an example of integer value in which it give the max,min,avg,sum and secondLargest value in the entire list of integer
			List<Integer> listOfInteger = Arrays.asList(2, 4, 6, 8, 10,87,90,67,86);
			 int maxNum = listOfInteger.stream().mapToInt(Integer::intValue).max().orElseThrow();
			 int minNum = listOfInteger.stream().mapToInt(Integer::intValue).min().orElseThrow();
			 int sumNum = listOfInteger.stream().reduce(0, Integer::sum);
			 double avgNum = listOfInteger.stream().mapToInt(Integer::intValue).average().orElseThrow();
			 int secondLargest =listOfInteger.stream()
                     .sorted(Comparator.reverseOrder())
                     .distinct()
                     .skip(1)
                     .findFirst()
                     .orElse(Integer.MIN_VALUE);
			 System.out.println("The maximum value is "+maxNum+"\n"+"The minimum value is "+minNum 
					 +"\n"+"The Sum of List is "+sumNum
					 +"\n"+"The Second Largest number is "+secondLargest
					 +"\n"+"The Average number of the list is  "+avgNum);
		}
		{
//			Here is the example of a program having scanner class and a hashmap for adding and deleting an item in a flow
			Scanner scanner=new Scanner(System.in);
			Map<String,Double> entity=new HashMap<String, Double>();
			entity.put("a", 34.00);
			entity.put("ab", 32.00);
			entity.put("abc", 33.00);			
			while(true) {
				System.out.println("Enter the Value \n1->add item \n2->delete item \n3->view item \n4->exit the shop");
				   Integer enteringValue=scanner.nextInt();
				if(enteringValue == 1) {	
					System.out.println("Enter the item");
					String item=scanner.next();
					System.out.println("Enter the price");
					Double price=scanner.nextDouble();
					entity.put(item, price);
				}
				else if(enteringValue == 2) {
					System.out.println("Enter the item name to be deleted");
					String itemName=scanner.next();
					entity.remove(itemName);
					System.out.println("Successfully deleted the item");
				}
                else if(enteringValue==3) {
					System.out.println(entity);
				}
                else {
                	System.out.println("You are Exiting !!!!");
                	break;
                }
			}
        	scanner.close();
		}
		{
			//sorting based on integer
			List<Integer> listOfInteger = Arrays.asList(2, 4, 6, 8, 10,87,90,67,86);
			List<Integer> sortByNum = listOfInteger.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
			System.out.println(sortByNum);
			
		}

	}

}
