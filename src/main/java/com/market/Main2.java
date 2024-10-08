package com.market;
import javax.swing.plaf.synth.SynthTableHeaderUI;
import java.awt.*;
import java.io.BufferedReader;

import java.util.*;

public class Main2 {

    static Integer[][] dp;
    static int zeroCount = 0;
    static int oneCount = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        dp = new Integer[41][2];
        int N = scanner.nextInt();
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;
        for (int i = 0; i < N; i++) {
            int num = scanner.nextInt();
            Integer [] result = fibonacci(num);
            System.out.println(result[0] + " " + result[1]);
        }
    }

    public static Integer[] fibonacci(int i) {

        if(dp[i][0] == null || dp[i][1] ==null) {
            dp[i][0] = fibonacci(i-1)[0] + fibonacci(i-2)[0];
            dp[i][1] = fibonacci(i-1)[1] + fibonacci(i-2)[1];
        }
        return dp[i];
    }
}