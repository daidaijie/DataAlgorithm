package com.weiyeli.Nowcoder.Tencent;

import java.util.Arrays;
import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        int[][] a = new int[n][2];
        for (int i = 0; i < n; i++) {
            a[i][0] = in.nextInt();
            a[i][1] = in.nextInt();
        }

        int[][] b = new int[m][2];
        for (int i = 0; i < m; i++) {
            b[i][0] = in.nextInt();
            b[i][1] = in.nextInt();
        }

        int res = 0;
        int sum = 0;

    }
}
