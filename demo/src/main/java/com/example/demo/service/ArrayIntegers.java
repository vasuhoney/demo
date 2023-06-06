package com.example.demo.service;

import java.util.Scanner;

public class ArrayIntegers {

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 System.out.print("Enter a input array: ");
	        int n = sc.nextInt();
	        int[] a = new int[n];
	        long sum = 0;
	        for (int i = 0; i < n; i++) {
	            a[i] = sc.nextInt();
	            sum += a[i];
	        }
	        long prod = n * sum;
	        System.out.println(prod);
	        sc.close();

	}

}
