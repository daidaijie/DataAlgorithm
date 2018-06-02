package com.weiyeli.Leetcode.DP;

/**
 * 62. Unique Paths
 */
public class LeetCode62 {
    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[n][m];
        dp[n - 1][m - 1] = 1;
        for (int i = n - 2; i >= 0; i--)
            dp[i][m - 1] = 1;
        for (int j = m - 2; j >= 0; j--)
            dp[n - 1][j] = 1;

        for (int i = n - 2; i >= 0; i--) {
            for (int j = m - 2; j >= 0; j--) {
                dp[i][j] = dp[i][j+1] + dp[i+1][j];
            }
        }

        return dp[0][0];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(7,3));
    }
}
