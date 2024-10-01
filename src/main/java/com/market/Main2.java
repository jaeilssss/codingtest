package com.market;


import java.util.Scanner;

public class Main2 {
    public static void main(String[] args)  {

        Scanner scanner = new Scanner(System.in);

        int C = scanner.nextInt();
        int R = scanner.nextInt();

        int [][] arr = new int[R][C];

        int UpC = 0;
        int rightR = 0;
        int downC = 0;
        int leftR = R-1;

        int [] dx = {-1,0,1,0};
        int [] dy = {0,1,0,-1};

        int count = 1;
        int x = R;
        int y = 0;
        int dIndex = 0;

        while(count <= C*R) {

            while(true) {
                if(count >C*R) break;

                x += dx[dIndex];
                y += dy[dIndex];
                if(x<0 || y<0 || x>=R || y>=C) {
                   x -= dx[dIndex];
                   y -= dy[dIndex];
                   break;
                } else if(arr[x][y] != 0){
                    x -= dx[dIndex];
                    y -= dy[dIndex];
                    break;
                }
                arr[x][y] = count++;
            }
            dIndex++;
            dIndex %=4;

        }
       int n = scanner.nextInt();
        if(n > C*R) System.out.println(0);
        else {
            for(int i = 0 ; i<R; i++) {
                for(int j = 0; j<C; j++){
                    if(arr[i][j] == n) {
                        int answerX = R-i;
                        int answerY = j+1;
                        System.out.println(answerY+ " " + answerX);
                    }
                }
            }
        }

    }
}