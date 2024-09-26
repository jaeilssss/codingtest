package com.market;

import java.awt.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int r = scanner.nextInt();
        int c = scanner.nextInt();
        int n = scanner.nextInt();
        String [][] arr = new String[r][c];
        int [][] boomTime = new int[r][c];
        for(int i = 0 ; i < r; i++) {
            String s = scanner.next();
            for(int j = 0 ; j < s.length(); j++) {
                arr[i][j] = s.substring(j,j+1);
                if(arr[i][j].equals("O")) {
                    boomTime[i][j] = 3;
                }
            }
        }

        int [] dx = {0,1,-1,0};
        int [] dy = {1,0,0,-1};

       for(int t = 1; t <=n; t++) {
            if(t%2==0) {
                for(int i =0 ; i<r; i++) {
                    for(int j = 0; j<c; j++) {
                        if(arr[i][j].equals(".")) {
                            arr[i][j] = "O";
                            boomTime[i][j] = t+3;
                        }
                    }
                }
            } else {
                for(int i = 0; i<r; i++) {
                    for(int j =0; j <c; j++) {
                        if(arr[i][j].equals("O") && t == boomTime[i][j]) {
                            boomTime[i][j] = 0;
                            arr[i][j] = ".";

                            for(int k = 0; k <4; k++) {
                                if((i+dx[k] >=0 && i+dx[k] <r) && (j+dy[k] >=0 && j+dy[k] <c)) {
                                    if(t != boomTime[i+dx[k]][j+dy[k]]) {
                                        boomTime[i+dx[k]][j+dy[k]] = 0;
                                        arr[i+dx[k]][j+dy[k]] = ".";
                                    }
                                }
                            }
                        }
                    }
                }
            }
       }

       for(int i = 0 ; i<r; i++){
            for(int j = 0; j<c; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
       }
    }
}