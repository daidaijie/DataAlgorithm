package com.weiyeli.Nowcoder.Wangyi.Chunzhao;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] lx = new int[n];
        int[] ly = new int[n];
        int[] rx = new int[n];
        int[] ry = new int[n];
        for (int i = 0; i < n; i++) {
            lx[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            ly[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            rx[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            ry[i] = scanner.nextInt();
        }

        //首先找出所有矩形的中心
        double[][] yx = new double[n][2];
        for (int i = 0; i < n; i++) {
            yx[i][0] = (lx[i] + rx[i])/2;
            yx[i][1] = (ly[i] + ry[i])/2;
        }


    }
}
