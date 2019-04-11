package com.practice;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Main {

    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, long[][] queries) {

        int[][] arr = new int[queries.length][n];
        long max = 0;
        long temp = 0;
        for(int i =0; i<queries.length;i++){
             long start = queries[i][0];
             long end = queries[i][1];
             long value = queries[i][2];

                for(int j = 0; j<n;j++) {
                    if(i>0)
                    temp = arr[i-1][j];
                  if (j >= start - 1 && j <= end - 1)
                            arr[i][j] += value + temp;
                  else
                      arr[i][j] += temp;
                //System.out.print(String.format("arr[%d][%d] = %d  ",j,i,value));
                if(arr[i][j]>max)
                    max = arr[i][j];


            }
            //System.out.println();
        }

//        for(int i =0; i<queries.length;i++){
//            int start = queries[i][0];
//            int end = queries[i][1];
//            int value = queries[i][2];
//
//            for(int j = 0; j<n;j++) {
//                if (j >= start - 1 && j <= end - 1)
//                    arr[i][j] += value;
//
//
//                System.out.print(String.format("arr[%d][%d] = %d  ",j,i,value));
//                if(arr[i][j]>max)
//                    max = arr[i][j];
//
//
//            }
//            System.out.println();
//        }

        for(int i=0;i<queries.length;i++){
            for(int j = 0;j<n;j++){
                System.out.print(arr[i][j]+"  ");
            }
            System.out.println();
        }
        return max;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {


        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        long[][] queries = new long[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                long queriesItem = Long.parseLong(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, queries);

        System.out.println(result);

        scanner.close();
    }
}
