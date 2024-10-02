package com.market;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main2 {

   static int A;
    static int C;
    static int G;
    static int T;
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        int S = scanner.nextInt();
        int P = scanner.nextInt();
        int answer = 0;
        char [] DNA = scanner.next().toCharArray();
        int [] check = new int[4];
         A = scanner.nextInt();
         C = scanner.nextInt();
         G = scanner.nextInt();
         T = scanner.nextInt();

        for(int i = 0; i<P; i++) {
            if(DNA[i] == 'A') check[0]++;
            if(DNA[i] == 'C') check[1]++;
            if(DNA[i] == 'G') check[2]++;
            if(DNA[i] == 'T') check[3]++;
        }

        if(checking(check)) {
            answer++;
        }

        int start = 0;

        for(int end = P; end < S; end++) {

            if(DNA[start] == 'A') check[0]--;
            if(DNA[start] == 'C') check[1]--;
            if(DNA[start] == 'G') check[2]--;
            if(DNA[start] == 'T') check[3]--;
            start++;
            ///

            if(DNA[end] =='A') check[0]++;
            if(DNA[end] == 'C') check[1]++;
            if(DNA[end] == 'G') check[2]++;
            if(DNA[end] == 'T') check[3]++;
            if(checking(check)) {
                answer++;
            }
        }
        System.out.println(answer);

    }

    public static boolean checking(int [] check) {
        if(check[0] < A) return false;
        else if(check[1] < C) return false;
        else if(check[2] < G) return false;
        else if(check[3] < T) return false;
        return true;
    }

}