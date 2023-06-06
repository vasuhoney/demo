package com.example.demo.service;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class CodingExample {

	public static void main(String[] args) {
		String str = "abcdea";
		// remove all duplicates from a string
		char[] charString = str.toCharArray();
		LinkedHashSet<Character> linkedHashSet = new LinkedHashSet<Character>();
		for (int i = 0; i < str.length(); i++) {
			linkedHashSet.add(charString[i]);
		}

		for (char ch : linkedHashSet) {
			System.out.println("remove duplicates are:" + ch);
		}

		// how to reverse a given String
		for (int i = str.length() - 1; i >= 0; i--) {
			System.out.println("reverse a string:" + charString[i]);
		}

		// how to check if two strings are rotations of each other
		String str1 = "aedcba";
		if (!(str.length() == str1.length())) {
			System.out.println("two strings are not same:" + str + " and " + str1);
		} else {
			String str3 = "";
			for (int i = str.length() - 1; i >= 0; i--) {
				str3 = str3 + charString[i];
			}
			if (str3.equals(str1)) {
				System.out.println(
						"two strings are rotations of each other and " + "str are:" + str + " and str1 are:" + str3);
			}
		}

		// how to print the duplicate characters
		int count;
		for(int i=0;i<str.length();i++) {
			count=1;
			for(int j=i+1;j<str.length();j++) {
				if(charString[i]==charString[j]&&charString[i] !=' ') {
					count++;
					charString[j]=0;
				}
			}
			if(count>1&&charString[i]!='0') {
				System.out.println("duplicates are:"+charString[i]);
			}
		}
		
		// how to print the duplicate words
		String wordString="Vasu Honey Vasu Susmitha";
		Set<String> hashSet=new HashSet<>();
		String[] words=wordString.split("\\s+");
		Set<String> set=new HashSet<>();
		for(String word:words) {
			if(!set.add(word)) {
				hashSet.add(word);
			}
		}
		System.out.println("duplicate words are:"+hashSet);
	}

}
