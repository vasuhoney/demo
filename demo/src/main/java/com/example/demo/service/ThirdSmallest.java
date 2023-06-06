
package com.example.demo.service;

import java.util.Scanner;
public class ThirdSmallest {
    public static void main(String[] args) {
    	
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the input array:");
        int n = sc.nextInt(); // array length
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int thirdSmallest = findThirdSmallest(arr);
        System.out.println(thirdSmallest);
    }

    public static int findThirdSmallest(int[] arr) {
        int n = arr.length;
        int firstSmallest = Integer.MAX_VALUE, secondSmallest = Integer.MAX_VALUE,
                thirdSmallest = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (arr[i] < firstSmallest) {
                thirdSmallest = secondSmallest;
                secondSmallest = firstSmallest;
                firstSmallest = arr[i];
            } else if (arr[i] < secondSmallest) {
                thirdSmallest = secondSmallest;
                secondSmallest = arr[i];
            } else if (arr[i] < thirdSmallest) {
                thirdSmallest = arr[i];
            }
        }
        return thirdSmallest;
    }
}
