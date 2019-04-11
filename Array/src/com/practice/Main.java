package com.practice;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num-1];
        for(int i=0;i<num-1;i++)
        {
            int ele = sc.nextInt();
            arr[i] = ele;
        }
        System.out.println(Solution.findMissingNumber(num,arr));

    }

    public static class Solution{
        public static int findMissingNumber(int n, int[] arr){
            int sum = n * (n+1) /2;
            int arraySum = 0;
            for(int ele:arr){
                arraySum+=ele;
            }
            return sum-arraySum;
        }
    }
}
