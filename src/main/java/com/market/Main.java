package com.market;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();

        int [] arr = new int[N+1];
        for(int i = 0; i <N; i++) {
            if(i==0) arr[i] = scanner.nextInt();
            else {
                arr[i] = arr[i-1] + scanner.nextInt();
            }
        }

        for(int k = 0; k < M; k++) {
            int i = scanner.nextInt();
            int j = scanner.nextInt();

            if(i-1 != 0) {
                int answer = arr[j-1] - arr[i-2];
                System.out.println(answer);
            } else {
                System.out.println(arr[j-1]);
            }
        }
    }
}