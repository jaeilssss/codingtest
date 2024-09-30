package com.market;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        long X = scanner.nextLong();
        long Y = scanner.nextLong();
        long winRate = (Y*100)/X;
        int left = 1;
        int right = 1000000000;
        int answer = -1;
        while (left <= right) {
            int mid = (left + right) /2;

            long tempWinRate = ((Y+mid) *100) / (X+mid);

            if(tempWinRate ==winRate) {
                left = mid +1;
            }else if(tempWinRate > winRate) {
                answer = mid;
                right = mid-1;
            }

        }
        System.out.println(answer);
    }
}