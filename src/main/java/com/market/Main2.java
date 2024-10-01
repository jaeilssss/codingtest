package com.market;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2 {

    public static int solve(int[] arr) {
        if (arr.length == 1)
            return arr[0];

        if (arr.length % 2 == 0) {
            return arr[arr.length / 2 - 1];
        } else {
            return arr[arr.length / 2];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int answer = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        answer = solve(arr);
        System.out.println(answer);
    }
}