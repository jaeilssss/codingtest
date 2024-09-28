package com.market;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = scanner.nextInt();

        ArrayList<String> answerList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            String str = scanner.next();

            char[] carr = str.toCharArray();

            int index = carr.length - 1;
            int lastIndex = 0;
            int startIndex = -1;
            for (int j = index - 1; j >= 0; j--) {
                if (carr[index] > carr[j]) {
                    startIndex = j;
                    break;
                }
                index = j;
            }
            if (startIndex != -1) {
                for (int j = carr.length-1; j >= 0; j--) {
                    if (carr[startIndex] < carr[j]) {
                        char temp = carr[startIndex];
                        carr[startIndex] = carr[j];
                        carr[j] = temp;
                        Arrays.sort(carr, startIndex + 1, carr.length);
                        break;
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int k = 0; k < carr.length; k++) {
                sb.append(carr[k]);
            }
            answerList.add(sb.toString());
        }
        answerList.forEach(System.out::println);
    }
}