package com.weiyeli.Leetcode.DP;

/**
 * 300. Longest Increasing Subsequence
 */
public class LeetCode300 {

    //在数组a里面找到第一个大于等于k的位置
    //二分搜索
    public static int findIndex(int[] a, int r, int k) {
        int l = 0;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (a[mid] < k)
                l = mid + 1;
            else if (a[mid] > k)
                r = mid;
            else return mid;
        }
        return r;
    }


    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        //dp[i]表示的是长度为i+1的LIS的末尾最小值
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > dp[j-1]) {
                dp[j++] = nums[i];
            } else {
                dp[findIndex(dp, j - 1, nums[i])] = nums[i];
            }
        }

        return j;
    }

    public static void main(String[] args) {
        int[] a = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS(a));
    }
}
