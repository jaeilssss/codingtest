package com.market;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];

        Stack<HomeWork> stack = new Stack<>();
        int answerIdx = 0;
        ArrayList<HomeWork> list = new ArrayList<>();
        for(int i = 0 ; i<plans.length; i++) {
            list.add(new HomeWork(plans[i][0], plans[i][1], plans[i][2]));
        }
        Collections.sort(list);
        for(int i =0; i < list.size(); i++) {
            HomeWork homeWork = list.get(i);
            if(stack.isEmpty()) stack.push(homeWork);
            else if(stack.peek().getClearTime().compareTo(homeWork.start) > 0) {
                stack.push(homeWork);
            } else {
                while (true) {
                    if(stack.isEmpty()) break;
                    if(stack.peek().getClearTime().compareTo(homeWork.start) <= 0) {
                        answer[answerIdx++] = stack.pop().name;
                    } else {
                        break;
                    }
                }
                stack.push(homeWork);
            }
        }
        while (!stack.isEmpty()) {
            answer[answerIdx++] = stack.pop().name;
        }
        return answer;
    }

    static class HomeWork implements Comparable<HomeWork>{
        public String name;
        public String start;
        public String playTime;

        public HomeWork(String name, String start, String playTime) {
            this.name = name;
            this.start = start;
            this.playTime = playTime;
        }

        public String getClearTime() {
            String [] time = start.split(":");

            int hour = Integer.parseInt(time[0]);
            int minute = Integer.parseInt(time[1]);
            int playTimeInteger = Integer.parseInt(playTime);

            minute += playTimeInteger;
            hour += minute / 60;
            minute = minute % 60;

            return hour + ":" + minute;
        }

        @Override
        public int compareTo(HomeWork o) {
            return this.start.compareTo(o.start);
        }
    }
}