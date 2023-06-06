package com.example.demo.service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class CodingExamples {

	public static void main(String[] args) {
		// Java Program to count the number of words in a string using HashMap.
		HashMap<String, Integer> hashMap = new HashMap<>();
		String str = "vasu is a good girl";
		String[] wordSplit = str.split("");
		for (String word : wordSplit) {
			Integer integer = hashMap.get(word);
			if (integer == null) {
				hashMap.put(word, 1);
			} else {
				hashMap.put(word, integer + 1);
			}
		}
		System.out.println("count is:" + hashMap);

		// Java Program to swap two numbers without using the third variable.
		int a = 10;
		int b = 20;
		System.out.println("a and b values before swapping:" + a + " and " + b);
		a = a + b;
		b = a - b;
		a = a - b;
		System.out.println("a and b values after swapping:" + a + " and " + b);

		// Given a list of integers, sort all the values present in it in descending
		// order using Stream functions?
		List<Integer> list = Arrays.asList(1, 9, 2, 6, 7, 10);
		List<Integer> sortedList = list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		System.out.println("list are:" + sortedList);

		// 4. The string consists of 3 blocks of 3 characters each.
		// The returned number will have three digits, one for each block. Each digit is
		// the sum of all permissions present in the block:
		HashMap<String, Integer> hashMapCharacterAndValues = new HashMap<>();
		hashMapCharacterAndValues.put("r", 4);
		hashMapCharacterAndValues.put("w", 2);
		hashMapCharacterAndValues.put("x", 1);
		hashMapCharacterAndValues.put("-", 0);
		String decodeString = "rwxr-x-w-";
		String substring1 = decodeString.substring(0, 3);
		String substring2 = decodeString.substring(3, 6);
		String substring3 = decodeString.substring(6, 9);
		HashMap<String, Integer> hashMapList = new HashMap<>();

		for (Entry<String, Integer> entry : hashMapCharacterAndValues.entrySet()) {
			int count = 0;
			if (substring1.contains(entry.getKey())) {
				count = count + entry.getValue();
			} else {
				hashMapList.put(substring1, count);
			}

			if (entry.getKey().contains(substring2)) {
				count = count + entry.getValue();
			} else {
				hashMapList.put(substring2, count);
			}

			if (entry.getKey().contains(substring3)) {
				count = count + entry.getValue();
			} else {
				hashMapList.put(substring3, count);
			}
		}

		System.out.println(hashMapList);

		// 4. The string consists of 3 blocks of 3 characters each.
		// The returned number will have three digits, one for each block. Each digit is
		// the sum of all permissions present in the block:

		String decodeString1 = "rwxr-x-w-";
		int[] result = decodePermissions(decodeString1);
		System.out.println("Permissions are:" + result[0] + result[1] + result[2]);

	}

	public static int[] decodePermissions(String decodeString1) {
		int[] permissions = new int[3];
		int startIndex = 0;
		for (int i = 0; i < 3; i++) {
			String subString = decodeString1.substring(startIndex, startIndex + 3);
			int sum = 0;
			for (int j = 0; j < subString.length(); j++) {
				char c = subString.charAt(j);
				if (c == 'r') {
					sum += 4;
				} else if (c == 'w') {
					sum += 2;
				} else if (c == 'x') {
					sum += 1;
				}
			}
			permissions[i] = sum;
			startIndex += 3;
		}
		return permissions;
	}

}
