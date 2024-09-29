package com.market;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int H = scanner.nextInt();

        int [] seoksoon = new int[H+1];
        int [] jongyuseok = new int[H+1];

        for(int i = 0; i<N; i++) {
            int h = scanner.nextInt();
            if(i%2==1) {
                jongyuseok[h]++;
            } else {
                seoksoon[h]++;
            }
        }

        for(int i = H-1; i > 0; i--) {
            seoksoon[i] += seoksoon[i+1];
        }

        for(int i = H-1; i > 0; i--) {
            jongyuseok[i] += jongyuseok[i+1];
        }

        int minValue = Integer.MAX_VALUE;
        int count = 0;
        for(int i = 1; i < H+1; i++) {
            int sum = seoksoon[i] + jongyuseok[H-i+1];

            if(sum < minValue) {
                minValue = sum;
                count = 1;
            } else if(sum == minValue){
                count++;
            }
        }

        System.out.println(minValue + " " + count);
    }
}