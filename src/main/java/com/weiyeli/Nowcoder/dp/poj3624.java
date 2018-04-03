package com.weiyeli.Nowcoder.dp;

import java.util.Scanner;

/**
 * 0-1背包问题
 */
public class poj3624 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] w = new int[n];
        int[] v = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
            v[i] = scanner.nextInt();
        }


        int[] dp = new int[m + 1];
        // dp[j]表示的是用a[0..i]个宝石在重量J下的最大的魅力值
        for (int j = 1; j <= m; j++) {
            if (w[0] <= j) {
                dp[j] = v[0];
            }
        }


        for (int i = 1; i < n; i++) {
            for (int j = m; j >= w[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - w[i]] + v[i]);
            }
        }

        System.out.println(dp[m]);
    }
}
