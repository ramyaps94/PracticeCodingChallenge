package com.company;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Main {

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 1;
        for (int i : ar) {

            if (map.containsKey(i)) {
                count = map.get(i) + 1;
                map.replace(i, count);
            } else {
                count = 1;
                map.put(i, count);
            }

        }

        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();

        int pairs = 0;
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> value = iterator.next();
            pairs = pairs + (int) (value.getValue() / 2);
        }
        return pairs;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)  {

        System.out.println("Enter number of socks");
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];
        System.out.println("Enter the socks separated by space eg : 1 1 2 3 1 2 3 1");
        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = sockMerchant(n, ar);

        System.out.println(result);
        scanner.close();
    }
}
