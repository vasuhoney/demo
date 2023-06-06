package com.example.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.hibernate.query.criteria.internal.expression.function.FunctionExpression;

public class Demo3 {

	public static void main(String[] args) {
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
