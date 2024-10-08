package com.market;

import java.util.*;


class Solution {
    public int solution(String A, String B) {
        // Implement your solution here

        A = A.replace(":","");
        B = B.replace(":","");

        int startTime = Integer.parseInt(A);
        int endTime = Integer.parseInt(B);

        for(int i = startTime; i< endTime; i++) {
            int second = i %100;

            if(second >= 60) {
                second = second-60;
                i -= 60;
                i += 100;
            }

            int minute = i % 10000;
            minute -= second;
            String minuteStr = String.valueOf(minute);

            minute = Integer.parseInt(minuteStr.substring(0,minuteStr.length()-2));
            if(minute >= 60) {
                minute = 60-minute;
                i -= 6000;
                i+=10000;
            }

            int hour = i / 100000;
            if(hour <=24) {
                hour = 0;
            }
        }
        return 0;
    }
}
