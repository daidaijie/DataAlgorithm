package com.weiyeli.Leetcode.DP;

import java.util.ArrayList;
import java.util.List;

/**
 * 343. Integer Break
 */
public class LeetCode343 {

    private static List<Integer> list;

    private static int breakInteger(int n) {
        if (n == 1)
            return 1;

        if (list.get(n) != -1)
            return list.get(n);

        int res = -1;
        for (int i = 1; i <= n - 1; i++) {
            //i * n-1 的意思就是N-i不进行拆分
            res = Math.max(Math.max(res,i*(n-i)), i * breakInteger(n-i));
        }
        list.add(n, res);
        return res;
    }

    /**
     * 常规思路：记忆化搜索
     * @param n
     * @return
     */
    public static int integerBreak2(int n) {
        list = new ArrayList<Integer>(n+1);
        list.add(-1);
        for (int i = 1; i <= n; i++)
            list.add(i,-1);
        return breakInteger(n);
    }

    /**
     * 动态规划方法
     */
    public static int integerBreak3(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 1;

        //外层循环就是计算integerBreak(n)，迭代这个n
        for (int i = 3; i <= n; i++) {
            dp[i] = -1;
            //因为我们要计算 j*(i-j)和 j * dp[i-j]--因为i-j<i，所以dp[i-j]已经计算出来了
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(j * dp[i-j], Math.max(dp[i], j * (i-j)));
            }
        }

        return dp[n];
    }

    /**
     * 高级解法：数学公式
     * @param args
     */
    public int integerBreak(int n) {
        if (n == 2 || n == 3)
            return n-1;
        int res = 1;
        while (n > 4) {
            res *= 3;
            n -= 3;
        }
        return res * n;
    }

    public static void main(String[] args) {
        System.out.println(integerBreak2(10));
    }
}
