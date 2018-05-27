package com.weiyeli.Leetcode.DP;

/**
 * Problem 53
 * Maximum Subarray
 * 最大字数组
 * https://blog.csdn.net/linhuanmars/article/details/21314059
 */
public class LeetCode53 {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        //全局最优解
        int global = nums[0];

        //局部最优解
        int local = nums[0];

        for (int i = 1; i < nums.length; i++) {
            //局部最优解必须包含当前元素
            local = Math.max(nums[i], local + nums[i]);
            //因为local先更新，所以这里的local已经是新的值
            global = Math.max(global, local);
        }

        return global;
    }
}
