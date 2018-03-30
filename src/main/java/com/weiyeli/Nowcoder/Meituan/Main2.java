package com.weiyeli.Nowcoder.Meituan;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = {1, 5, 10, 20, 50, 100};
        System.out.println("暴力搜索法: " + dp(a, 0, n));
        System.out.println("记忆搜索法: " + coins2(a, n));
        System.out.println("动态规划法: " + coins3(a, n));
        System.out.println("一维动态规划法: " + coins4(a,n));
    }

    /**
     * 暴力搜索法：用arr[index,length-1]这些面值的钱组成aim
     *
     * @param arr
     * @param index
     * @param aim
     * @return
     */
    private static int dp(int[] arr, int index, int aim) {
        int res = 0;
        if (index == arr.length) {
            return res = aim == 0 ? 1 : 0;
        } else {
            // 从0到最大的能用index组成aim的那么多种
            for (int i = 0; arr[index] * i <= aim; i++) {
                // 递归考虑下一步
                res += dp(arr, index + 1, aim - arr[index] * i);
            }
        }
        return res;
    }

    public static long coins2(int[] arr, int aim) {
        long[][] dp = new long[arr.length + 1][aim + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        return dp2(arr, 0, aim, dp);
    }


    /**
     * 记忆搜索法
     *
     * @param arr
     * @param index
     * @param aim
     * @return
     */
    private static long dp2(int[] arr, int index, int aim, long[][] dp) {
        long res = 0;
        if (index == arr.length) {
            res = aim == 0 ? 1 : 0;
        } else {
            long map = 0;
            // 从0到最大的能用index组成aim的那么多种
            for (int i = 0; arr[index] * i <= aim; i++) {
                // 递归考虑下一步
                map = dp[index + 1][aim - arr[index] * i];
                if (map != -1) {
                    res += map;
                } else {
                    res += dp2(arr, index + 1, aim - arr[index] * i, dp);
                }
            }
        }
        dp[index][aim] = res;
        return res;
    }

    /**
     * 动态规划方法
     * dp[i][j]的含义是在使用arr[0..i]种货币的情况下，组成钱数j有多少方法
     *
     * @param arr
     * @param aim
     * @return
     */
    public static long coins3(int[] arr, int aim) {
        long[][] dp = new long[arr.length][aim + 1];
        // 初始状态
        for (int i = 0; i < dp.length; i++)
            dp[i][0] = 1;
        for (int i = 0; i <= aim; i++) {
            //第一行就是只能用arr[0]这种货币，aim只能是arr[0]的整数倍
            int n = arr[0];
            if (i % n == 0) dp[0][i] = 1;
            else dp[0][i] = 0;
        }

        //从上到下，从左到右
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j <= aim; j++) {
                // 判断总的目标数是否大于当前的钱的面值
                // 如果小于，则在前i-1项里面拼凑j
                if (arr[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - arr[i]];
                }
            }
        }

        return dp[arr.length - 1][aim];
    }

    /**
     * 一维数组动态规划方法
     */
    public static long coins4(int[] arr, int aim) {
        // 表示每种钱数j有多少种拼凑方法
        long[] dp = new long[aim + 1];
        dp[0] = 1;
        for (int i = 1; i <= aim; i++) {
            if (i % arr[0] == 0) dp[i] = 1;
            else dp[i] = 0;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j <= aim; j++) {
                if (j >= arr[i])
                    dp[j] = dp[j] + dp[j-arr[i]];
            }
        }

        return dp[aim];
    }
}
