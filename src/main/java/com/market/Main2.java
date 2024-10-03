package com.market;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main2 {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        StringBuilder sb = new StringBuilder();
        char [] arr = new char[N];
        for(int i = 0 ; i<N; i++) {
            sb.append(scanner.next());
        }
        arr = sb.toString().toCharArray();

        int lastIdx = arr.length-1;
        int startIdx = -1;

        for(int i = arr.length-2 ; i>=0; i--) {

           if(arr[lastIdx] - arr[i] < 0) {
               startIdx = i;
               break;
           }
        }
        if(startIdx ==-1) {
            System.out.println(-1);
            return;
        }
        sb = new StringBuilder();
        for(int i = 0; i < arr.length-1; i++) {

            if(i == startIdx) {
                startIdx = i;
                sb.append(arr[arr.length - 1]);

                sb.append(arr[i]);

            } else {
                sb.append(arr[i]);

            }

        }
        ArrayList<Character> list = new ArrayList<Character>();

        char [] carr = sb.toString().toCharArray();
        for(int  i = startIdx+2; i < arr.length; i++) {
            list.add(carr[i]);

        }
        list.sort(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return o2-o1;
            }
        });

        sb = new StringBuilder();
        int listIdx = 0;
        for(int i = 0 ; i< carr.length; i++) {
            if(i>startIdx+1) {
                sb.append(list.get(listIdx++));
                sb.append(" ");
            } else {
               sb.append(carr[i]);
               sb.append(" ");
            }
        }

        if(startIdx != -1) {
            System.out.println(sb.toString());

        } else {
            System.out.println(-1);

        }
    }

}