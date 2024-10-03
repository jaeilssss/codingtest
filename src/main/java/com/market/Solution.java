package com.market;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;

        ArrayList<Misail> misails = new ArrayList<>();

        for(int i = 0 ; i <targets.length; i++) {
            misails.add(new Misail(targets[i][0], targets[i][1]));
        }

        Collections.sort(misails);

        int maxRange = 0;
        int maxPositon =0;
        for(int i = 0; i<misails.size(); i++) {
            Misail misail = misails.get(i);
            if(i==0){
                answer++;
                maxRange = misail.range;
                maxPositon = misail.x;
            } else {
                if(maxPositon < misail.x && maxPositon+maxRange < misail.x) {
                    answer++;
                }
                maxRange = misail.range;
                maxPositon = misail.x;
            }
        }
        return answer;
    }

    public static class Misail implements Comparable<Misail>{
        public int x;
        public int range;

        public Misail(int x, int range) {
            this.x = x;
            this.range = range;
        }

        @Override
        public int compareTo(Misail o) {
            return this.x - o.x;
        }
    }
}