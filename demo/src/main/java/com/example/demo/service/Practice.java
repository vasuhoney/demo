package com.example.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.model.Employee;

public class Practice {

	public static void main(String[] args) {
		//related to int
		int num=65875;
		
		//related to string
		String str = "vasavi";
		// find non-repeated characters in str using java8
		List<Character> chars = new ArrayList<>();
		for (char ch : str.toCharArray()) {
			chars.add(ch);
		}
		chars.stream().filter(c -> Collections.frequency(chars, c) == 1).forEach(System.out::println);
		
		
		List<Integer> collect = String.valueOf(num).chars().map(c->Character.getNumericValue(c)).boxed().collect(Collectors.toList());
		int odd=collect.stream().filter(d->d%2==0).max(Comparator.naturalOrder()).orElse(-1);
		
		// find non-repeated characters in str using java
		String result = "";
		for(int i=0;i<str.length();i++) {
			char c=str.charAt(i);
			boolean isRepeated=false;
			for(int j=0;j<str.length();j++) {
				if(i!=j&&c==str.charAt(j)) {
					isRepeated=true;
					break;
				}
			}

			if(!isRepeated) {
				result+=c;
			}
		}
		
		System.out.println("non-repeated characters:"+result);
		
		
		//counting characters in a str
		Long countingCharacters = chars.stream().collect(Collectors.counting());
		System.out.println("counting characters:"+countingCharacters);
		//non-repeated counting characters in a str
		Long nonRepeatedCount = chars.stream().filter(c->Collections.frequency(chars,c)==1).collect(Collectors.counting());
		System.out.println("non repeated counting characters:"+nonRepeatedCount);
		
		//related to arrays
		int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		Arrays.stream(arr).flatMapToInt(Arrays::stream).forEach(System.out::print);
		
		//related to list
		List<String> stringList=Arrays.asList("vasu","honey","jeans","sweety","honey");
		
		//word count
		Long wordCount = stringList.stream().distinct().collect(Collectors.counting());
		System.out.println("word count:"+wordCount);
		
		//non repeated words
		stringList.stream().filter(c->Collections.frequency(stringList, c)>1).distinct().forEach(System.out::print);
		
		
		//find employeelist based on age
		List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", 25, 50000));
        employees.add(new Employee("Charlie", 30, 60000));
        employees.add(new Employee("Bob", 35, 70000));
        employees.add(new Employee("David", 40, 80000));
        employees.add(new Employee("Emily", 45, 90000));
        employees.stream().sorted(Comparator.comparing(Employee::getName).reversed()).forEach(System.out::println);

	}

}
