package com.practice;

import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] arr = new int[6][6];

        System.out.println("Enter 6 * 6 array");
        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        boolean isFirst = true;
      int maxhoursglass = 0;
        for (int i = 1; i < 5; i++) {
            for (int j = 1; j < 5; j++) {
                int sum = hourglassSum(arr,i,j);
                if(isFirst){
                    isFirst = false;
                    maxhoursglass = sum;
                }

                maxhoursglass = Math.max(sum,maxhoursglass);

            }
        }

        System.out.println(maxhoursglass);


        scanner.close();
    }

    private static int hourglassSum(int[][] arr, int i , int j) {
        int sum = arr[i-1][j-1] + arr[i-1][j] + arr[i-1][j+1]
                + arr[i][j]
                + arr[i+1][j-1] + arr[i+1][j] + arr[i+1][j+1];
        return  sum;
    }
}