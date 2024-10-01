package com.market;


import java.util.Scanner;
import java.util.Stack;

public class Main2 {
    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        Stack<HomeWork> stack = new Stack<>();
        int answer = 0;
        for(int i = 0 ; i < N; i++) {
            int a = scanner.nextInt();
            if(a == 0) {
                if(!stack.isEmpty()) {
                    HomeWork homeWork = stack.pop();
                    homeWork.t--;
                    if(homeWork.t ==0){
                        answer += homeWork.point;
                        continue;
                    }
                    stack.push(homeWork);

                }
            } else {
                int point = scanner.nextInt();
                int t = scanner.nextInt();
                t--;
                if(t==0) {
                    answer += point;
                    continue;
                }
                stack.push(new HomeWork(point, t));
            }
        }
        System.out.println(answer);
    }

    static class HomeWork {
        public int point;
        public int t;

        public HomeWork(int point, int t) {
            this.point = point;
            this.t = t;
        }
    }
}