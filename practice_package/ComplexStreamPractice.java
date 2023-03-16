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

	}

}
