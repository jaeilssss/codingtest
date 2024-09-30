package com.market;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        int count = 0;

        int[] arr = new int[N];
        int start = 0;
        int end = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
            if (start < arr[i]) start = arr[i];
            end += arr[i];
        }

        while (start <= end) {
            count = 0;
            int mid = (start + end) / 2;
            int sum = 0;
            for (int i = 0; i < N; i++) {
                if (sum + arr[i] > mid) {
                    count++;
                    sum = 0;
                }
                sum += arr[i];
            }

            if (sum != 0) {
                count++;
            }
//            if (count == M) {
//                answer = Integer.min(answer, mid);
//                end = mid - 1;
//            }
            if (count > M) start = mid + 1;
            else end = mid - 1;

        }
        System.out.println(start);
    }
}