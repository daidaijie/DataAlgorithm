package com.weiyeli.Leetcode.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 279. Perfect Squares
 */
public class LeetCode279 {


    public int numSquares2(int n) {

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            int sqr = (int)Math.sqrt(n);
            //如果这个数是完全平方数，直接赋1
            if (sqr * sqr == i) {
                dp[i] = 1;
                continue;
            }
            for (int j = 1; j <= i / 2; j++) {
                dp[i] = Math.min(dp[i], dp[i] + dp[i - j]);
            }
        }
        return dp[n];
    }

    public int numSquares(int n) {
        if (n <= 0)
            return 0;

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {

    }
}
