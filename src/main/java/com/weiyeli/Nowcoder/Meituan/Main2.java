package com.weiyeli.Nowcoder.Meituan;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = {1, 5, 10, 20, 50, 100};
//        System.out.println(dp(a, 0, n));
        System.out.println(coins2(a, n));
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
}
