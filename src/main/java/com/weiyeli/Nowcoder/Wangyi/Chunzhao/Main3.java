package com.weiyeli.Nowcoder.Wangyi.Chunzhao;


import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] job = new int[n][2];
        int[] ab = new int[m];

        for (int i = 0; i < n; i++) {
            job[i][0] = scanner.nextInt();
            job[i][1] = scanner.nextInt();
        }

        for (int i = 0; i < m; i++) {
            ab[i] = scanner.nextInt();
        }

        for (int i = 0; i < m; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < n; j++) {
                if (ab[i] >= job[i][0] & job[i][1] > max)
                    max = job[i][1];
            }

            System.out.println(max);
        }
    }
}
