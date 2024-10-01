package com.market;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int answer = 0;
        ArrayList<Pillar> list = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            list.add(new Pillar(scanner.nextInt(), scanner.nextInt()));
        }


        Collections.sort(list);
        Stack<Pillar> stack = new Stack<>();
        int currentIndex = 0;
        for(int i = 0 ; i < N; i++) {
            Pillar p = list.get(i);

            if(stack.isEmpty()) {
                stack.push(p);
                currentIndex = i;
            } else {
                if(stack.peek().height < p.height) {
                    Pillar currentPillar = list.get(currentIndex);

                    answer += (p.position - currentPillar.position) * currentPillar.height;
                    stack.clear();
                    stack.push(p);
                } else {
                    stack.push(p);
                }
            }
        }

        if(!stack.isEmpty()) {
            if(stack.peek().height == list.get(currentIndex).height) {
                answer += (list.get(currentIndex).position - stack.peek().position) * stack.peek().height;
            }else {
                for(int i = 0; i<stack.size(); i++) {
                    answer += stack.peek().height;
                    stack.pop();
                }
            }
        }
        System.out.println(answer);
    }

    static class Pillar implements Comparable<Pillar> {
        private int position;
        private int height;

        public Pillar(int position, int height) {
            this.position = position;
            this.height = height;
        }


        @Override
        public int compareTo(Pillar o) {
            return position - o.position;
        }
    }
}