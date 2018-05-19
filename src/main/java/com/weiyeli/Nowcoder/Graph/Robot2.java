package com.weiyeli.Nowcoder.Graph;

/**
 * 机器人走方格2
 * https://www.nowcoder.com/practice/b3ae8b9782af4cf29253afb2f6d6907d?tpId=8&&tqId=11034&rp=1&ru=/activity/oj&qru=/ta/cracking-the-coding-interview/question-ranking
 */
public class Robot2 {

    private static final int MOD = 1000000007;

    public int countWays(int[][] map, int x, int y) {
        if (map == null || map.length == 0 || x < 0 || y < 0)
            return 0;

        //如果起点或者终点不能走，直接返回0
        if (map[0][0] == 0 || map[x - 1][y - 1] == 0)
            return 0;

        int[][] dp = new int[x + 1][y + 1];

        dp[0][0] = 1;

        //第一行只能从左边来
        for (int i = 1; i < x; i++) {
            
        }

        //第一列只能从上面来
        for (int j = 1; j < y; j++) {
            if (map[j][0] == 0)
                map[j][0] = 1;
            else map[j][0] = map[j-1][0];
        }


        return dp[x - 1][y - 1];
    }
}
