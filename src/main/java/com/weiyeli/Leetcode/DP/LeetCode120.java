package com.weiyeli.Leetcode.DP;

import java.util.List;

/**
 * 120. Triangle
 */
public class LeetCode120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int rows = triangle.size(), cols = triangle.get(rows - 1).size();
        int[][] dp = new int[rows][cols];
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = triangle.get(i).size()-1; j >=0; j--) {
                //最下面一行就是本身
                if (i == rows - 1) {
                    dp[i][j] = triangle.get(i).get(j);
                    continue;
                }
                dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i+1][j], dp[i+1][j+1]);
            }
        }

        return dp[0][0];
    }
}
