package com.example.demo.service;

import java.util.Scanner;

public class PalindromeScore {
	//String is CwaFMIWFiTTfSQQmCRPhTThKJAbOWPyoOP
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = input.nextLine();
        input.close();
        char[] chars = str.toCharArray();
        int score = 0;
        int len = chars.length;
        for (int i = 0; i < len - 3; i++) {
            if (isPalindrome(chars, i, i + 3)) {
                score += 5;
            }
        }
        for (int i = 0; i < len - 4; i++) {
            if (isPalindrome(chars, i, i + 4)) {
                score += 10;
            }
        }
        System.out.println("Score of " + str + " is: " + score);
    }

    private static boolean isPalindrome(char[] chars, int start, int end) {
        while (start < end) {
            if (chars[start] != chars[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}