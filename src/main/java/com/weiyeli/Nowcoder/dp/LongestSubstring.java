package com.weiyeli.Nowcoder.dp;

/**
 * 最长公共子串
 * 参考博客：http://www.cnblogs.com/dartagnan/archive/2011/10/06/2199764.html
 * 缺点：只能找到一个解，找不到所有的解
 */
public class LongestSubstring {
    public int findLongest(String a, int n, String b, int m) {
        if (a == null || b == null || n == 0 || m == 0)
            return 0;

        int[][] dp = new int[n][m];
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a.charAt(i) == b.charAt(j)) {
                    // 如果是第一排或者第一列直接赋值1即可
                    if (i==0 || j==0)
                        dp[i][j] = 1;
                    else {
                        //赋值为左上角的那个值再加1
                        dp[i][j] = dp[i-1][j-1] + 1;
                        if (dp[i][j] > max)
                            max = dp[i][j];
                    }
                }
            }
        }
        return max;
    }
}
