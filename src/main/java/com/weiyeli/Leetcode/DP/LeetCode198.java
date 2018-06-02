package com.weiyeli.Leetcode.DP;

/**
 * 198. House Robber
 * 这个题跟01背包的区别就是没有重量的限制，纯粹求最大值就可以了
 */
public class LeetCode198 {
    public int rob(int[] nums) {
        if (nums == null || nums.length <= 0)
            return 0;

        if (nums.length == 1)
            return nums[0];

        int length = nums.length;

        //dp[i]表示的是前i个店铺所能偷到的最大值
        int[] dp = new int[length];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        //这个题其实有点像01背包，对于每一个店铺，我们只要判断偷还是不偷就好了
        //dp[i-2] + nums[i]的意思就是偷这家店，那么我们我们就计算隔着的前一个dp[i-2]
        //如果不偷，就继承前一个的值
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }

        return dp[length - 1];
    }
}
