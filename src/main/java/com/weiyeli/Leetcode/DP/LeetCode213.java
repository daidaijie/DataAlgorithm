package com.weiyeli.Leetcode.DP;

/**
 * 213. House Robber II
 */
public class LeetCode213 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];

        //在198题中，因为不是环，所以默认是买第一个的，这样最后一个我们就不能买
        //这这个题目要分成两种情况
        //1.买第一个那么范围就是[1,n-1]，也就是第一家店到倒数第二家店
        //2.不买第一个范围是[2,n]，第二家店到最后一家店
        return Math.max(robBasic(nums, 0, nums.length - 2), robBasic(nums, 1, nums.length - 1));
    }

    //这里的preMax和currMax相当于滚动数组，这里就叫滚动变量吧
    //preMax相当于198题的dp[i-2]，也就是不相邻的上一个
    //currMax相当于dp[i-1]，也就是继承前一个
    private int robBasic(int[] nums, int start, int end) {
        int preMax = 0;
        int currMax = 0;

        for (int i = start; i <= end; i++) {
            int temp = currMax;
            currMax = Math.max(currMax, preMax + nums[i]);
            preMax = temp;
        }
        return currMax;
    }
}
