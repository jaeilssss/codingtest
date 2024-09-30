package com.market;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();

        int [] ground = new int[N+2];
        int [] groundS = new int[N+2];

        for(int i = 1 ; i<N+1; i++) {
            ground[i] = scanner.nextInt();
        }

        for(int i = 0; i<M; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            int k = scanner.nextInt();
            
            groundS[start] += k;
            groundS[end+1] -= k;
        }
        
        for(int  i = 1; i<N+1; i++) {
            groundS[i] = groundS[i-1] + groundS[i];
        }

        for(int i = 1; i<N+1; i++) {
            ground[i] += groundS[i];
        }
        for(int  i = 1; i <N+1; i++) {
            System.out.print(ground[i]+" ");
        }

    }
}