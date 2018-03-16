package com.weiyeli.JianZhiOffer.chapter5;

/**
 * 连续子数组的最大和
 */
public class FindGreatestSumOfSubArray {

    // 常规思路
    public static int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length <= 0)
            return -1;

        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (sum <= 0)
                sum = array[i];
            else
                sum += array[i];

            if (sum > max)
                max = sum;
        }

        return max;
    }

    //动态规划思路
    public static int FindGreatestSumOfSubArray2(int[] array) {
        if (array == null || array.length <= 0)
            return -1;

        int[] dp = new int[array.length];
        dp[0] = array[0];
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            dp[i] = getMax(array[i] + dp[i - 1], array[i]);

            if (dp[i] > max)
                max = dp[i];
        }

        return max;
    }

    public static int getMax(int a, int b) {
        return a > b ? a : b;
    }

    public static void main(String[] args) {
        int[] a = {6, -3, -2, 7, -15, 1, 2, 2};
        System.out.println(FindGreatestSumOfSubArray(a));
        System.out.println(FindGreatestSumOfSubArray2(a));
    }
}
