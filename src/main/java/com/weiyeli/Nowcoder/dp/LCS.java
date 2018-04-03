package com.weiyeli.Nowcoder.dp;

/**
 * 最长公共子序列
 */
public class LCS {

    public int findLCS(String a, int n, String b, int m) {
        char[] str1 = a.toCharArray();
        char[] str2 = b.toCharArray();
        // dp[i][j]表示的是str1[0..i]和str2[0..j]的最长公共子序列
        int[][] dp = new int[n+1][m+1];
        // 首先判断第一行和第一列
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            if (str1[i] == str2[0]) {
                dp[i][0] = 1;
                flag = true;
            }
            if (flag)
                dp[i][0] = 1;
        }

        flag = false;
        for (int i = 0; i < m; i++) {
            if (str1[0] == str2[i]) {
                dp[0][i] = 1;
                flag = true;
            }
            if (flag)
                dp[0][i] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (str1[i] != str2[j]) {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                } else {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
            }
        }

        return dp[n-1][m-1];
    }
}
