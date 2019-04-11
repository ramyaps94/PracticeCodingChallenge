package com.practice;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            int result = minimumBribes(q);
            if(result < 0)
                System.out.println("too chaotic");
            else
                System.out.println(result);
        }

        scanner.close();
    }

    private static int minimumBribes(int[] q) {
        int bribe = 0;
        boolean finalState = false;
        for (int i = 0; i < q.length; i++) {
            if (q[i] > i + 1 + 2) {
                return -1;
            }

        }
        while (!finalState) {
            int j;
            for (j = 0; j < q.length; j++) {
                if (j + 1 == q[j]) ;
                else
                    break;
            }
            if (j == q.length)
                finalState = true;

            for (int k = 0; k < q.length - 1; k++) {
                if (q[k] > q[k + 1]) {
                    if(k < q.length-2) {
                        if (q[k + 1] > q[k + 2]) {
                            bribe = bribe + 1;

                            int temp = q[k + 1];
                            q[k + 1] = q[k + 2];
                            q[k + 2] = temp;
                        }
                    }
                    int newtemp = q[k];
                    q[k] = q[k + 1];
                    q[k + 1] = newtemp;
                    bribe = bribe + 1;

                }
            }
           // System.out.println("out of loop");


        }
        return bribe;
    }
    }

