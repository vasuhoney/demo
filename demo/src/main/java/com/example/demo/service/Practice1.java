package com.example.demo.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Practice1 {

	public static void main(String[] args) {

		String str5 = "hello world";
		int vowels = 0, consonants = 0;
		for (int i = 0; i < str5.length(); i++) {

			char ch = str5.charAt(i);
			if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
				System.out.println("vowels are:" + ch);
				vowels++;
			}
			if (ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch != 'u') {
				System.out.println("consonants are:" + ch);
				consonants++;
			}
		}
		System.out.println("vowels is:" + vowels + " and consonants is:" + consonants);

		int a = 40;
		int b = 100;
		int c = 20;
		List<Integer> list = Arrays.asList(a, b, c);
		Integer integerList = list.stream().distinct().sorted().skip(list.size() - 2).findFirst().orElse(-1);
		System.out.println("second highest value is:" + integerList);

		// sort an array in ascending order using single loop
		int arr[] = { 1, 4, 2, 3, 9, 5, 6 };
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				int temp = arr[i];
				arr[i] = arr[i + 1];
				arr[i + 1] = temp;
				i = -1;
			}
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i] + "");
		}

		String str = "vasavi";
		StringBuilder stringBuilder = new StringBuilder(str);// using string builder to reverse a string
		System.out.println(stringBuilder.reverse());

		StringBuilder stringBuilder1 = new StringBuilder();
		char[] charArray = str.toCharArray();// using tocharArray to reverse a string
		String[] split = str.split("");// using split method to reverse a string
		for (int i = charArray.length - 1; i >= 0; i--) {
			stringBuilder1.append(charArray[i]);
		}
		System.out.println(stringBuilder1);
		if (str.equals(stringBuilder1.toString())) {
			System.out.println("string is palindrome");
		} else {
			System.out.println("string is not a palindrome");
		}

		// word count and characters count
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < split.length; i++) {
			if (map.containsKey(split[i])) {
				int count = map.get(split[i]);
				map.put(split[i], count + 1);
			} else {
				map.put(split[i], 1);
			}
		}
		System.out.println(map);

		map.put("vas", 1);
		map.put("sid", 1);
		map.put("mans", 1);
		Iterator<Entry<String, Integer>> iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<String, Integer> me = iterator.next();
			System.out.println(" while  loop key is:" + me.getKey() + " value is:" + me.getValue());
		}

		for (Map.Entry<String, Integer> me : map.entrySet()) {
			System.out.println("for loop key is:" + me.getKey() + " value is:" + me.getValue());
		}

		int d = 10, e = 20;
		d = d + e;// 30
		b = d - e;// 20
		d = d - e;// 10
		System.out.println("a:" + a + ":b:" + b);

		Boolean matches = str.matches(".*[aeiou].*");
		if (Boolean.TRUE.equals(matches)) {
			System.out.println("vowels matched");
		} else {
			System.out.println("vowels not matched");
		}

		System.out.println(isPrime(12));
		System.out.println(isPrime(23));

		printFibonacciSeries(10);

		List<Integer> list1 = Arrays.asList(1, 7, 6, 2, 3, 23, 33);
		list1.parallelStream().anyMatch(x -> x % 2 != 0);
		System.out.println("even list numbers:" + list);

		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i));
		}
		for (Object obj : list) {
			System.out.print(obj);
		}
		Iterator iterator1 = list.iterator();
		while (iterator1.hasNext()) {
			System.out.print(iterator1.next());
		}

		int n = 1234562, res = 0;
		while (n != 0) {
			n = n / 10;
			res++;
		}
		System.out.println("counting numbers are:" + res);

		int D = 2, counter = 0;
		while (n != 0) {
			int digit = n % 10;
			if (digit == D)
				counter++;
			n = n / 10;
		}
		System.out.println("the digit:" + D + "occurs" + counter + "times in:" + n);

		String str3 = "Ab#$Cd";
		StringBuilder stringBuilder4 = new StringBuilder("");
		for (int i = 0; i < str3.length(); i++) {
			char ch = str3.charAt(i);
			if (ch >= 'A' && ch <= 'Z') {
				stringBuilder4.append((char) (ch + 32));
			} else if (ch >= 'a' && ch <= 'z') {
				stringBuilder4.append((char) (ch - 32));
			} else {
				stringBuilder4.append(ch);
			}
		}
		System.out.println("toggle the string:" + stringBuilder4.toString());

		String str1 = " scc vd ";
		StringBuilder stringBuilder3 = new StringBuilder();
		char[] charArray2 = str1.toCharArray();
		for (char c1 : charArray2) {
			if (!Character.isWhitespace(c1)) {
				stringBuilder3.append(c1);
			}
		}
		System.out.println(stringBuilder3);
	}

	public static boolean isPrime(int n) {

		if (n == 0 || n == 1) {
			return false;
		}
		if (n == 2) {
			return true;
		}
		for (int i = 2; i <= n / 2; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void printFibonacciSeries(int count) {
		int a = 0, b = 1, c = 1;
		for (int i = 0; i < count; i++) {
			System.out.print(a + " ");
			a = b;
			b = c;
			c = a + b;
		}
	}

}
