package com.example.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Demo1 {
	public static void main(String[] args) {

		// find third largest number in list
		List<Integer> integers = Arrays.asList(5, 6, 3, 1, 8);
		Collections.sort(integers);
		System.out.println(integers);
		Integer thirdLargest = integers.get(integers.size() - 3);
		System.out.println(thirdLargest);

		// find third largest number in list using java8
		Optional<Integer> findThirdLargest = integers.stream().sorted(Comparator.reverseOrder()).skip(2).findFirst();
		System.out.println(findThirdLargest.get());

		// 2d array
		int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		Arrays.stream(arr).flatMapToInt(Arrays::stream).forEach(System.out::print);

		// print duplicates count from list using java8
		String[] arrayList = { "aa", "bb", "cc", "aa" };
		List<String> stringList = Arrays.asList(arrayList);
		Map<String, Long> values = stringList.stream()
				.collect(Collectors.groupingBy(value -> value, Collectors.counting()));
		System.out.println("count using java8:" + values);

		// print duplicates count from list using java
		Map<String, Integer> mapValue = new HashMap<>();
		for (String value : stringList) {
			if (mapValue.containsKey(value)) {
				mapValue.put(value, mapValue.get(value) + 1);
			} else {
				mapValue.put(value, 1);
			}
		}
		System.out.println("count using java:" + mapValue);

		// remove duplicates from list
		List<String> removeDuplicates = stringList.stream().distinct().collect(Collectors.toList());
		System.out.println("remove duplicates from list:" + removeDuplicates);

		// print only duplicates
		Set<String> items = new HashSet<>();
		List<String> collect = stringList.stream().filter(n -> !items.add(n)).collect(Collectors.toList());
		System.out.println("duplicate values are:" + collect);

		// orrrrrrr
		List<String> collect2 = stringList.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
				.filter(n -> n.getValue() > 1).map(Map.Entry::getKey).collect(Collectors.toList());
		System.out.println("duplicates are:" + collect2);

		// find count from list
		Long mapValues = stringList.stream().collect(Collectors.counting());
		System.out.println(mapValues);

		// print non-repeated characters from string
		String str = "vasavi";
		List<Character> chars = new ArrayList<>();
		for (char c : str.toCharArray()) {
			chars.add(c);
		}
		chars.stream().filter(c -> Collections.frequency(chars, c) == 1).forEach(System.out::print);
	}

}
