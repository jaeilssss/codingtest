package com.market;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.next();
        StringBuilder answer = new StringBuilder();
        String [] splitString = s.split("::");

        int gap = 8-s.split(":").length;
        StringBuilder sb = new StringBuilder();
        if(s.substring(0,2).equals("::")) {
            for(int i = 0 ; i<gap+2; i++) {
                sb.append("0000:");
            }
        } else {
            for(int i = 0 ; i<gap+1; i++) {
                sb.append(":0000:");
            }
        }
        String temp  = sb.toString().replace("::",":");
        s = s.replace("::", temp);
        String [] splitString2 = s.split(":");

        for(int j = 0; j<splitString2.length; j++) {
            gap = 4- splitString2[j].length();
            if(!splitString2[j].equals("")){
                for(int k = 0; k<gap; k++) {
                    splitString2[j] = "0"+splitString2[j];
                }
            }
        }

        for(int i = 0 ; i<8; i++) {
            if(i!=0) {
                answer.append(":");
            }
            answer.append(splitString2[i]);
        }

        System.out.println(answer.toString());
    }
}